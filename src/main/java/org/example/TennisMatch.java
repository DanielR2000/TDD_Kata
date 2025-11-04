package org.example;

public class TennisMatch {
    private int player1Sets = 0;
    private int player2Sets = 0;
    private TennisSet currentSet = new TennisSet();

    public String addGameToPlayer(int player) {
        String result = currentSet.addGameToPlayer(player);

        // Si el set ha terminado
        if (result.contains("wins set")) {
            if (result.contains("1")) addSetToPlayer(1);
            else addSetToPlayer(2);

            // Comprobamos si el partido ha terminado
            if (player1Sets == 3 || player2Sets == 3) {
                if (player1Sets > player2Sets) {
                    return "Player 1 wins match";
                } else {
                    return "Player 2 wins match";
                }
            }

            // Si no se ha acabado el partido, reiniciamos el set
            currentSet = new TennisSet();
        }

        return result;
    }

    public void addSetToPlayer(int player) {
        if (player == 1) player1Sets++;
        else if (player == 2) player2Sets++;
    }

    public int getPlayer1Sets() {
        return player1Sets;
    }

    public int getPlayer2Sets() {
        return player2Sets;
    }
}
