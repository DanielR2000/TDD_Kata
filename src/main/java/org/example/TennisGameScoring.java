package org.example;

public class TennisGameScoring {
    public String transformScoreToText(int playerOneScore, int playerTwoScore){
        StringBuilder sb = new StringBuilder();

        sb.append(translate(playerOneScore));

        sb.append(translate(playerTwoScore));

        return sb.toString();
    }

    private String translate (int score){
        String scoreText = new String();
        if (score==0)
            scoreText = "0";
        return scoreText;
    }
}
