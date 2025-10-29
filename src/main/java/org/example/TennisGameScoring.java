package org.example;

public class TennisGameScoring {

    public String transformScoreToText(int playerOneScore, int playerTwoScore) {

        // Caso Deuce y Advantage
        //Aqui declaro 50 como advantage y 60 como juego
        if (playerOneScore >= 40 && playerTwoScore >= 40) {
            int diff = playerOneScore - playerTwoScore;
            if (diff == 0) {
                return "Deuce";
            } else if (diff == 10) {
                return "Advantage player 1";
            } else if (diff == -10) {
                return "Advantage player 2";
            } else if (diff >= 20) {
                return "Player 1 wins Game";
            } else if (diff <= -20) {
                return "Player 2 wins Game";
            }
        }

        // Caso Win antes de deuce
        if (playerOneScore > 40 && playerOneScore - playerTwoScore >= 20) {
            return "Player 1 wins";
        }
        if (playerTwoScore > 40 && playerTwoScore - playerOneScore >= 20) {
            return "Player 2 wins";
        }

        // Caso normal puntuacines
        StringBuilder sb = new StringBuilder();
        sb.append(translate(playerOneScore));
        sb.append("-");
        sb.append(translate(playerTwoScore));

        return sb.toString();
    }

    private String translate(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 15:
                return "Fifteen";
            case 30:
                return "Thirty";
            case 40:
                return "Forty";
            default:
                return String.valueOf(score);
        }
    }
}
