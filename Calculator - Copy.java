package mitm311;

import javax.swing.*;
import java.awt.event.*;

public class Calculator extends JFrame {
	private JFrame frame;
	private JTextField screen, screen1;
	private JButton reset, one, two, three, four, five, six, seven, eight, nine, zero, add, sub, div, mul, result;
	private int num1, num2;
	private int result1;
	private int operator;

	public static void main(String[] args) {
		try {
			Calculator window = new Calculator();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Calculator() {
		frame = new JFrame();
		frame.setTitle("Basic Calculator");
		frame.setBounds(200, 100, 280, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);

		one = new JButton("1");
		one.setBounds(10, 60, 50, 30);
		frame.add(one);

		two = new JButton("2");
		two.setBounds(70, 60, 50, 30);
		frame.add(two);

		three = new JButton("3");
		three.setBounds(130, 60, 50, 30);
		frame.add(three);

		four = new JButton("4");
		four.setBounds(10, 100, 50, 30);
		frame.add(four);

		five = new JButton("5");
		five.setBounds(70, 100, 50, 30);
		frame.add(five);

		six = new JButton("6");
		six.setBounds(130, 100, 50, 30);
		frame.add(six);

		seven = new JButton("7");
		seven.setBounds(10, 140, 50, 30);
		frame.add(seven);

		eight = new JButton("8");
		eight.setBounds(70, 140, 50, 30);
		frame.add(eight);

		nine = new JButton("9");
		nine.setBounds(130, 140, 50, 30);
		frame.add(nine);

		zero = new JButton("0");
		zero.setBounds(70, 180, 50, 30);
		frame.add(zero);

		one.addActionListener(e -> screen1.setText(screen1.getText() + "1"));
		two.addActionListener(e -> screen1.setText(screen1.getText() + "2"));
		three.addActionListener(e -> screen1.setText(screen1.getText() + "3"));
		four.addActionListener(e -> screen1.setText(screen1.getText() + "4"));
		five.addActionListener(e -> screen1.setText(screen1.getText() + "5"));
		six.addActionListener(e -> screen1.setText(screen1.getText() + "6"));
		seven.addActionListener(e -> screen1.setText(screen1.getText() + "7"));
		eight.addActionListener(e -> screen1.setText(screen1.getText() + "8"));
		nine.addActionListener(e -> screen1.setText(screen1.getText() + "9"));
		zero.addActionListener(e -> screen1.setText(screen1.getText() + "0"));
		one.addActionListener(e -> screen.setText(screen.getText() + "1"));
		two.addActionListener(e -> screen.setText(screen.getText() + "2"));
		three.addActionListener(e -> screen.setText(screen.getText() + "3"));
		four.addActionListener(e -> screen.setText(screen.getText() + "4"));
		five.addActionListener(e -> screen.setText(screen.getText() + "5"));
		six.addActionListener(e -> screen.setText(screen.getText() + "6"));
		seven.addActionListener(e -> screen.setText(screen.getText() + "7"));
		eight.addActionListener(e -> screen.setText(screen.getText() + "8"));
		nine.addActionListener(e -> screen.setText(screen.getText() + "9"));
		zero.addActionListener(e -> screen.setText(screen.getText() + "0"));

		add = new JButton("+");
		add.setBounds(190, 60, 50, 30);
		add.addActionListener(e -> handleOperator(1, "+"));
		frame.add(add);

		sub = new JButton("-");
		sub.setBounds(190, 100, 50, 30);
		sub.addActionListener(e -> handleOperator(2, "-"));
		frame.add(sub);

		mul = new JButton("*");
		mul.setBounds(190, 140, 50, 30);
		mul.addActionListener(e -> handleOperator(3, "*"));
		frame.add(mul);

		div = new JButton("/");
		div.setBounds(190, 180, 50, 30);
		div.addActionListener(e -> handleOperator(4, "/"));
		frame.add(div);

		result = new JButton("=");
		result.setBounds(130, 180, 50, 30);
		result.addActionListener(e -> calculateResult());
		frame.add(result);

		reset = new JButton("C");
		reset.setBounds(10, 180, 50, 30);
		frame.add(reset);
		reset.addActionListener(e -> {
			screen.setText("");
			screen1.setText("");
		});

		frame.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				char key = e.getKeyChar();
				if (key >= '0' && key <= '9') {
					screen1.setText(screen1.getText() + key);
					screen.setText(screen.getText() + key);
				}

				else if (key == '+') {
					handleOperator(1, "+");
				} else if (key == '-') {
					handleOperator(2, "-");
				} else if (key == '*') {
					handleOperator(3, "*");
				} else if (key == '/') {
					handleOperator(4, "/");
				}

				else if (key == KeyEvent.VK_ENTER) {
					calculateResult();
				}
			}
		});
		frame.setFocusable(true);
		frame.requestFocusInWindow();
		
		screen = new JTextField();
		screen.setBounds(10, 35, 228, 25);
		frame.add(screen);
		screen1 = new JTextField();
		screen1.setBounds(10, 10, 228, 25);
		frame.add(screen1);
	}

	private void handleOperator(int op, String symbol) {
		if (!screen1.getText().isEmpty()) {
			num1 = Integer.parseInt(screen1.getText());
			screen.setText(num1 + symbol);
			screen1.setText("");
			operator = op;
		}
	}

	private void calculateResult() {
		try {
			num2 = Integer.parseInt(screen1.getText());
			screen.setText(screen.getText() + "=");
			switch (operator) {
			case 1:
				result1 = num1 + num2;
				break;
			case 2:
				result1 = num1 - num2;
				break;
			case 3:
				result1 = num1 * num2;
				break;
			case 4:
				if (num2 == 0) {
					screen.setText("Error: Div by 0");
					return;
				}
				result1 = num1 / num2;
				break;
			}
			screen.setText(screen.getText() + "" + Integer.toString(result1));
		} catch (NumberFormatException ex) {
			screen.setText("Invalid Input");
		}
	}
}
