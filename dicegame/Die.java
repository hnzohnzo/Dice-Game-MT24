package dicegame;

import java.util.Random;

public class Die {
    private int currentValue;
    private final int numberOfSides;
    private final Random random;

    public Die(int numberOfSides) {
        this.numberOfSides = numberOfSides;
        this.random = new Random();
        roll(); 
    }

    public int getNumberOfSides() {
        return numberOfSides;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void roll() {
        this.currentValue = random.nextInt(numberOfSides) + 1;
    }
}

