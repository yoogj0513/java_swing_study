package java_swing_study.chap10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class MyAction4Listener implements ActionListener {
	private JTextField tfName;
	private JTextField tfNo;
	private JTextField tfDept;
	private JTextField tfSubj;

	public MyAction4Listener(JTextField tfName, JTextField tfNo, JTextField tfDept, JTextField tfSubj) {
		this.tfName = tfName;
		this.tfNo = tfNo;
		this.tfDept = tfDept;
		this.tfSubj = tfSubj;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
