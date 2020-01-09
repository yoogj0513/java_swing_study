package java_swing_study.chap10;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import java_swing_study.chap09.ContentPaneEx;

public class MyAction3Listener implements ActionListener {
	private JPanel contentPane;

	public MyAction3Listener(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(contentPane.getBackground() == Color.yellow) {
			contentPane.setBackground(Color.red);
		} else {
			contentPane.setBackground(Color.yellow);
		}
	}
	

}
