package java_swing_study.chap10;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MyAction3Listener2 implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if(btn.getParent().getParent().getBackground() == Color.yellow) {
			btn.getParent().getParent().setBackground(Color.red);
		} else {
			btn.getParent().getParent().setBackground(Color.yellow);
		}
	}

}
