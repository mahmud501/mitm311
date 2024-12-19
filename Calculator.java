package mitm311;

import javax.swing.*;

public class Calculator extends JFrame {
	private JFrame frame;
	private JTextField screen, screen1;
	private JButton reset,one, two, three, four, five, six, seven, eight, nine, zero, add, sub, div, mul, result;
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
		frame.add(add);

		sub = new JButton("-");
		sub.setBounds(190, 100, 50, 30);
		frame.add(sub);

		mul = new JButton("*");
		mul.setBounds(190, 140, 50, 30);
		frame.add(mul);

		div = new JButton("/");
		div.setBounds(190, 180, 50, 30);
		frame.add(div);

		result = new JButton("=");
		result.setBounds(130, 180, 50, 30);
		frame.add(result);
		
		reset = new JButton("C");
		reset.setBounds(10,180,50,30);
		frame.add(reset);
		reset.addActionListener(e ->screen.setText(""));
		reset.addActionListener(e ->screen1.setText(""));

		screen = new JTextField();
		screen.setBounds(10, 35, 228, 25);
		frame.add(screen);
		screen1 = new JTextField();
		screen1.setBounds(10, 10, 228, 25);
		frame.add(screen1);

		add.addActionListener(e -> {
			num1 = Integer.parseInt(screen1.getText());
			screen.setText(screen.getText() + "+");
			screen1.setText("+");
			operator = 1;
			screen1.setText(null);
		});

		sub.addActionListener(e -> {
			num1 = Integer.parseInt(screen1.getText());
			screen.setText(screen.getText() + "-");
		screen1.setText("-");
			operator = 2;
			screen1.setText(null);
		});

		mul.addActionListener(e -> {
			num1 = Integer.parseInt(screen1.getText());
			screen.setText(screen.getText() + "*");
		//	screen1.setText("*");
			operator = 3;
			screen1.setText(null);
		});

		div.addActionListener(e -> {
			num1 = Integer.parseInt(screen1.getText());
			screen.setText(screen.getText() + "/");
		//	screen1.setText("/");
			operator = 4;
			screen1.setText(null);
		});
		result.addActionListener(e -> {
			num2 = Integer.parseInt(screen1.getText());
			screen.setText(screen.getText() + "=");
			//screen1.setText("=");
			switch (operator) {
			case 1:
				result1 = num1 + num2;
				screen.setText(screen.getText() + "" + Integer.toString(result1));
				
				break;
			case 2:
				result1 = num1 - num2;
				screen.setText(screen.getText() + "" + Integer.toString(result1));
				break;
			case 3:
				result1 = num1 * num2;
				screen.setText(screen.getText() + "" + Integer.toString(result1));
				break;
			case 4:
				result1 = num1 / num2;
				screen.setText(screen.getText() + "" + Integer.toString(result1));
				break;				
			}
		});

	}

}
