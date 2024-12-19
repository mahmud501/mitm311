package mitm311;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class lab1 extends JFrame {
    private JLabel lbl1, lbl2, lbl3;
    private JTextField tf;
    private JButton btn;
    private int tries = 10;
    private int compNumber;

    public lab1() {
        setLayout(null);

        Random random = new Random();
        compNumber = random.nextInt(100) + 1;

        lbl1 = new JLabel(tries + " tries left.");
        lbl1.setBounds(20, 20, 200, 30);
        add(lbl1);

        lbl2 = new JLabel("Guess a number (1-100):");
        lbl2.setBounds(20, 60, 200, 30);
        add(lbl2);

        tf = new JTextField("", 5);
        tf.setBounds(220, 60, 100, 30);
        add(tf);

        btn = new JButton("Guess");
        btn.setBounds(330, 60, 100, 30);
        add(btn);

        lbl3 = new JLabel(" ");
        lbl3.setFont(new Font("Arial", Font.BOLD, 12));
        lbl3.setBounds(20, 100, 400, 30);
        lbl3.setHorizontalAlignment(SwingConstants.LEFT);
        add(lbl3);

        GuessButtonListener gbl = new GuessButtonListener();
        btn.addActionListener(gbl);

        setTitle("My Guessing Game");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new lab1();
    }

    private class GuessButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                int userNumber = Integer.parseInt(tf.getText().trim());

                if (userNumber < 1 || userNumber > 100) {
                	tf.setText("");
                    lbl3.setText("Please enter a number between 1 and 100.");
                    lbl3.setForeground(Color.RED);
                    return;
                }

                tries--;
                lbl1.setText(tries + " tries left.");

                if (userNumber > compNumber) {
                	tf.setText("");
                    lbl3.setText("The number is lower.");
                    lbl3.setForeground(Color.RED);
                } else if (userNumber < compNumber) {
                	tf.setText("");
                    lbl3.setText("The number is higher.");
                    lbl3.setForeground(Color.RED);
                } else {
                    lbl3.setText("You guessed the number!");
                    lbl3.setForeground(Color.GREEN);
                    btn.setEnabled(false);
                }

                if (tries == 0 && userNumber != compNumber) {
                	tf.setText("");
                    lbl3.setText("Game over! The number was " + compNumber + ".");
                    lbl3.setForeground(Color.RED);
                    btn.setEnabled(false);
                }
            } catch (NumberFormatException e) {
                lbl3.setText("Please enter a valid number.");
                lbl3.setForeground(Color.RED);
            }
        }
    }
}