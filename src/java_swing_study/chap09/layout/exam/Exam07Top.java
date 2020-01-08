package java_swing_study.chap09.layout.exam;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class Exam07Top extends JPanel {
	private JTextField tfInput01;
	private JLabel lblTitle01;

	/**
	 * Create the panel.
	 */
	public Exam07Top() {

		initialize();
	}
	private void initialize() {
		setBackground(new Color(105, 105, 105));
		
		lblTitle01 = new JLabel("수식 입력");
		lblTitle01.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		add(lblTitle01);
		
		tfInput01 = new JTextField();
		tfInput01.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		add(tfInput01);
		tfInput01.setColumns(20);
	}

}
