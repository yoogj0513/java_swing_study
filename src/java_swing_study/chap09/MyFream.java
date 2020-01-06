package java_swing_study.chap09;

import java.awt.HeadlessException;

import javax.swing.JFrame;

public class MyFream extends JFrame {

	public MyFream() throws HeadlessException {
		setTitle("300X300 스윙프레임 만들기");
		setSize(300, 300);
		setVisible(true);
	}
	
}
