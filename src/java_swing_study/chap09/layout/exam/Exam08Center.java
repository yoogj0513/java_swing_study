package java_swing_study.chap09.layout.exam;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;

public class Exam08Center extends JPanel {
	private JLabel lbl0;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JLabel lbl6;
	private JLabel lbl7;
	private JLabel lbl8;

	/**
	 * Create the panel.
	 */
	public Exam08Center() {

		initialize();
	}
	private void initialize() {
		setLayout(null);
		
		lbl0 = new JLabel("*");
		lbl0.setForeground(new Color(255, 69, 0));
		lbl0.setBounds(60, 42, 57, 15);
		add(lbl0);
		
		lbl1 = new JLabel("*");
		lbl1.setForeground(new Color(255, 69, 0));
		lbl1.setBounds(85, 67, 57, 15);
		add(lbl1);
		
		lbl2 = new JLabel("*");
		lbl2.setForeground(new Color(255, 69, 0));
		lbl2.setBounds(301, 30, 57, 15);
		add(lbl2);
		
		lbl3 = new JLabel("*");
		lbl3.setForeground(new Color(255, 69, 0));
		lbl3.setBounds(283, 55, 57, 15);
		add(lbl3);
		
		lbl4 = new JLabel("*");
		lbl4.setForeground(new Color(255, 69, 0));
		lbl4.setBounds(324, 123, 57, 15);
		add(lbl4);
		
		lbl5 = new JLabel("*");
		lbl5.setForeground(new Color(255, 69, 0));
		lbl5.setBounds(240, 136, 57, 15);
		add(lbl5);
		
		lbl6 = new JLabel("*");
		lbl6.setForeground(new Color(255, 69, 0));
		lbl6.setBounds(34, 241, 57, 15);
		add(lbl6);
		
		lbl7 = new JLabel("*");
		lbl7.setForeground(new Color(255, 69, 0));
		lbl7.setBounds(301, 222, 57, 15);
		add(lbl7);
		
		lbl8 = new JLabel("*");
		lbl8.setForeground(new Color(255, 69, 0));
		lbl8.setBounds(349, 148, 57, 15);
		add(lbl8);
	}

}
