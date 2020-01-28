package java_swing_study.chap13;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

public class ThreadTimerEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblTimer;
	private JPanel panel;
	private JButton btnStart;
	private JButton btnStop;
	private TimerThread th;
	private GugudanThread guTh;
	private JPanel pLbls;
	private JLabel lblRunnableTimer;
	private Thread th2;
	private JPanel pFl;
	private FlickeringLabel lbl1;
	private JLabel lb2;
	private FlickeringLabel lbl3;

	public ThreadTimerEx() {
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		btnStart = new JButton("Start");
		btnStart.addActionListener(this);
		panel.add(btnStart);

		btnStop = new JButton("Stop");
		btnStop.addActionListener(this);
		panel.add(btnStop);
		
		pLbls = new JPanel();
		contentPane.add(pLbls, BorderLayout.CENTER);
		pLbls.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblTimer = new JLabel("");
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimer.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 80));
		pLbls.add(lblTimer);
		
		
		lblRunnableTimer = new JLabel("");
		lblRunnableTimer.setOpaque(true);
		lblRunnableTimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblRunnableTimer.setFont(new Font("굴림", Font.BOLD, 80));
		pLbls.add(lblRunnableTimer);
		
		th = new TimerThread(lblTimer);
		guTh = new GugudanThread();
		TimerRunnable tr = new TimerRunnable(lblRunnableTimer);
		th2 = new Thread(tr);
		
		pFl = new JPanel();
		pLbls.add(pFl);
		
		lbl1 = new FlickeringLabel("깜박", 500);
		pFl.add(lbl1);
		
		lb2 = new JLabel("안깜박");
		pFl.add(lb2);
		
		lbl3 = new FlickeringLabel("여기도 깜박", 300);
		pFl.add(lbl3);
		
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnStop) {
			btnStopActionPerformed(e);
		}
		if (e.getSource() == btnStart) {
			btnStartActionPerformed(e);
		}
	}

	protected void btnStartActionPerformed(ActionEvent e) {
//		th = new TimerThread(lblTimer);
		System.out.println(th.getState());
		if(th.getState() == Thread.State.TERMINATED) {
			th = new TimerThread(lblTimer);
		}
		if(guTh.getState() == Thread.State.TERMINATED) {			
			guTh = new GugudanThread();
		}
		if(th2.getState() == Thread.State.TERMINATED) {
			th2 = new Thread(new TimerRunnable(lblRunnableTimer));
		}
		
		guTh.start();
		th.start();
		th2.start();
	}

	protected void btnStopActionPerformed(ActionEvent e) {
		System.out.println(th.getState());
		th.interrupt();
		guTh.interrupt();
		System.out.println(th.getState());
		th2.interrupt();
	}
}
