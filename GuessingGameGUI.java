package mitm311;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GuessingGameGUI {
    private JFrame frame;
    private JTextField guessInput;
    private JLabel messageLabel;
    private JLabel attemptsLabel;
    private JButton guessButton;
    private int randomNumber;
    private int attemptsLeft;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                GuessingGameGUI window = new GuessingGameGUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public GuessingGameGUI() {
        initialize();
    }

    private void initialize() {
        // Set up the frame
        frame = new JFrame();
        frame.setBounds(100, 100, 400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Random number between 1 and 100
        randomNumber = (int) (Math.random() * 100) + 1;

        // Initial attempts
        attemptsLeft = 10;

        // Message label
        messageLabel = new JLabel("Guess the number between 1 and 100:");
        messageLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        messageLabel.setBounds(30, 30, 300, 20);
        frame.getContentPane().add(messageLabel);

        // TextField for user input
        guessInput = new JTextField();
        guessInput.setBounds(30, 60, 100, 30);
        frame.getContentPane().add(guessInput);
        guessInput.setColumns(10);

        // Label for attempts left
        attemptsLabel = new JLabel("Attempts left: 10");
        attemptsLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        attemptsLabel.setBounds(30, 100, 150, 20);
        frame.getContentPane().add(attemptsLabel);

        // Button to submit guess
        guessButton = new JButton("Guess");
        guessButton.setBounds(150, 60, 100, 30);
        frame.getContentPane().add(guessButton);

        // Action listener for button click
        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get the user input
                    int userGuess = Integer.parseInt(guessInput.getText());
                    // Check if the guess is correct or too high/low
                    if (userGuess == randomNumber) {
                        messageLabel.setText("Correct! You win!");
                        messageLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
                        JOptionPane.showMessageDialog(frame, "Congratulations! You guessed the correct number.");
                        frame.dispose(); 
                    } else if (userGuess > randomNumber) {
                        attemptsLeft--;
                        messageLabel.setText("Too high! Try again.");
                    } else {
                        attemptsLeft--;
                        messageLabel.setText("Too low! Try again.");
                    }
                    
                    // Update attempts label
                    attemptsLabel.setText("Attempts left: " + attemptsLeft);

                    // Check if attempts are over
                    if (attemptsLeft == 0) {
                        JOptionPane.showMessageDialog(frame, "Game Over! The correct number was " + randomNumber);
                        resetGame();
                    }

                    // Clear input field for next guess
                    guessInput.setText("");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number!");
                }
            }
        });
    }

    // Reset the game
    private void resetGame() {
        randomNumber = (int) (Math.random() * 100) + 1;
        attemptsLeft = 10;
        attemptsLabel.setText("Attempts left: 10");
        messageLabel.setText("Guess the number between 1 and 100:");
        messageLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        guessInput.setText("");
    }
}
