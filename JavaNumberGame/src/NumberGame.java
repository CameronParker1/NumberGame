import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int secretNumber = random.nextInt(100) + 1; 
        int attempts = 0;
        final int MAX_ATTEMPTS = 5;
        boolean hasWon = false;

        System.out.println("Welcome to Guess the Number Game!");
        System.out.println("");
        System.out.println("I have chosen a number between 1 and 100. You have " + MAX_ATTEMPTS + " attempts to guess it.");
        System.out.println("");

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess == secretNumber) {
                System.out.println("Congratulations! You've guessed the number (" + secretNumber + ") correctly in " + attempts + " attempts.");
                hasWon = true;
                break;
            }

            else if (guess < secretNumber) {
                System.out.println("The number is higher than " + guess + ".");
            }
            
            else {
                System.out.println("The number is lower than " + guess + ".");
            }

            if (attempts == MAX_ATTEMPTS) {
                System.out.println("Sorry, you've used up all your attempts. The correct number was " + secretNumber + ".");
            } 
            
            else {
                System.out.println("Attempts left: " + (MAX_ATTEMPTS - attempts));
            }
        }

        if (!hasWon) {
            System.out.println("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();
            
            if (playAgain.equalsIgnoreCase("yes")) {
                secretNumber = random.nextInt(100) + 1;
                attempts = 0;
                hasWon = false;
                System.out.println("New game started. I have chosen a new number between 1 and 100.");
                main(args);
            } 
            
            else {
                System.out.println("Thanks for playing!");
            }
        }
        
        scanner.close();
    }
}