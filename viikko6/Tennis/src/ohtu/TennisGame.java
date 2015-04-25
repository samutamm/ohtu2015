package ohtu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class TennisGame {

    private Player player1;
    private Player player2;
    private Player[] players;

    public TennisGame(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name, 0);
        this.player2 = new Player(player2Name, 0);
        this.players = new Player[]{player1, player2};
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1.name())) {
            player1.score();
        } else {
            player2.score();
        }
    }

    private boolean standoff() {
        return player1.getScore() == player2.getScore();
    }

    public String getScore() {
        String score = "";
        int tempScore = 0;
        if (standoff()) {
            score = player1.scoreDescription();
            if (player1.getScore() < 4) {
                score += "-All";
            }
        } else if (isOverFour()) {
            score = overFourGame();
        } else {
            score = player1.scoreDescription() + "-" + player2.scoreDescription();
        }
        return score;
    }

    private String overFourGame() {
        String score;
        Arrays.sort(players);
        if (Math.abs(player1.getScore() - player2.getScore()) >= 2) {
            return "Win for " + players[0];
        } else {
            return "Advantage " + players[0];
        }
    }

    private boolean isOverFour() {
        return player1.getScore() >= 4 || player2.getScore() >= 4;
    }
}
