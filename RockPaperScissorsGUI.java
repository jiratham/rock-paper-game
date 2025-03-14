import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RockPaperScissorsGUI extends JFrame {
    private String[] choices = {"Rock", "Paper", "Scissors"};
    private int userScore = 0, computerScore = 0;
    private int userWins = 0, computerWins = 0;
    private JLabel resultLabel, scoreLabel, totalWinsLabel;

    public RockPaperScissorsGUI() {
        setTitle("Rock Paper Scissors");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(44, 62, 80)); // เปลี่ยนสีพื้นหลังหลัก

        // กำหนดฟอนต์
        Font font = new Font("SansSerif", Font.BOLD, 14);
        Color textColor = Color.WHITE;

        // Display panel
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new GridLayout(3, 1));
        displayPanel.setBackground(new Color(52, 73, 94)); // พื้นหลังเข้มขึ้น

        resultLabel = new JLabel("Choose Rock, Paper, or Scissors", SwingConstants.CENTER);
        scoreLabel = new JLabel("Score: You 0 - 0 Computer", SwingConstants.CENTER);
        totalWinsLabel = new JLabel("Total Wins: You 0 - 0 Computer", SwingConstants.CENTER);

        // ปรับแต่งสีและฟอนต์
        resultLabel.setFont(font);
        scoreLabel.setFont(font);
        totalWinsLabel.setFont(font);

        resultLabel.setForeground(textColor);
        scoreLabel.setForeground(textColor);
        totalWinsLabel.setForeground(textColor);

        displayPanel.add(resultLabel);
        displayPanel.add(scoreLabel);
        displayPanel.add(totalWinsLabel);
        add(displayPanel, BorderLayout.CENTER);

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(44, 62, 80));

        JButton rockButton = createStyledButton("Rock");
        JButton paperButton = createStyledButton("Paper");
        JButton scissorsButton = createStyledButton("Scissors");

        buttonPanel.add(rockButton);
        buttonPanel.add(paperButton);
        buttonPanel.add(scissorsButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Button Actions
        rockButton.addActionListener(e -> playGame(0));
        paperButton.addActionListener(e -> playGame(1));
        scissorsButton.addActionListener(e -> playGame(2));
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setBackground(new Color(231, 76, 60));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createRaisedBevelBorder());
        button.setPreferredSize(new Dimension(100, 40));
        return button;
    }

    private void playGame(int userChoice) {
        Random random = new Random();
        int computerChoice = random.nextInt(3);
        String computerMove = choices[computerChoice];
        String userMove = choices[userChoice];

        String result;
        if (userChoice == computerChoice) {
            result = "It's a tie!";
        } else if ((userChoice == 0 && computerChoice == 2) ||
                   (userChoice == 1 && computerChoice == 0) ||
                   (userChoice == 2 && computerChoice == 1)) {
            result = "You win this round!";
            userScore++;
        } else {
            result = "Computer wins this round!";
            computerScore++;
        }

        resultLabel.setText("You chose " + userMove + ", Computer chose " + computerMove + ". " + result);
        scoreLabel.setText("Score: You " + userScore + " - " + computerScore + " Computer");

        if (userScore == 2) {
            JOptionPane.showMessageDialog(this, "You won the game!");
            userWins++;
            resetGame();
        } else if (computerScore == 2) {
            JOptionPane.showMessageDialog(this, "Computer wins the game!");
            computerWins++;
            resetGame();
        }

        totalWinsLabel.setText("Total Wins: You " + userWins + " - " + computerWins + " Computer");
    }

    private void resetGame() {
        userScore = 0;
        computerScore = 0;
        scoreLabel.setText("Score: You 0 - 0 Computer");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); // ใช้ Nimbus Theme
            } catch (Exception e) {
                e.printStackTrace();
            }
            RockPaperScissorsGUI frame = new RockPaperScissorsGUI();
            frame.setVisible(true);
        });
    }
}
