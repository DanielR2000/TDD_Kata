package org.example;

public class TennisGame {
    private int player1Points = 0;
    private int player2Points = 0;
    private TennisGameScoring scoring = new TennisGameScoring();
    private boolean finished = false;

    // Añadir un punto a un jugador (pensada para los test pero no usada
    public String addPointToPlayer(int player) {
        if (finished) {
            return "Game already finished";
        }

        // Actualizar puntuación
        if (player == 1) {
            player1Points = nextPointValue(player1Points);
        } else {
            player2Points = nextPointValue(player2Points);
        }

        // Calcular marcador textual
        String scoreText = scoring.transformScoreToText(player1Points, player2Points);

        // Detectar si alguien ganó el juego
        if (scoreText.contains("Player 1 wins Game")) {
            finished = true;
            return "Player 1 wins Game";
        } else if (scoreText.contains("Player 2 wins Game")) {
            finished = true;
            return "Player 2 wins Game";
        }

        return scoreText;
    }

    private int nextPointValue(int current) {
        if (current == 0) return 15;
        if (current == 15) return 30;
        if (current == 30) return 40;
        if (current == 40) return 50; // Advantage
        if (current == 50) return 60; // Ganó el juego
        return current;
    }

    public boolean isFinished() {
        return finished;
    }

    public int getPlayer1Points() {
        return player1Points;
    }

    public int getPlayer2Points() {
        return player2Points;
    }
}
