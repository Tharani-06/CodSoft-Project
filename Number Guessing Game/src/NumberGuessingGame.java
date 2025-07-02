import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        boolean playAgain;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess the number between 1 and 100.");

        do {
            int numberToGuess = random.nextInt(100) + 1;
            int attemptsLeft = 7;
            int attemptsUsed = 0;
            boolean guessedCorrectly = false;

            while (attemptsLeft > 0) {
                System.out.print("\nEnter your guess: ");
                int userGuess = scanner.nextInt();
                attemptsUsed++;
                attemptsLeft--;

                if (userGuess == numberToGuess) {
                    System.out.println("Correct! You've guessed the number in " + attemptsUsed + " attempts.");
                    guessedCorrectly = true;
                    totalScore += (10 - attemptsUsed); // Higher score for fewer attempts
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                System.out.println("Attempts left: " + attemptsLeft);
            }

            if (!guessedCorrectly) {
                System.out.println("Out of attempts! The number was: " + numberToGuess);
            }

            System.out.println("Your current score: " + totalScore);

            System.out.print("\nDo you want to play another round? (yes/no): ");
            scanner.nextLine(); // Consume newline
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");

        } while (playAgain);

        System.out.println("Thanks for playing! Final Score: " + totalScore);
        scanner.close();
    }
}
