package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TennisSetTest {

    @Test
    public void test_Player1WinsSet_6_0() {
        TennisSet set = new TennisSet();
        String result = "";
        for (int i = 0; i < 6; i++) {
            result = set.addGameToPlayer(1);
        }
        assertEquals("Player 1 wins set", result);
    }

    @Test
    public void test_Player2WinsSet_7_5() {
        TennisSet set = new TennisSet();

        for (int i = 0; i < 5; i++) {
            set.addGameToPlayer(1);
            set.addGameToPlayer(2);
        }

        set.addGameToPlayer(2);
        String result = set.addGameToPlayer(2);

        assertEquals("Player 2 wins set", result);
    }

    @Test
    public void test_CurrentSetScoreBeforeWin() {
        TennisSet set = new TennisSet();
        set.addGameToPlayer(1);
        set.addGameToPlayer(2);
        set.addGameToPlayer(1);
        String result = set.addGameToPlayer(1);
        assertEquals("Current set: 3-1", result);
    }

    @Test
    public void test_SetNotFinishedAt6_5() {
        TennisSet set = new TennisSet();

        for (int i = 0; i < 5; i++) {
            set.addGameToPlayer(1);
            set.addGameToPlayer(2);
        }
        set.addGameToPlayer(1); // 6–5
        String result = set.addGameToPlayer(1); // 7–5 -> gana
        assertEquals("Player 1 wins set", result);
    }

    @Test
    public void test_NoSetWinAt5_5() {
        TennisSet set = new TennisSet();

        for (int i = 0; i < 5; i++) {
            set.addGameToPlayer(1);
            set.addGameToPlayer(2);
        }

        String result = set.addGameToPlayer(1); // 6–5
        assertEquals("Current set: 6-5", result);
    }
}
