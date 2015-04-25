package ohtu;

/**
 *
 * @author samutamm
 */
public class Player implements Comparable<Player>{

    private String name;
    private int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public void score() {
        this.score++;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    public String scoreDescription() {
        String score = "";
        switch (this.score) {
            case 0:
                score += "Love";
                break;
            case 1:
                score += "Fifteen";
                break;
            case 2:
                score += "Thirty";
                break;
            case 3:
                score += "Forty";
                break;
            default:
                score = "Deuce";
                break;
        }
        return score;
    }

    @Override
    public int compareTo(Player o) {
        return o.getScore() - this.getScore();
    }

    @Override
    public String toString() {
        return this.name;
    }
    
    
}
