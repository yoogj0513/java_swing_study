package java_swing_study.chap13;

import java.awt.EventQueue;

public class MainClass {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThreadTimerEx frame = new ThreadTimerEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
