import java.util.Scanner;

/**
* This program receives the mass from the user.
* From information given, it calculates how much energy,
* a specific mass would produce.
*
* @author  Sarah Andrew
* @version 1.0
*
* @since   2023-02-16
*/

public final class DiceGame {

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private DiceGame() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        // Declare variable & initialize counter.
        int counter = 0;
        int userGuess = 0;
        
        // Generate random number in set range. 
        final int MAX_NUM = 6;
        final int MIN_NUM = 1;

        final int randNum = (int) (Math.random() * (MAX_NUM - MIN_NUM + 1)
                                                    + MIN_NUM);

        // Create a new scanner
        final Scanner scanner = new Scanner(System.in);
        String userGuessStr;

        do {
            // Receive user input
            System.out.println("Enter a number between 1 and 6: ");
            userGuessStr = scanner.nextLine();

            // Usage of try catch to detect errors.
            try {
                userGuess = Integer.parseInt(userGuessStr);
                // If statement to determine if number is in range.
                if (userGuess >= MIN_NUM && userGuess <= MAX_NUM) {
                    System.out.println("Please enter number in range.");
                } else {
                    // Increments counter.
                    counter = counter + 1;
                    // If statement to see if user guess exceeds 
                    // or is lower than random number generated.
                    if (userGuess > randNum) {
                        System.out.println("Your guess is too high.");
                        System.out.println();
                    } else {
                        System.out.println("Your guess is too low!");
                        System.out.println();
                    }
                }
            } catch (NumberFormatException error) {
                // Displays error to user.
                System.out.println("Please enter valid input."
                        + error.getMessage());
            }
        // This case executes when the user gets the
        // number correct.
        } while (userGuess != randNum); {
            // Displays results to user.
            System.out.print("Your guess was correct!");
            System.out.println("It took you " + counter + " tries");
        }
        // Closes scanner
        scanner.close();

    }
}