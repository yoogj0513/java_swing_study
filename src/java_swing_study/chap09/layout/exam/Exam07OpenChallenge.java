package java_swing_study.chap09.layout.exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Window.Type;

public class Exam07OpenChallenge extends JFrame {

	private JPanel contentPane;
	private Exam07Top panel;
	private Exam07Center panel_1;
	private Exam07Bottom panel_2;

	/**
	 * Create the frame.
	 */
	public Exam07OpenChallenge() {
		initialize();
	}
	private void initialize() {
		setTitle("계산기 프레임");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new Exam07Top();
		contentPane.add(panel, BorderLayout.NORTH);
		
		panel_1 = new Exam07Center();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		panel_2 = new Exam07Bottom();
		contentPane.add(panel_2, BorderLayout.SOUTH);
	}

}
