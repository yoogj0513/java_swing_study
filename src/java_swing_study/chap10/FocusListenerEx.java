package java_swing_study.chap10;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class FocusListenerEx extends JFrame {

	private JPanel contentPane;
	private JLabel lblName;
	private JTextField tfName;
	private JLabel lblNO;
	private JTextField tfNo;
	private JLabel lblDept;
	private JTextField tfDept;
	private JLabel lblSubj;
	private JTextField tfSubj;
	private JLabel lblRes;
	private JPasswordField pw1;
	private JPasswordField pw2;
	private JLabel lblConfirm;
	private JButton btnOk;
	private JButton btnCancel;

	public FocusListenerEx() {
		initialize();
	}
	private void initialize() {
		setTitle("GridLayout Sample");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 20, 5));
		
		lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblName);
		
		tfName = new JTextField();
		// 텍스트 필드의 글자가 제거되거나 추가되거나 변경되면 호출됨
		tfName.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				msg();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				msg();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				msg();				
			}
			
			public void msg() {
				lblRes.setText(String.format("removeUpdate() %s 길이 : %d", tfName.getText(), tfName.getText().length()));
			}
		});
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		lblNO = new JLabel("학번");
		lblNO.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNO);
		
		tfNo = new JTextField();
		tfNo.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if(tfName.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "이름을 입력하세요.");
				}
			}
		});
		tfNo.setColumns(10);
		contentPane.add(tfNo);
		
		lblDept = new JLabel("학과");
		lblDept.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblDept);
		
		tfDept = new JTextField();
		tfDept.setColumns(10);
		contentPane.add(tfDept);
		
		lblSubj = new JLabel("과목");
		lblSubj.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblSubj);
		
		tfSubj = new JTextField();
		tfSubj.setColumns(10);
		contentPane.add(tfSubj);
		
		lblRes = new JLabel("이름필드 글자수");
		contentPane.add(lblRes);
		
		tfSubj.setRequestFocusEnabled(true);
		
		lblConfirm = new JLabel("");
		lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirm.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblConfirm.setForeground(Color.RED);
		contentPane.add(lblConfirm);
		
		pw1 = new JPasswordField();
		pw1.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				isEqualPw();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				isEqualPw();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				isEqualPw();
			}
			
			public void isEqualPw() {
				String pass1 = new String(pw1.getPassword());
				String pass2 = new String(pw2.getPassword());
				
				if(pass1.equals(pass2)) {
					lblConfirm.setText("일치");
				} else {
					lblConfirm.setText("불일치");
				}
			}
		});
		contentPane.add(pw1);
		
		pw2 = new JPasswordField();
		pw2.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				isEqualPw();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				isEqualPw();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				isEqualPw();
			}
			
			public void isEqualPw() {
				String pass1 = new String(pw1.getPassword());
				String pass2 = new String(pw2.getPassword());
				
				System.out.printf("pw1 : %s pw2: %s%n", pass1, pass2);
				
				if(pass1.equals(pass2)) {
					lblConfirm.setText("일치");
				} else {
					lblConfirm.setText("불일치");
				}
			};
		});
		contentPane.add(pw2);
		
		btnOk = new JButton("확인");
		btnOk.addActionListener(new MyAction4Listener(tfName, tfNo, tfDept, tfSubj));
		contentPane.add(btnOk);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tfName.setText("");
				tfNo.setText("");
				tfDept.setText("");
				tfSubj.setText("");
			}
		});
		contentPane.add(btnCancel);
	}
	
	public JTextField getTfSubj() {
		return tfSubj;
	}
	
	public static void main(String[] args) {
		FocusListenerEx frame = new FocusListenerEx();
		frame.setVisible(true);
		
		frame.getTfSubj().requestFocus();
	}
}
