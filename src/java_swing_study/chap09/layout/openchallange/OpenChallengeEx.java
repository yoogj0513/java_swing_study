package java_swing_study.chap09.layout.openchallange;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class OpenChallengeEx extends JFrame {

	private JPanel contentPane;
	private NorthPanel pNorth;
	private CenterPanel pCenter;

	/**
	 * Create the frame.
	 */
	public OpenChallengeEx() {
		initialize();
	}
	private void initialize() {
		setTitle("간단한 스윙 응용프로그램");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pNorth = new NorthPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		
		pCenter = new CenterPanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
	}

}
