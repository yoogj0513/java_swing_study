package java_swing_study.chap09.layout;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java_swing_study.chap09.layout.exam.Exam02BorderLayout;
import java_swing_study.chap09.layout.exam.Exam04GridLayout;
import java_swing_study.chap09.layout.exam.Exam05GridLayout;
import java_swing_study.chap09.layout.exam.Exam07OpenChallenge;
import java_swing_study.chap09.layout.exam.Exam08OpenChallenge;
import java_swing_study.chap09.layout.openchallange.OpenChallengeEx;
import javax.swing.UIManager;
import java.awt.Color;

@SuppressWarnings("serial")
public class LayoutMain extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel pleft;
	private JButton btnFlow;
	private JButton btnBorder;
	private JButton btnGrid;
	private JButton btnAbsolute;
	private JButton btnOpenChallenge;
	private JPanel pright;
	private JButton btnExam02;
	private JButton btnExam04;
	private JButton btnExam05;
	private JButton btnExam07;
	private JButton btnExam08;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LayoutMain frame = new LayoutMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LayoutMain() {
		initialize();
	}
	private void initialize() {
		setTitle("배치레이아웃예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 220);
		setLocation(100, 100);
//		setBounds(100, 100, 450, 107);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uC81C09\uC7A5 GUI \uAE30\uCD08", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 10));
		
		pleft = new JPanel();
		pleft.setBorder(new TitledBorder(null, "\uB808\uC774\uC544\uC6C3 \uC608\uC81C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pleft);
		pleft.setLayout(new GridLayout(0, 2, 10, 10));
		
		btnFlow = new JButton("FlowLayout");
		pleft.add(btnFlow);
		
		btnBorder = new JButton("BorderLayout");
		pleft.add(btnBorder);
		
		btnGrid = new JButton("GridLayout");
		pleft.add(btnGrid);
		
		btnAbsolute = new JButton("AbsoluteLayout");
		pleft.add(btnAbsolute);
		
		btnOpenChallenge = new JButton("OpenChallenge");
		pleft.add(btnOpenChallenge);
		
		pright = new JPanel();
		pright.setBorder(new TitledBorder(null, "\uC2E4\uC2B5\uBB38\uC81C \uD480\uC774", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pright);
		pright.setLayout(new GridLayout(0, 2, 10, 10));
		
		btnExam02 = new JButton("Exam02");
		btnExam02.addActionListener(this);
		pright.add(btnExam02);
		
		btnExam04 = new JButton("Exam04");
		btnExam04.addActionListener(this);
		pright.add(btnExam04);
		
		btnExam05 = new JButton("Exam05");
		btnExam05.addActionListener(this);
		pright.add(btnExam05);
		
		btnExam07 = new JButton("Exam07");
		btnExam07.addActionListener(this);
		pright.add(btnExam07);
		
		btnExam08 = new JButton("Exam08");
		btnExam08.addActionListener(this);
		pright.add(btnExam08);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExam08) {
			btnExam08ActionPerformed(e);
		}
		if (e.getSource() == btnExam07) {
			btnExam07ActionPerformed(e);
		}
		if (e.getSource() == btnExam05) {
			btnExam05ActionPerformed(e);
		}
		if (e.getSource() == btnExam04) {
			btnExam04ActionPerformed(e);
		}
		if (e.getSource() == btnExam02) {
			btnExam02ActionPerformed(e);
		}
	}
	protected void btnExam02ActionPerformed(ActionEvent e) {
		Exam02BorderLayout frame = new Exam02BorderLayout();
		frame.setVisible(true);
	}
	protected void btnExam04ActionPerformed(ActionEvent e) {
		Exam04GridLayout frame = new Exam04GridLayout();
		frame.setVisible(true);
	}
	protected void btnExam05ActionPerformed(ActionEvent e) {
		Exam05GridLayout frame = new Exam05GridLayout();
		frame.setVisible(true);
	}
	protected void btnExam07ActionPerformed(ActionEvent e) {
		Exam07OpenChallenge frame = new Exam07OpenChallenge();
		frame.setVisible(true);
	}
	protected void btnExam08ActionPerformed(ActionEvent e) {
		Exam08OpenChallenge frame = new Exam08OpenChallenge();
		frame.setVisible(true);
	}
}
