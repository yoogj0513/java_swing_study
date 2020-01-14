package java_swing_study.chap11;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import java.awt.event.ItemListener;
import java.util.HashMap;
import java.awt.event.ItemEvent;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class RadioButtonEx extends JFrame implements ItemListener, ActionListener {

	private JPanel contentPane;
	private JPanel pLeft;
	private JPanel pRight;
	private JPanel pRdbBtns;
	private JPanel pLblImg;
	private JRadioButton rdbtnApple;
	private JRadioButton rdbtnPear;
	private JRadioButton rdbtnCherry;
	private JLabel lblImg;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private HashMap<String, ImageIcon> icons;
	private JButton btnApple;
	private JButton btnPear;
	private JButton btnCherry;
	private JButton btnConfirm;
	private JTextField txtTest;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RadioButtonEx frame = new RadioButtonEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RadioButtonEx() {
		icons = new HashMap<String, ImageIcon>();
		String imgDirPaht = System.getProperty("user.dir") + "\\images\\";
		icons.put("사과", new ImageIcon(imgDirPaht+"apple.jpg"));
		icons.put("배", new ImageIcon(imgDirPaht+"pear.jpg"));
		icons.put("체리", new ImageIcon(imgDirPaht+"cherry.jpg"));
		initialize();
	}
	private void initialize() {
		setTitle("라디오버튼 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uB77C\uB514\uC624\uBC84\uD2BC\uC608\uC81C", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 0));
		
		pLeft = new JPanel();
		contentPane.add(pLeft);
		pLeft.setLayout(new BorderLayout(0, 0));
		
		pRdbBtns = new JPanel();
		pLeft.add(pRdbBtns, BorderLayout.NORTH);
		
		rdbtnApple = new JRadioButton("사과");
		buttonGroup.add(rdbtnApple);
		pRdbBtns.add(rdbtnApple);
		
		rdbtnPear = new JRadioButton("배");
		buttonGroup.add(rdbtnPear);
		pRdbBtns.add(rdbtnPear);
		
		rdbtnCherry = new JRadioButton("체리");
		buttonGroup.add(rdbtnCherry);
		pRdbBtns.add(rdbtnCherry);
		
		pLblImg = new JPanel();
		pLblImg.setBorder(new EmptyBorder(10, 10, 10, 10));
		pLeft.add(pLblImg, BorderLayout.CENTER);
		pLblImg.setLayout(new BorderLayout(0, 0));
		
		lblImg = new JLabel("");
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		pLblImg.add(lblImg, BorderLayout.CENTER);
		
		pRight = new JPanel();
		contentPane.add(pRight);
		pRight.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnApple = new JButton("사과 선택");
		btnApple.addActionListener(this);
		pRight.add(btnApple);
		
		btnPear = new JButton("배 선택");
		btnPear.addActionListener(this);
		pRight.add(btnPear);
		
		btnCherry = new JButton("체리 선택");
		btnCherry.addActionListener(this);
		pRight.add(btnCherry);
		
		btnConfirm = new JButton("선택한 과일 확인");
		btnConfirm.addActionListener(this);
		pRight.add(btnConfirm);
		
		txtTest = new JTextField();
		txtTest.setText("test");
		pRight.add(txtTest);
		txtTest.setColumns(10);
		
		// 리스너는 가장 마지막에 위치하는 것이 안전
		rdbtnApple.addItemListener(this);
		rdbtnPear.addItemListener(this);
		rdbtnCherry.addItemListener(this);
		// 처음 화면에 선택
		rdbtnApple.setSelected(true);
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == rdbtnCherry) {
			rdbtnCherryItemStateChanged(e);
		}
		if (e.getSource() == rdbtnPear) {
			rdbtnPearItemStateChanged(e);
		}
		if (e.getSource() == rdbtnApple) {
			rdbtnAppleItemStateChanged(e);
		}
	}
	
	protected void rdbtnAppleItemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
//			JOptionPane.showMessageDialog(null, rdbtnApple.getText());
			lblImg.setIcon(icons.get(rdbtnApple.getText()));
		} 
	}
	
	protected void rdbtnPearItemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
//			JOptionPane.showMessageDialog(null, ((JRadioButton)e.getItem()).getText());
			lblImg.setIcon(icons.get(rdbtnPear.getText()));
		} 
	}

	protected void rdbtnCherryItemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
//			JOptionPane.showMessageDialog(null, ((JRadioButton)e.getItem()).getText());
			lblImg.setIcon(icons.get(rdbtnCherry.getText()));
		} 
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConfirm) {
			btnConfirmActionPerformed(e);
		}
		if (e.getSource() == btnCherry) {
			btnCherryActionPerformed(e);
		}
		if (e.getSource() == btnPear) {
			btnPearActionPerformed(e);
		}
		if (e.getSource() == btnApple) {
			btnAppleActionPerformed(e);
		}
	}
	protected void btnAppleActionPerformed(ActionEvent e) {
		rdbtnApple.setSelected(true);
	}
	protected void btnPearActionPerformed(ActionEvent e) {
		rdbtnPear.setSelected(true);
	}
	protected void btnCherryActionPerformed(ActionEvent e) {
		rdbtnCherry.setSelected(true);
	}
	protected void btnConfirmActionPerformed(ActionEvent e) {
		for(Component c : pRdbBtns.getComponents()) {
			if (c instanceof JRadioButton) {
				JRadioButton chk = (JRadioButton) c;
				if(chk.isSelected()) {
					JOptionPane.showMessageDialog(null, "선택된 과일은 " + chk.getText());
				}
			}
		}
	}
}
