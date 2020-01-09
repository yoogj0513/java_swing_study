package java_swing_study.chap10;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class YourEventLitenerEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JButton btn01;
	private JButton btn02;
	private JButton btn03;
	private JButton btn04;
	private JButton btn02_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YourEventLitenerEx frame = new YourEventLitenerEx();
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
	public YourEventLitenerEx() {
		initialize();
	}
	private void initialize() {
		setTitle("리스너 학생 실습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 20, 10, 20));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 10));
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\uC708\uB3C4\uC6B0\uBE4C\uB354\uC81C\uACF5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		btn01 = new JButton("배경색변경");
		btn01.addActionListener(this);
		panel.add(btn01, BorderLayout.CENTER);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\uB3C5\uB9BD\uD074\uB798\uC2A4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		btn02 = new JButton("배경색변경(독립)");
		panel_1.add(btn02);
		btn02.addActionListener(new MyAction3Listener(contentPane));
		
		btn02_1 = new JButton("배경색변경(독립2)");
		btn02_1.addActionListener(new MyAction3Listener2());
		panel_1.add(btn02_1);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\uB0B4\uBD80\uD074\uB798\uC2A4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		btn03 = new JButton("배경색 변경(내부)");
		btn03.addActionListener(new MyAction4Listener());
		panel_2.add(btn03, BorderLayout.CENTER);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uC775\uBA85\uD074\uB798\uC2A4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		btn04 = new JButton("배경색 변경(익명)");
		btn04.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(contentPane.getBackground());
				if(contentPane.getBackground() == Color.yellow) {
					contentPane.setBackground(Color.red);
				} else {
					contentPane.setBackground(Color.yellow);
				}
				
			}
		});
		panel_3.add(btn04, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn01) {
			btn01ActionPerformed(e);
		}
	}
	protected void btn01ActionPerformed(ActionEvent e) {
		System.out.println(contentPane.getBackground());
		if(contentPane.getBackground()==Color.yellow) {			
			contentPane.setBackground(Color.red);
		} else {
			contentPane.setBackground(Color.yellow);
		}
	}
	
	class MyAction4Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(contentPane.getBackground());
			if(contentPane.getBackground() == Color.yellow) {
				contentPane.setBackground(Color.red);
			} else {
				contentPane.setBackground(Color.yellow);
			}
		}
		
	}
}
