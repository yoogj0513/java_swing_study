package java_swing_study.chap09;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContentPaneEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnOK;
	private JButton btnCancel;
	private JButton btnIgnore;

	/**
	 * Create the frame.
	 */
	public ContentPaneEx() {
		initialize();
	}
	private void initialize() {
		setTitle("ContentPane과 JFrame");
		// 창의 엑스버튼을 누르면 클로즈
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		// 가로좌표, 세로좌표, 가로너비, 세로너비
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		// 패딩과 같은 기능
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// contentPane을 넣어라. set
		setContentPane(contentPane);
		// 중앙 위치에 간격 5
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20)); 
		
		btnOK = new JButton("OK");
		btnOK.addActionListener(this);
		contentPane.add(btnOK);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);
		contentPane.add(btnCancel);
		
		btnIgnore = new JButton("Ignore");
		btnIgnore.addActionListener(this);
		contentPane.add(btnIgnore);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIgnore) {
			btnIgnoreActionPerformed(e);
		}
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		if (e.getSource() == btnOK) {
			btnOKActionPerformed(e);
		}
	}
	protected void btnOKActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, e.getActionCommand());
	}
	protected void btnCancelActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, e.getActionCommand());
	}
	protected void btnIgnoreActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, e.getActionCommand());
	}
}
