package java_swing_study.chap09.layout.exam;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;

public class Exam08South extends JPanel {
	private JButton btnInput;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Exam08South() {

		initialize();
	}
	private void initialize() {
		setBackground(new Color(255, 215, 0));
		
		btnInput = new JButton("Word Input");
		add(btnInput);
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(20);
	}

}
