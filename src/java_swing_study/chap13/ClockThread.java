package java_swing_study.chap13;

import java.util.Calendar;

import javax.swing.JLabel;

public class ClockThread extends Thread {
	private JLabel lblTime;

	public ClockThread(JLabel lblTime) {
		this.lblTime = lblTime;
	}

	@Override
	public void run() {
		while(true) {			
			Calendar c = Calendar.getInstance();
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int min = c.get(Calendar.MINUTE);
			int second = c.get(Calendar.SECOND);
			
			String clockText = Integer.toString(hour);
			clockText = clockText.concat(":");
			clockText = clockText.concat(Integer.toString(min));
			clockText = clockText.concat(":");
			clockText = clockText.concat(Integer.toString(second));
			lblTime.setText(clockText);
			
			try {
				sleep(1000);
//				System.out.println(getState());
			} catch (InterruptedException e) {
				return;
			}
		}
	}
	
}
