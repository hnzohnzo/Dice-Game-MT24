package dicegame;

public class Player {
    private final String name;
    private int score;
    private Die die;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void rollDice() {
        if (die != null) {
            die.roll();
        }
    }

    public int getDieValue() {
        return (die != null) ? die.getCurrentValue() : 0;
    }

    public void increaseScore() {
        score++;
    }

    public void addDie(int numberOfSides) {
        this.die = new Die(numberOfSides);
    }
}