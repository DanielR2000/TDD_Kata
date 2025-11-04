package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TennisMatchTest {

    @Test
    public void test_Player1WinsMatch_3_0() {
        TennisMatch match = new TennisMatch();

        for (int i = 0; i < 18; i++) { // 6 juegos * 3 sets
            String result = match.addGameToPlayer(1);
            if (result.contains("wins match")) {
                assertEquals("Player 1 wins match", result);
                return;
            }
        }
    }

    @Test
    public void test_Player2WinsMatch_3_2() {
        TennisMatch match = new TennisMatch();

        // Player 1 gana 2 sets
        for (int s = 0; s < 2; s++) {
            for (int g = 0; g < 6; g++) match.addGameToPlayer(1);
        }

        // Player 2 gana 3 sets
        for (int s = 0; s < 3; s++) {
            for (int g = 0; g < 6; g++) {
                String result = match.addGameToPlayer(2);
                if (result.contains("wins match")) {
                    assertEquals("Player 2 wins match", result);
                    return;
                }
            }
        }

    }

    @Test
    public void test_CurrentSetProgress() {
        TennisMatch match = new TennisMatch();
        String result = match.addGameToPlayer(1);
        assertTrue(result.contains("Current set"));
    }

    @Test
    public void test_NewSetStartsAfterWin() {
        TennisMatch match = new TennisMatch();

        // Player 1 gana primer set
        for (int g = 0; g < 6; g++) match.addGameToPlayer(1);

        // Empieza nuevo set
        String result = match.addGameToPlayer(2);
        assertTrue(result.contains("Current set"));
        assertEquals(1, match.getPlayer1Sets());
        assertEquals(0, match.getPlayer2Sets());
    }

    @Test
    public void test_NoMatchWinBefore3Sets() {
        TennisMatch match = new TennisMatch();

        for (int s = 0; s < 2; s++) {
            for (int g = 0; g < 6; g++) {
                String result = match.addGameToPlayer(1);
                assertFalse(result.contains("wins match"));
            }
        }
    }
}
