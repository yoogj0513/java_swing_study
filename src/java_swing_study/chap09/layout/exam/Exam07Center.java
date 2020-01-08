package java_swing_study.chap09.layout.exam;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class Exam07Center extends JPanel {
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
	private JButton btnCE;
	private JButton btnCal;
	private JButton btnAdd;
	private JButton btnSub;
	private JButton btnMul;
	private JButton btnDiv;

	/**
	 * Create the panel.
	 */
	public Exam07Center() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 4, 5, 5));
		
		btn0 = new JButton("0");
		btn0.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		add(btn0);
		
		btn1 = new JButton("1");
		btn1.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		add(btn1);
		
		btn2 = new JButton("2");
		btn2.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		add(btn2);
		
		btn3 = new JButton("3");
		btn3.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		add(btn3);
		
		btn4 = new JButton("4");
		btn4.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		add(btn4);
		
		btn5 = new JButton("5");
		btn5.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		add(btn5);
		
		btn6 = new JButton("6");
		btn6.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		add(btn6);
		
		btn7 = new JButton("7");
		btn7.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		add(btn7);
		
		btn8 = new JButton("8");
		btn8.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		add(btn8);
		
		btn9 = new JButton("9");
		btn9.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		add(btn9);
		
		btnCE = new JButton("CE");
		btnCE.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		add(btnCE);
		
		btnCal = new JButton("계산");
		btnCal.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		add(btnCal);
		
		btnAdd = new JButton("+");
		btnAdd.setBackground(new Color(0, 139, 139));
		btnAdd.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		add(btnAdd);
		
		btnSub = new JButton("-");
		btnSub.setBackground(new Color(0, 139, 139));
		btnSub.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		add(btnSub);
		
		btnMul = new JButton("x");
		btnMul.setBackground(new Color(0, 139, 139));
		btnMul.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		add(btnMul);
		
		btnDiv = new JButton("/");
		btnDiv.setBackground(new Color(0, 139, 139));
		btnDiv.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		add(btnDiv);
	}

}
