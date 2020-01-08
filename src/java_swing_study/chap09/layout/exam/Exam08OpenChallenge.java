package java_swing_study.chap09.layout.exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Exam08OpenChallenge extends JFrame {

	private JPanel contentPane;
	private Exam08North panel;
	private Exam08Center panel_1;
	private Exam08South panel_2;

	/**
	 * Create the frame.
	 */
	public Exam08OpenChallenge() {
		initialize();
	}
	private void initialize() {
		setTitle("여러 개의 패널을 가진 프레임");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new Exam08North();
		contentPane.add(panel, BorderLayout.NORTH);
		
		panel_1 = new Exam08Center();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		panel_2 = new Exam08South();
		contentPane.add(panel_2, BorderLayout.SOUTH);
	}

}
