import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        String[] choices = {"Rock", "Paper", "Scissors"};
        String[] keys = {"q", "w", "e"};
        int userScore = 0, computerScore = 0;
        
        System.out.println("Welcome to Rock-Paper-Scissors!");
        System.out.println("Use 'q' for Rock, 'w' for Paper, 'e' for Scissors.");
        System.out.println("Press 's' to view the scoreboard.");
        
        while (true) {
            System.out.print("Enter your choice (q, w, e) or 's' for score: ");
            String userInput = scanner.nextLine().trim().toLowerCase();
            
            if (userInput.equals("s")) {
                System.out.println("\nScoreboard:");
                System.out.println("You: " + userScore + " | Computer: " + computerScore);
                continue;
            }
            
            int userIndex = -1;
            for (int i = 0; i < keys.length; i++) {
                if (userInput.equals(keys[i])) {
                    userIndex = i;
                    break;
                }
            }
            
            if (userIndex == -1) {
                System.out.println("Invalid input! Please enter 'q', 'w', 'e', or 's'.");
                continue;
            }
            
            int computerIndex = random.nextInt(3);
            System.out.println("Computer chose: " + choices[computerIndex]);
            
            if (userIndex == computerIndex) {
                System.out.println("It's a tie!");
            } else if (
                (userIndex == 0 && computerIndex == 2) ||
                (userIndex == 1 && computerIndex == 0) ||
                (userIndex == 2 && computerIndex == 1)
            ) {
                System.out.println("You win!");
                userScore++;
            } else {
                System.out.println("Computer wins!");
                computerScore++;
            }
        }
    }
}
