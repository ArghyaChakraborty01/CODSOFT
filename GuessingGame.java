import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
          private static final int MAX_ATTEMPTS = 15;
          private Random random = new Random();
          private Scanner scanner = new Scanner(System.in);

          public void play() {
                    int targetNumber = generateNumber();
                    int attempts = 0;
                    boolean correctGuess = false;

                    while (!correctGuess && attempts < MAX_ATTEMPTS) {
                              System.out.println("Enter your guess:");
                              int userGuess = scanner.nextInt();
                              String feedback = checkGuess(userGuess, targetNumber);
                              System.out.println(feedback);
                              attempts++;
                              if (userGuess == targetNumber) {
                                        correctGuess = true;
                              }
                    }

                    if (correctGuess) {
                              System.out.println("Congratulations You guessed correctly.");
                    } else {
                              System.out.println("Sorry, you didn't guess the number. The number was " + targetNumber
                                                  + ".");
                    }
          }

          private int generateNumber() {
                    return random.nextInt(100) + 1; // Generates a random number between 1 and 100
          }

          private String checkGuess(int userGuess, int targetNumber) {
                    if (userGuess == targetNumber) {
                              return "Correct!";
                    } else if (userGuess < targetNumber) {
                              return "Too low.";
                    } else {
                              return "Too high.";
                    }
          }

          public static void main(String[] args) {
                    GuessingGame game = new GuessingGame();
                    game.play();
          }
}
