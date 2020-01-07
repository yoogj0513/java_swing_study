package java_swing_study.chap09.layout;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class BorderLayoutEx extends JFrame {

	private JPanel contentPane;
	private JButton btnAdd;
	private JButton btndiv;
	private JButton btnCalculate;
	private JButton btnMul;
	private JButton btnSub;

	/**
	 * Create the frame.
	 */
	public BorderLayoutEx() {
		initialize();
	}
	private void initialize() {
		setTitle("BorderLayout Sample");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(30, 20));
		setContentPane(contentPane);
		
		btnAdd = new JButton("add");
		contentPane.add(btnAdd, BorderLayout.NORTH);
		
		btndiv = new JButton("div");
		contentPane.add(btndiv, BorderLayout.WEST);
		
		btnCalculate = new JButton("Calculate");
		contentPane.add(btnCalculate, BorderLayout.CENTER);
		
		btnMul = new JButton("mul");
		contentPane.add(btnMul, BorderLayout.EAST);
		
		btnSub = new JButton("sub");
		contentPane.add(btnSub, BorderLayout.SOUTH);
	}

}
