package java_swing_study.chap10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class MyAction4Listener2 implements ActionListener {
	private JTextField tfName;
	private JTextField tfNo;
	private JTextField tfDept;
	private JTextField tfSubj;
	
	public MyAction4Listener2(JTextField tfName, JTextField tfNo, JTextField tfDept, JTextField tfSubj) {
		this.tfName = tfName;
		this.tfNo = tfNo;
		this.tfDept = tfDept;
		this.tfSubj = tfSubj;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Student std = new Student();
		tfName.setText(std.getName());
		tfNo.setText(String.valueOf(std.getStdNo()));
		tfDept.setText(std.getDept());
		tfSubj.setText(std.getSubj());
	}

}
