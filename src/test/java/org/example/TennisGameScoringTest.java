package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TennisGameScoringTest {

    @Test
    public void on_Even_shouldReturnLoveLove() {
        TennisGameScoring game = new TennisGameScoring();
        String result = game.transformScoreToText(0, 0);
        assertEquals("Love-Love", result);
    }

    @Test
    public void on_PlayerOneFifteenLove_shouldReturnFifteenLove() {
        TennisGameScoring game = new TennisGameScoring();
        String result = game.transformScoreToText(15, 0);
        assertEquals("Fifteen-Love", result);
    }

    @Test
    public void on_PlayerOneThirtyFifteen_shouldReturnThirtyFifteen() {
        TennisGameScoring game = new TennisGameScoring();
        String result = game.transformScoreToText(30, 15);
        assertEquals("Thirty-Fifteen", result);
    }

    @Test
    public void on_BothForty_shouldReturnDeuce() {
        TennisGameScoring game = new TennisGameScoring();
        String result = game.transformScoreToText(40, 40);
        assertEquals("Deuce", result);
    }

    @Test
    public void on_PlayerOneAdvantage_shouldReturnAdvantagePlayer1() {
        TennisGameScoring game = new TennisGameScoring();
        String result = game.transformScoreToText(50, 40);
        assertEquals("Advantage player 1", result);
    }

    @Test
    public void on_PlayerTwoAdvantage_shouldReturnAdvantagePlayer2() {
        TennisGameScoring game = new TennisGameScoring();
        String result = game.transformScoreToText(40, 50);
        assertEquals("Advantage player 2", result);
    }

    @Test
    public void on_PlayerOneWins_shouldReturnPlayer1WinsGame() {
        TennisGameScoring game = new TennisGameScoring();
        String result = game.transformScoreToText(60, 40);
        assertEquals("Player 1 wins Game", result);
    }

    @Test
    public void on_PlayerTwoWins_shouldReturnPlayer2WinsGame() {
        TennisGameScoring game = new TennisGameScoring();
        String result = game.transformScoreToText(40, 60);
        assertEquals("Player 2 wins Game", result);
    }

    @Test
    public void on_ThirtyThirty_shouldReturnThirtyThirty() {
        TennisGameScoring game = new TennisGameScoring();
        String result = game.transformScoreToText(30, 30);
        assertEquals("Thirty-Thirty", result);
    }

    @Test
    public void on_ThirtyForty_shouldReturnThirtyForty() {
        TennisGameScoring game = new TennisGameScoring();
        String result = game.transformScoreToText(30, 40);
        assertEquals("Thirty-Forty", result);
    }
}
