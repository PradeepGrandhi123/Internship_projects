import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] options = {"Rock", "Paper", "Scissors"};
        boolean keepPlaying = true;

        System.out.println("Welcome to Rock, Paper, Scissors!");

        while (keepPlaying) {
            // User choice
            System.out.println("Enter your choice (Rock, Paper, Scissors). Type 'Exit' to quit:");
            String userChoice = scanner.nextLine();

            if (userChoice.equalsIgnoreCase("Exit")) {
                keepPlaying = false;
                break;
            }

            // Validate user input
            if (!userChoice.equalsIgnoreCase("Rock") && 
                !userChoice.equalsIgnoreCase("Paper") && 
                !userChoice.equalsIgnoreCase("Scissors")) {
                System.out.println("Invalid input! Please choose Rock, Paper, or Scissors.");
                continue;
            }

            // Computer choice
            int computerIndex = random.nextInt(3); // Generate a number between 0 and 2
            String computerChoice = options[computerIndex];
            System.out.println("Computer chose: " + computerChoice);

            // Determine the winner
            if (userChoice.equalsIgnoreCase(computerChoice)) {
                System.out.println("It's a tie!");
            } else if (userChoice.equalsIgnoreCase("Rock") && computerChoice.equals("Scissors") ||
                       userChoice.equalsIgnoreCase("Paper") && computerChoice.equals("Rock") ||
                       userChoice.equalsIgnoreCase("Scissors") && computerChoice.equals("Paper")) {
                System.out.println("You win!");
            } else {
                System.out.println("Computer wins!");
            }

            System.out.println();
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
