package java_swing_study.chap11;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckBoxItemEventEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel pLeft;
	private JPanel pRight;
	private JLabel lblTitle;
	private JPanel pCheckBox;
	private JLabel lblSum;
	private JCheckBox chApple;
	private JCheckBox chPear;
	private JCheckBox chCherry;
	private JButton btn1;
	private JButton btn2;
	private JButton btn4;
	private JButton btn5;
	private JButton btn3;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckBoxItemEventEx frame = new CheckBoxItemEventEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CheckBoxItemEventEx() {
		initialize();
	}

	private void initialize() {
		setTitle("체크박스 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 10));

		pLeft = new JPanel();
		pLeft.setBorder(
				new TitledBorder(null, "\uC608\uC81C 11-4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pLeft);
		pLeft.setLayout(new BorderLayout(0, 0));

		lblTitle = new JLabel("사과 100원, 배 500원, 체리 20000원");
		lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		pLeft.add(lblTitle, BorderLayout.NORTH);

		pCheckBox = new JPanel();
		pLeft.add(pCheckBox, BorderLayout.CENTER);
		pCheckBox.setLayout(new GridLayout(0, 3, 0, 0));

		MyItemListner listener = new MyItemListner();

		chApple = new JCheckBox("사과");
		chApple.setHorizontalAlignment(SwingConstants.CENTER);
		chApple.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		chApple.setBorderPainted(true);
		;
		chApple.addItemListener(listener);
		pCheckBox.add(chApple);

		chPear = new JCheckBox("배");
		chPear.setHorizontalAlignment(SwingConstants.CENTER);
		chPear.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		chPear.setBorderPainted(true);
		chPear.addItemListener(listener);
		pCheckBox.add(chPear);

		chCherry = new JCheckBox("체리");
		chCherry.setHorizontalAlignment(SwingConstants.CENTER);
		chCherry.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		chCherry.setBorderPainted(true);
		chCherry.addItemListener(listener);
		pCheckBox.add(chCherry);

		lblSum = new JLabel("현재 0원 입니다.");
		lblSum.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblSum.setHorizontalAlignment(SwingConstants.CENTER);
		pLeft.add(lblSum, BorderLayout.SOUTH);

		// ----------------------------------------------------------------------------------------------------
		pRight = new JPanel();
		pRight.setBorder(new TitledBorder(null, "select", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pRight);
		pRight.setLayout(new GridLayout(0, 1, 5, 5));

		btn1 = new JButton("사과 선택");
		btn1.addActionListener(this);
		pRight.add(btn1);

		btn2 = new JButton("배 선택");
		btn2.addActionListener(this);
		pRight.add(btn2);

		btn4 = new JButton("모두 선택");
		btn4.addActionListener(this);

		btn3 = new JButton("체리 선택");
		btn3.addActionListener(this);
		pRight.add(btn3);
		pRight.add(btn4);

		btn5 = new JButton("선택된 과일 보기");
		btn5.addActionListener(this);
		pRight.add(btn5);

	}

	class MyItemListner implements ItemListener {
		private int sum = 0;

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				if (e.getItem() == chApple) {
					sum += 100;
					btn1.setText("사과 취소");
				} else if (e.getItem() == chPear) {
					sum += 500;
					btn2.setText("배 취소");
				} else if (e.getItem() == chCherry) {
					sum += 20000;
					btn3.setText("체리 취소");
				}
			} else {
				if (e.getItem() == chApple) {
					sum -= 100;
					btn1.setText("사과 선택");
				} else if (e.getItem() == chPear) {
					sum -= 500;
					btn2.setText("배 선택");
				} else if (e.getItem() == chCherry) {
					sum -= 20000;
					btn3.setText("체리 선택");
				}
			}
			lblSum.setText("현재 " + sum + "원 입니다.");
		}

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn5) {
			btn5ActionPerformed(e);
		}
		if (e.getSource() == btn4) {
			btn4ActionPerformed(e);
		}
		if (e.getSource() == btn3) {
			chkSetSelected(chCherry, btn3);
		}
		if (e.getSource() == btn2) {
			chkSetSelected(chPear, btn2);
		}
		if (e.getSource() == btn1) {
			chkSetSelected(chApple, btn1);
		}
	}
	
	private void chkSetSelected(JCheckBox ch, JButton btn) {
		if(ch.isSelected()) {
			ch.setSelected(false);
			btn.setText(ch.getText() + " 선택");
		} else {
			ch.setSelected(true);
			btn.setText(ch.getText() + " 취소");
		}
	}

//	protected void btn1ActionPerformed(ActionEvent e) {
//		if (chApple.isSelected() == true) {
//			chApple.setSelected(false);
//			btn1.setText("사과선택");
//		} else {
//			chApple.setSelected(true);
//			btn1.setText("사과취소");
//		}
//	}
//
//	protected void btn2ActionPerformed(ActionEvent e) {
//		if (chPear.isSelected() == true) {
//			chPear.setSelected(false);
//			btn2.setText("배 선택");
//		} else {
//			chPear.setSelected(true);
//			btn2.setText("배 취소");
//		}
//	}
//
//	private void btn3ActionPerformed(ActionEvent e) {
//		if (chCherry.isSelected() == true) {
//			chCherry.setSelected(false);
//			btn3.setText("체리 선택");
//		} else {
//			chCherry.setSelected(true);
//			btn3.setText("체리 취소");
//		}
//	}

	protected void btn4ActionPerformed(ActionEvent e) {
		if (chApple.isSelected() && chPear.isSelected() && chCherry.isSelected()) {
			chApple.setSelected(false);
			chPear.setSelected(false);
			chCherry.setSelected(false);
			btn4.setText("모든 과일 선택");
		} else {
			for(Component c : pCheckBox.getComponents()) {
				if(c instanceof JCheckBox) {
					JCheckBox chk = (JCheckBox) c;
					chk.setSelected(true);
				}
			}
//			chApple.setSelected(true);
//			chPear.setSelected(true);
//			chCherry.setSelected(true);
			btn4.setText("모든 과일 취소");
		}
	}

	protected void btn5ActionPerformed(ActionEvent e) {
//		String items = "";
//		String message = "선택한 과일은 " + items;
//		
//		if(chApple.isSelected() == true) {
//			chApple.getText();
//		}
//		
//		if(chPear.isSelected() == true) {
//			chPear.getText();
//		}
//		
//		if(chCherry.isSelected() == true) {
//			chCherry.getText();
//		}

		StringBuilder sb = new StringBuilder();
		for (Component c : pCheckBox.getComponents()) {
			if (c instanceof JCheckBox) {
				JCheckBox chk = (JCheckBox) c;
				if (chk.isSelected()) {
					sb.append(chk.getText() + ", ");
				}
			}
		}
		
		String message = sb.length() == 0 ? "없음" : sb.substring(0, sb.length() - 2);

		JOptionPane.showMessageDialog(null, "선택한 과일은 " + message);
	}
}
