package mitm311;

import javax.swing.*;
import java.awt.event.*;

public class Calculator1 extends JFrame {
	private JFrame frame;
	private JTextField screen, screen1;
	private JButton reset, one, two, three, four, five, six, seven, eight, nine, zero, add, sub, div, mul, result;
	private int num1, num2;
	private int result1;
	private int operator;
	private String[] buttonlabel={"1","2","3","4","5","6","7","8","9"};
	private JButton[] button = new JButton[buttonlabel.length];
	
	public static void main(String[] args) {
		try {
			Calculator1 window = new Calculator1();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Calculator1() {
		frame = new JFrame();
		frame.setTitle("Basic Calculator");
		frame.setBounds(200, 100, 280, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);

		for (int i=0;i<buttonlabel.length;i++) {
			button[i]=new JButton(buttonlabel[i]);
			String text= buttonlabel[i];
			button[i].setBounds((i%3*60+10),(i/3*40+60),50,30);
			button[i].addActionListener(e -> screen1.setText(screen1.getText() + text));
			button[i].addActionListener(e -> screen.setText(screen.getText() + text));
			frame.add(button[i]);
		}

		zero = new JButton("0");
		zero.setBounds(70, 180, 50, 30);
		frame.add(zero);

		zero.addActionListener(e -> screen1.setText(screen1.getText() + "0"));
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
