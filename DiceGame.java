import java.util.Scanner;

/**
* This program receives user guess from user.
* From information given, it checks to see if guess
* is the same as random number generated.
*
*
* @author  Sarah Andrew
* @version 1.0
*
* @since   2023-02-26.
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
        final int MAX_NUM = 6;
        final int MIN_NUM = 1;

        // Generates number in set range.
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
                if (userGuess < MIN_NUM || userGuess > MAX_NUM) {
                    System.out.print("Please enter number in range.");
                    System.out.println(" This guess does not count.");
                } else {
                    // Increments counter.
                    counter = counter + 1;
                    // If statement to see if user guess exceeds
                    // or is lower than random number generated.
                    if (userGuess > randNum) {
                        System.out.println("Your guess is too high.");
                        System.out.println();
                    } else if (userGuess < randNum) {
                        System.out.println("Your guess is too low!");
                        System.out.println();
                    } else {
                        // Displays user when guess is correct &
                        // how many tries.
                        System.out.print("Your guess was correct!");
                        System.out.println(" It took you " + counter
                            + " tries.");
                    }
                }
            } catch (NumberFormatException error) {
                // Displays error to user.
                System.out.println("Please enter valid input."
                        + error.getMessage());
            }
        // This case executes when the user gets the
        // number correct.
        } while (userGuess != randNum);
        // Closes scanner
        scanner.close();

    }
}
