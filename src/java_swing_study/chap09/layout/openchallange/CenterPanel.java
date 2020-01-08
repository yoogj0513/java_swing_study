package java_swing_study.chap09.layout.openchallange;

import javax.swing.JPanel;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class CenterPanel extends JPanel {
	private JLabel lbHello;
	private JLabel lbJava;
	private JLabel lbLove;

	/**
	 * Create the panel.
	 */
	public CenterPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(null);
		
		lbHello = new JLabel("Hello");
		lbHello.setBounds(145, 47, 57, 15);
		add(lbHello);
		
		lbJava = new JLabel("Java");
		lbJava.setBounds(64, 167, 57, 15);
		add(lbJava);
		
		lbLove = new JLabel("Love");
		lbLove.setBounds(308, 118, 57, 15);
		add(lbLove);
	}

}
