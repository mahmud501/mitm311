package mitm311;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lab2 extends JFrame {
    private JTextField displayField;
    private String currentInput = "";
    private String operator = "";
    private int firstOperand = 0;
    private boolean isOperatorClicked = false;

    public lab2() {
        setTitle("My Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        displayField = new JTextField("0", 20);
        displayField.setEditable(false);
        displayField.setHorizontalAlignment(SwingConstants.RIGHT);
        displayField.setFont(new Font("Arial", Font.BOLD, 20));
        add(displayField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));
        
        String[] labels = {
            "7", "8", "9", "÷",
            "4", "5", "6", "×",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String label : labels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 16));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            switch (command) {
                case "C":
                    resetCalculator();
                    break;
                case "=":
                    calculateResult();
                    break;
                case "+": case "-": case "×": case "÷":
                    handleOperator(command);
                    break;
                default:
                    handleNumber(command);
            }
        }
    }

    private void resetCalculator() {
        currentInput = "";
        operator = "";
        firstOperand = 0;
        isOperatorClicked = false;
        displayField.setText("0");
    }

    private void handleNumber(String number) {
        if (isOperatorClicked) {
            currentInput = "";
            isOperatorClicked = false;
        }

        currentInput += number;
        displayField.setText(currentInput);
    }

    private void handleOperator(String op) {
        if (!currentInput.isEmpty()) {
            firstOperand = Integer.parseInt(currentInput);
        }
        operator = op;
        isOperatorClicked = true;
    }

    private void calculateResult() {
        if (operator.isEmpty() || currentInput.isEmpty()) {
            return;
        }

        double secondOperand = Double.parseDouble(currentInput);
        double result = 0;

        switch (operator) {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "×":
                result = firstOperand * secondOperand;
                break;
            case "÷":
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                } else {
                    displayField.setText("Error");
                    resetCalculator();
                    return;
                }
                break;
        }

        displayField.setText(Double.toString(result));
        currentInput = Double.toString(result);
        operator = "";
        isOperatorClicked = false;
    }

    public static void main(String[] args) {
        new lab2();
    }
}