package CalculatorPackage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.*;
import java.awt.event.*;
public class Calculator extends JFrame implements ActionListener{
	JTextField inputs;
	JPanel mainPanel;
	String lasttext="";
	String text="";
	double result = 0;
	boolean endflag = false;
	String op = "";
	int number1=0;
	int number2=0;
	public Calculator() {
		setTitle("Calculator");
		setSize(360,400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout(4,2));


		inputs = new JTextField();
		inputs.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		inputs.setBackground(new Color(220,230,230));
		add(inputs,BorderLayout.NORTH);
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(4,4));
		String buttonsNames[] = {"1","2","3"," - ","4","5","6"," + ","7","8","9"," × "," C ","0"," = ", " / "};
		String ops[] = {" - "," + "," * "," / "," C "," = "};
		JButton buttons[] = new JButton[16];
		for (int i=0;i<buttons.length;i++) {
			buttons[i] = new JButton(buttonsNames[i]);
			mainPanel.add(buttons[i]);
			buttons[i].setBackground(Color.WHITE);
			buttons[i].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 35));
			buttons[i].setBackground(new Color(230,190,200));
			buttons[i].addActionListener(this);
		}
		buttons[12].setBackground(Color.ORANGE);
		buttons[14].setBackground(Color.magenta );
		add(mainPanel);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		lasttext =(String)button.getText();
		text = text+lasttext;
		if(lasttext.equals(" C ")) {
			inputs.setText("");
			text = "";
			endflag = false;
		}
		else if (endflag) {
			text = lasttext;
			endflag = false;
			}
		inputs.setText(text);

		if(lasttext.equals(" = ")) {
			String words[] = text.split(" ");
			if(words.length==2) {
				op = "no op";
				if(words[0].equals("")) {
					text = "";
					inputs.setText(text);
				}
				else {
					number1 = Integer.parseInt(words[0]);
					inputs.setText(text+number1);
				}
			}
			else if(words[2].equals("")) {
				op = "less";
				text = "input Error";
				inputs.setText(text);
				}
			else if(words.length >= 5) {
				inputs.setText("Multi operations are unvalide");
				op = "over";
			}
			else {
				number1 = Integer.parseInt(words[0]);
				number2 = Integer.parseInt(words[2]);
				op = words[1];
			}
			if(op.equals("-")){
				result = number1-number2;
				inputs.setText(text+(int)result);
			}
			else if(op.equals("+")){
				result = number1+number2;
				inputs.setText(text+(int)result);
			}
			else if(op.equals("×")){
				result = number1*number2;
				inputs.setText(text+(int)result);
			}
			else if(op.equals("/")){
				if(number2 != 0) {
					result = 1.0*number1/number2;
					inputs.setText(text+result);
				}else {
					inputs.setText(text+"infinity");
				}
			}
			endflag = true;
		}
	}

	public static void main(String[] args) {
		new Calculator();
	}

}
