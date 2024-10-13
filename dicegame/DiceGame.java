package dicegame;

import java.util.Scanner;

public class DiceGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Dice Game!");

        // Game setup
        System.out.print("Enter player name: ");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);

        System.out.print("Enter the number of sides for the die: ");
        int numberOfSides = scanner.nextInt();
        player.addDie(numberOfSides);

        System.out.print("Enter the number of rounds to play: ");
        int numberOfRounds = scanner.nextInt();

        // Game loop
        for (int round = 1; round <= numberOfRounds; round++) {
            System.out.println("\nRound " + round);
            System.out.print("Guess a number (1-" + numberOfSides + "): ");
            int guess = scanner.nextInt();

            player.rollDice();
            int rollResult = player.getDieValue();

            System.out.println("The die rolled: " + rollResult);

            if (guess == rollResult) {
                System.out.println("Correct guess! You get a point.");
                player.increaseScore();
            } else {
                System.out.println("Sorry, that's not correct.");
            }

            System.out.println("Current score: " + player.getScore());
        }

        // Game over - Spelet är slut
        System.out.println("\nGame Over!");
        System.out.println(
                player.getName() + ", your final score is: " + player.getScore() + " out of " + numberOfRounds);

        scanner.close();
        // Calculate percentage of correct guesses
        double percentage = ((double) player.getScore() / numberOfRounds) * 100;

        // Display customized message based on the percentage
        if (percentage == 100) {
            System.out.println("You nailed it! " + percentage + "% correct!, Good job " + player.getName() + "!");
        } else if (percentage >= 75) {
            System.out
                    .println(percentage + "% correct! The odds are in your favor! Good job, " + player.getName() + "!");
        } else if (percentage >= 50) {
            System.out.println(percentage + "% correct. Not bad at all, Good job " + player.getName() + "!");
        } else if (percentage > 0) {
            System.out.println(
                    percentage + "% correct. Not bad, Not perfect. Good job nonetheless " + player.getName() + "!");
        } else {
            System.out.println("Not your lucky day, Better luck next time " + player.getName() + "!");
        }
    }
}
