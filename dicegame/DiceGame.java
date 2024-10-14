package dicegame;

import java.util.Scanner;

public class DiceGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to this simple Dice game. The Game works by choosing a name and die size. Player then decides the number of rounds. For each round the player guesses a number, the die is rolled, if guessed matches roll, player scores a point. The game ends after all rounds are played, and final score + percentage message is calculated. Sounds fun right?");
        System.out.println("------------------------------------------------------------------------------------------");

        // Spelaren väljer och skriver in sitt namn
        System.out.print("Let's begin. Start by choosing a name for yourself: ");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);

        // Spelaren väljer hur många sidor tärningen ska ha
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.print("That's a beautiful name. Now how many sides do you want your die to have?: ");
        int numberOfSides = scanner.nextInt();
        player.addDie(numberOfSides);

        // Spelaren väljer hur många rundor av spelet hen vill spela.
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.print("Great choice. Continue by choosing how many rounds you want to play: ");
        int numberOfRounds = scanner.nextInt();

        // Spel Loop
        // För varje runda
        // 1. Får Spelarens gissning
        // 2. Tärningen kastas
        // 3. Jämför tärningens resultat med spelarens gissning
        // 4. Updaterar resultat
        for (int round = 1; round <= numberOfRounds; round++) {
        System.out.println("--------------------------------------------------------------------------------------------");    
        // Vid runda 1, visa specifikt meddelande.
            if (round == 1) {
                System.out.print("Welcome to the first round! Good luck!"); 
            }
            System.out.println("\nRound " + round);
            System.out.print("Guess a number (1-" + numberOfSides + "): ");
            int guess = scanner.nextInt();

            player.rollDice();
            int rollResult = player.getDieValue();

            System.out.println("The die rolled: " + rollResult);

            if (guess == rollResult) {
                System.out.println("You guessed correctly! One point for you.");
                player.increaseScore();
            } else {
                System.out.println("Sorry, that's not correct. Better luck next round!");
            }

            System.out.println("Current score: " + player.getScore());
        }

        // Game over - Spelet är slut.
        System.out.println("\nGame Over!");
        System.out.println(
                player.getName() + ", your final score is: " + player.getScore() + " out of " + numberOfRounds);

        scanner.close();
        // Uträkning av procentuellt rätt svarade gissningar.
        double percentage = ((double) player.getScore() / numberOfRounds) * 100;

        // Spelaren får olika text-meddelanden baserat på procentuell % vinst marginal
        // Om spelaren får 100 % rätt visas följande text:'You nailed it!, Good job.
        // Om spelaren får över 75 - 99 % rätt visas följande text: The odds are in your
        // favor! Good job.
        // Om spelaren får mellan 50 - 74 % rätt visas följande text: Not bad at all,
        // Good job.
        // Om spelaren får mellan 0 - 49 % rätt visas följande text: Not bad, not
        // perfect. Good job nonetheless.
        // Om spelaren får 0 % rätt visas följande text: Not your lucky day. Better luck
        // next time.

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
