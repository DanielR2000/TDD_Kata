package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BackScoringTest {

    @Test
    public void on_Even_shouldReturnLoveLove() {
        //Arrange
        TennisGameScoring tennisGameScoring = new TennisGameScoring();

        //Act
        String result = tennisGameScoring.transformScoreToText(0, 0);

        //Assert
        assertEquals("Love-Love", result);
    }

    @Test
    public void on_PlayerOneFifteenLove_shouldReturnFifteenLove() {
        //Arrange
        TennisGameScoring tennisGameScoring = new TennisGameScoring();

        //Act
        String result = tennisGameScoring.transformScoreToText(15, 0);

        //Assert
        assertEquals("Fifteen-Love", result);
    }

    @Test
    public void on_PlayerOneThirtyFifteen_shouldReturnThirtyFifteen() {
        //Arrange
        TennisGameScoring tennisGameScoring = new TennisGameScoring();

        //Act
        String result = tennisGameScoring.transformScoreToText(30, 15);

        //Assert
        assertEquals("Thirty-Fifteen", result);
    }

    @Test
    public void on_EvenForty_shouldReturnDeuce() {
        //Arrange
        TennisGameScoring tennisGameScoring = new TennisGameScoring();

        //Act
        String result = tennisGameScoring.transformScoreToText(40, 40);

        //Assert
        assertEquals("Deuce", result);
    }

    @Test
    public void on_PlayerOneAdvantage_shouldReturnAdvantagePlayer1() {
        //Arrange
        TennisGameScoring tennisGameScoring = new TennisGameScoring();

        //Act
        String result = tennisGameScoring.transformScoreToText(50, 40);

        //Assert
        assertEquals("Advantage player 1", result);
    }

    @Test
    public void on_PlayerTwoAdvantage_shouldReturnAdvantagePlayer2() {
        //Arrange
        TennisGameScoring tennisGameScoring = new TennisGameScoring();

        //Act
        String result = tennisGameScoring.transformScoreToText(40, 50);

        //Assert
        assertEquals("Advantage player 2", result);
    }

    @Test
    public void on_PlayerOneWins_shouldReturnPlayer1Wins() {
        //Arrange
        TennisGameScoring tennisGameScoring = new TennisGameScoring();

        //Act
        String result = tennisGameScoring.transformScoreToText(60, 40);

        //Assert
        assertEquals("Player 1 wins", result);
    }

    @Test
    public void on_PlayerTwoWins_shouldReturnPlayer2Wins() {
        //Arrange
        TennisGameScoring tennisGameScoring = new TennisGameScoring();

        //Act
        String result = tennisGameScoring.transformScoreToText(40, 60);

        //Assert
        assertEquals("Player 2 wins", result);
    }

    //-------------------------------------------------------------------------------------------------------------------

    @Test
    public void test_Player1WinsSet_6_0() {
        TennisSet set = new TennisSet();

        for (int i = 0; i < 6; i++) {
            set.addGameToPlayer(1);
        }

        assertEquals("Player 1 wins set", set.addGameToPlayer(1));
    }

    @Test
    public void test_TiebreakActivation() {
        TennisSet set = new TennisSet();

        for (int i = 0; i < 6; i++) {
            set.addGameToPlayer(1);
            set.addGameToPlayer(2);
        }

        assertTrue(set.isTieBreakActive());
    }

    @Test
    public void test_Player2WinsSet_7_5() {

        TennisSet set = new TennisSet();
        for (int i = 0; i < 5; i++) {
            set.addGameToPlayer(1);
            set.addGameToPlayer(2);
        }
        set.addGameToPlayer(2);
        set.addGameToPlayer(2);

        assertEquals("Player 2 wins set", set.addGameToPlayer(2));
    }

    //-------------------------------------------------------------------------------------------------

    @Test
    void test_Player1WinsMatch_3_0() {
        TennisMatch match = new TennisMatch();

        // Ganar 3 sets seguidos
        for (int i = 0; i < 18; i++) {
            String result = match.addGameToPlayer(1);
            if (result.contains("wins match")) {
                assertEquals("Player 1 wins match", result);
                break;
            }
        }
    }

    //--------------------------------------------------------------------------

    @Test
    public void test_Player1WinsTieBreak_6_0() {
        TennisTiebrake tiebrake = new TennisTiebrake();
        TennisMatch tennisMatch = new TennisMatch();

        //Ganar Tiebrake 6-0
        for (int i = 0; i < 3; i++){
            tennisMatch.addSetToPlayer(1);
            tennisMatch.addSetToPlayer(2);
        } //Igualados a 3 sets, se activa TieBrake

        for (int i = 0; i < 5; i++) {
            tiebrake.addPointToPlayer(1);
        } //Ganaría jugador 1 6-0

        assertEquals("Player 1 Wins Tiebrake", tiebrake.addPointToPlayer);

    }





}
