package java_swing_study.chap09.layout.exam;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Exam01BorderLayout extends JFrame {

	private JPanel contentPane;
	private JButton btnNorth;
	private JButton btnWest;
	private JButton btnCenter;
	private JButton btnEast;
	private JButton btnSouth;

	/**
	 * Create the frame.
	 */
	public Exam01BorderLayout() {
		initialize();
	}
	private void initialize() {
		setTitle("BorderLayout Practice");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(7, 5));
		
		btnNorth = new JButton("North");
		contentPane.add(btnNorth, BorderLayout.NORTH);
		
		btnWest = new JButton("West");
		contentPane.add(btnWest, BorderLayout.WEST);
		
		btnCenter = new JButton("Center");
		contentPane.add(btnCenter, BorderLayout.CENTER);
		
		btnEast = new JButton("East");
		contentPane.add(btnEast, BorderLayout.EAST);
		
		btnSouth = new JButton("South");
		contentPane.add(btnSouth, BorderLayout.SOUTH);
	}

}
