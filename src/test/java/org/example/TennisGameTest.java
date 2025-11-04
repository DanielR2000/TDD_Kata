package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TennisGameTest {

    @Test
    public void test_Player1WinsGame_4_0() {
        TennisGame game = new TennisGame();
        String result = "";

        for (int i = 0; i < 4; i++) {
            result = game.addPointToPlayer(1);
        }

        assertEquals("Player 1 wins Game", result);
        assertTrue(game.isFinished());
    }

    @Test
    public void test_Player2WinsGame_4_2() {
        TennisGame game = new TennisGame();

        game.addPointToPlayer(1); // 15–0
        game.addPointToPlayer(2); // 15–15
        game.addPointToPlayer(2); // 15–30
        game.addPointToPlayer(1); // 30–30
        game.addPointToPlayer(2); // 30–40
        String result = game.addPointToPlayer(2); // gana Player 2

        assertEquals("Player 2 wins Game", result);
        assertTrue(game.isFinished());
    }

    @Test
    public void test_DeuceAt40_40() {
        TennisGame game = new TennisGame();

        game.addPointToPlayer(1);
        game.addPointToPlayer(1);
        game.addPointToPlayer(1);

        game.addPointToPlayer(2);
        game.addPointToPlayer(2);
        String result = game.addPointToPlayer(2); // 40–40

        assertEquals("Deuce", result);
        assertFalse(game.isFinished());
    }

    @Test
    public void test_AdvantagePlayer1_AfterDeuce() {
        TennisGame game = new TennisGame();

        // llegar a Deuce
        for (int i = 0; i < 3; i++) {
            game.addPointToPlayer(1);
            game.addPointToPlayer(2);
        }

        String result = game.addPointToPlayer(1);
        assertEquals("Advantage player 1", result);
        assertFalse(game.isFinished());
    }

    @Test
    public void test_AdvantagePlayer2_AfterDeuce() {
        TennisGame game = new TennisGame();

        for (int i = 0; i < 3; i++) {
            game.addPointToPlayer(1);
            game.addPointToPlayer(2);
        }

        String result = game.addPointToPlayer(2);
        assertEquals("Advantage player 2", result);
        assertFalse(game.isFinished());
    }

    @Test
    public void test_Player1WinsAfterAdvantage() {
        TennisGame game = new TennisGame();

        for (int i = 0; i < 3; i++) {
            game.addPointToPlayer(1);
            game.addPointToPlayer(2);
        }

        game.addPointToPlayer(1); // Advantage
        String result = game.addPointToPlayer(1); // Gana

        assertEquals("Player 1 wins Game", result);
        assertTrue(game.isFinished());
    }

    @Test
    public void test_CurrentScore_30_15() {
        TennisGame game = new TennisGame();

        game.addPointToPlayer(1); // 15–0
        game.addPointToPlayer(2); // 15–15
        String result = game.addPointToPlayer(1); // 30–15

        assertEquals("Thirty-Fifteen", result);
        assertFalse(game.isFinished());
    }

    @Test
    public void test_CurrentScore_40_30() {
        TennisGame game = new TennisGame();

        game.addPointToPlayer(1); // 15–0
        game.addPointToPlayer(1); // 30–0
        game.addPointToPlayer(2); // 30–15
        String result = game.addPointToPlayer(1); // 40–15

        assertEquals("Forty-Fifteen", result);
        assertFalse(game.isFinished());
    }

    @Test
    public void test_AddPointAfterGameFinished_ShouldReturnMessage() {
        TennisGame game = new TennisGame();

        for (int i = 0; i < 4; i++) {
            game.addPointToPlayer(1);
        }

        String result = game.addPointToPlayer(1); // Intento extra
        assertEquals("Game already finished", result);
    }
}
