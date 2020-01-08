package java_swing_study.chap09.layout.exam;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class Exam07Bottom extends JPanel {
	private JLabel lblTitle02;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Exam07Bottom() {

		initialize();
	}
	private void initialize() {
		setBackground(new Color(255, 215, 0));
		
		lblTitle02 = new JLabel("계산 결과");
		lblTitle02.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		add(lblTitle02);
		
		textField = new JTextField();
		textField.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		add(textField);
		textField.setColumns(20);
	}

}
