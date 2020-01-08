package java_swing_study.chap09.layout.exam;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;

public class Exam08North extends JPanel {
	private JButton btnOpen;
	private JButton btnClose;
	private JButton btnOut;

	/**
	 * Create the panel.
	 */
	public Exam08North() {

		initialize();
	}
	private void initialize() {
		setBackground(new Color(128, 128, 128));
		
		btnOpen = new JButton("열기");
		add(btnOpen);
		
		btnClose = new JButton("닫기");
		add(btnClose);
		
		btnOut = new JButton("나가기");
		add(btnOut);
	}

}
