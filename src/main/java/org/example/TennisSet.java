package org.example;

public class TennisSet {
    private int player1Games;
    private int player2Games;

    public String addGameToPlayer(int player) {
        // Sumar juego al jugador correspondiente
        if (player == 1) player1Games++;
        else player2Games++;

        // Comprobar si el set se ha ganado
        if (isSetWon()) {
            if (player1Games > player2Games) {
                return "Player 1 wins set";
            } else {
                return "Player 2 wins set";
            }
        }

        // Mostrar el marcador actual
        return String.format("Current set: %d-%d", player1Games, player2Games);
    }

    private boolean isSetWon() {
        // Caso normal: ganar con 2 de diferencia y al menos 6 juegos
        return (player1Games >= 6 || player2Games >= 6)
                && Math.abs(player1Games - player2Games) >= 2;
    }

    public int getPlayer1Games() {
        return player1Games;
    }

    public int getPlayer2Games() {
        return player2Games;
    }
}
