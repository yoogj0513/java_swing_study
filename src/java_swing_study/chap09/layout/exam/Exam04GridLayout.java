package java_swing_study.chap09.layout.exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;

public class Exam04GridLayout extends JFrame {

	private JPanel contentPane;
	private JButton btn0;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;

	/**
	 * Create the frame.
	 */
	public Exam04GridLayout() {
		initialize();
	}
	private void initialize() {
		setTitle("Ten Color Buttons Frame");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 10, 0, 0));
		
		btn0 = new JButton("0");
		btn0.setBackground(Color.RED);
		contentPane.add(btn0);
		
		btn1 = new JButton("1");
		btn1.setBackground(Color.ORANGE);
		contentPane.add(btn1);
		
		btn2 = new JButton("2");
		btn2.setBackground(Color.YELLOW);
		contentPane.add(btn2);
		
		btn3 = new JButton("3");
		btn3.setBackground(new Color(0, 128, 0));
		contentPane.add(btn3);
		
		btn4 = new JButton("4");
		btn4.setBackground(new Color(0, 191, 255));
		contentPane.add(btn4);
		
		btn5 = new JButton("5");
		btn5.setBackground(new Color(0, 0, 128));
		contentPane.add(btn5);
		
		btn6 = new JButton("6");
		btn6.setBackground(new Color(148, 0, 211));
		contentPane.add(btn6);
		
		btn7 = new JButton("7");
		btn7.setBackground(new Color(0, 128, 128));
		contentPane.add(btn7);
		
		btn8 = new JButton("8");
		btn8.setBackground(new Color(221, 160, 221));
		contentPane.add(btn8);
		
		btn9 = new JButton("9");
		btn9.setBackground(new Color(128, 128, 128));
		contentPane.add(btn9);
	}

}
