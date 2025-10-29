package org.example;

public class TennisMatch {
    private int player1Sets = 0;
    private int player2Sets = 0;
    private TennisSet currentSet = new TennisSet();

    public String addGameToPlayer(int player) {
        String result = currentSet.addGameToPlayer(player);

        if (result.contains("wins set")) {
            if (result.contains("1")) player1Sets++;
            else player2Sets++;

            if (player1Sets == 3 || player2Sets == 3) {
                return (player1Sets > player2Sets) ? "Player 1 wins match" : "Player 2 wins match";
            }

            currentSet = new TennisSet(); // nuevo set
        }

        return result;
    }

    public int getPlayer1Sets() {
        return player1Sets;
    }

    public int getPlayer2Sets() {
        return player2Sets;
    }
}
