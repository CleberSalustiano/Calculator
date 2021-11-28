package ToyCalculator;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Calc extends JFrame implements ActionListener {
	JTextField t1, t2;
	JButton sum, sub, mult, div;
	JLabel l;
	
	public Calc() {
		t1 = new JTextField(15);
		t2 = new JTextField(15);
		sum = new JButton("Sum");
		sub = new JButton("Sub");
		mult = new JButton("Mult");
		div = new JButton("Div");
		l = new JLabel("Result ");
		
		add(t1);
		add(t2);
		add(sum);
		add(sub);
		add(mult);
		add(div);
		add(l);
		
		sum.addActionListener(this);
		sub.addActionListener(this);
		mult.addActionListener(this);
		div.addActionListener(this);
		
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		double num1 = Integer.parseInt(t1.getText());
		double num2 = Integer.parseInt(t2.getText());
		double value;
		
		if(e.getSource() == sum) {
			value = num1 + num2;
			l.setText("Result: " + value);
		}else if(e.getSource() == sub) {
			value = num1 - num2;
			l.setText("Result: " + value);
		}else if(e.getSource() == mult) {
			value = num1 * num2;
			l.setText("Result: " + value);
		}else if(e.getSource() == div) {
			value = num1 / num2;
			l.setText("Result: " + value);
		}
			
	}
	
	
}
