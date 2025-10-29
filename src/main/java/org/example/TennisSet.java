package org.example;

public class TennisSet {
    private int player1Games;
    private int player2Games;
    private boolean tieBreakActive = false;

    public String addGameToPlayer(int player) {
        if (player == 1) player1Games++;
        else player2Games++;

        if (isSetWon()) {
            return (player1Games > player2Games) ? "Player 1 wins set" : "Player 2 wins set";
        }

        if (player1Games == 6 && player2Games == 6) {
            tieBreakActive = true;
            return "Tiebreak activated";
        }

        return String.format("Current set: %d-%d", player1Games, player2Games);
    }

    private boolean isSetWon() {
        // Caso normal: 6 juegos con 2 de diferencia o 7 con tiebreak
        if ((player1Games >= 6 || player2Games >= 6)
                && Math.abs(player1Games - player2Games) >= 2) {
            return true;
        }
        // Caso de tiebreak
        if (player1Games == 7 || player2Games == 7) {
            return true;
        }
        return false;
    }

    public boolean isTieBreakActive() {
        return tieBreakActive;
    }

    public int getPlayer1Games() {
        return player1Games;
    }

    public int getPlayer2Games() {
        return player2Games;
    }
}
