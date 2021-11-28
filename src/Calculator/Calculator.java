package Calculator;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.MaskFormatter;

public class Calculator extends JFrame implements ActionListener {

	public static void main(String[] args) {
		Calculator calculadora = new Calculator();
	}
	JLabel text;
	MaskFormatter mask = null;
	JFormattedTextField l = new JFormattedTextField(mask);
	JButton b[], sum, sub, mult, div, equal, ce, put;
	double result = 0;
	boolean sumT, subT, divT, multT;


	public Calculator() {
		//Container window = getContentPane();
		setLayout(null);
		l.setText("0");
		l.setBounds(25,30,335,30);
		text = new JLabel ("");
		text.setBounds(25,15,335,10);

		b = new JButton[10];
		for (int i = 0; i < b.length; i++) {
			b[i] = new JButton(i + "");
		}
		sum = new JButton("+");
		sub = new JButton("-");
		mult = new JButton("*");
		div = new JButton("/");
		equal = new JButton("=");
		ce = new JButton("CE");
		put = new JButton(".");

		sum.setBounds(280,70,80,60);
		sub.setBounds(280,140,80,60);
		mult.setBounds(280,210,40,60);
		div.setBounds(320,210,40,60);
		equal.setBounds(280,280,80,60);
		ce.setBounds(195,280,80,60);
		put.setBounds(25,280,80,60);

		b[0].setBounds(110,280,80,60);
		b[1].setBounds(25,210,80,60);
		b[2].setBounds(110,210,80,60);
		b[3].setBounds(195,210,80,60);
		b[4].setBounds(25,140,80,60);
		b[5].setBounds(110,140,80,60);
		b[6].setBounds(195,140,80,60);
		b[7].setBounds(25,70,80,60);
		b[8].setBounds(110,70,80,60);
		b[9].setBounds(195,70,80,60);

		add(l);
		add(text);
		for (int i = 0; i < b.length; i++) {
			add(b[i]);
		}
		add(sum);
		add(sub);
		add(mult);
		add(div);
		add(equal);
		add(ce);
		add(put);

		sum.addActionListener(this);
		sub.addActionListener(this);
		mult.addActionListener(this);
		div.addActionListener(this);
		equal.addActionListener(this);
		ce.addActionListener(this);
		put.addActionListener(this);

		for (int i = 0; i < b.length; i++) {
			b[i].addActionListener(this);
		}
		setVisible(true);
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent e) {
		String textStr = text.getText();
		double num = Double.parseDouble(l.getText());
		if (l.getText().equals("0")) {
			if(e.getSource() != equal) {
			for(int i = 0; i < b.length; i++) {
				if (b[i] == e.getSource()) {
					l.setText(i + "");
				}			
			}
			}else {
				text.setText("=" + result);
				l.setText("0");
			}
		}else {
			if (e.getSource() == sum) {
				result += num;
				if (textStr.equals(""))
					text.setText(num + "");
				else
					text.setText(textStr + "+" + num);
				l.setText("0");
				sumT = true; subT = false; divT = false; multT = false;
			}else if(e.getSource() == sub) {
				result -= num;
				if (textStr.equals(""))
					text.setText(num + "");
				else
					text.setText(textStr + "-" + num);
				l.setText("0");
				sumT = false; subT = true; divT = false; multT = false;
			}else if (e.getSource() == div) {
				result = result / num;
				if (textStr.equals(""))
					text.setText(num + "");
				else
					text.setText("(" + textStr + ")" + "/" + num);
				l.setText("0");
				sumT = false; subT = false; divT = true; multT = false;
			}else if (e.getSource() == mult) {
				result = result * num;
				if (textStr.equals(""))
					text.setText(num + "");
				else
					text.setText("(" + textStr + ")" + "x" + num);
				l.setText("0");
				sumT = false; subT = false; divT = false; multT = true;
			}else if (e.getSource() == equal) {
				if (sumT == true)
					result += num;
				else if (subT == true)
					result -= num;
				else if (divT == true) 
					result = result / num;
				else if (multT == true) 
					result = result * num;
				text.setText("=" + result);
				l.setText("0");
			}else if (e.getSource() == put) {
				l.setText(l.getText() + ".");
			}else if(e.getSource() == ce) {
				result = 0;
				text.setText("");
				l.setText("0");
			} else {
				for(int i = 0; i < b.length; i++) {
					if (b[i] == e.getSource()) {
						l.setText(l.getText() + i);
					}	
				}
			}
		}
	}
}
