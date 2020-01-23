package java_swing_study.chap14;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.JTabbedPane;
import java_swing_study.chap14.exam.ui.panel.StudentPanel;

public class OptionPanelEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel pTop;
	private JPanel pCenter;
	private JPanel pPopupDlg;
	private JPanel pFileDlg;
	private JPanel pColorDlg;
	private JButton btnPopupInput;
	private JButton btnPopupConfirm;
	private JButton btnPopupMsg;
	private JLabel lblPopup;
	private JButton btnFileOpen;
	private JButton btnFileSave;
	private JLabel lblImg;
	private JFileChooser chooser;
	private JButton btnColor;
	private JLabel lblColor;
	private JTabbedPane tabbedPane;
	private JLabel lblTab1;
	private StudentPanel pStudent;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OptionPanelEx frame = new OptionPanelEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public OptionPanelEx() {
		chooser = new JFileChooser(System.getProperty("user.dir"));
		
		initialize();
	}

	private void initialize() {
		setTitle("팝업다이얼로그, 파일다이얼로그, 컬러다이얼로그");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		pTop = new JPanel();
		contentPane.add(pTop, BorderLayout.NORTH);
		pTop.setLayout(new GridLayout(0, 3, 0, 0));

		pPopupDlg = new JPanel();
		pPopupDlg.setBorder(new TitledBorder(null, "\uD31D\uC5C5 \uB2E4\uC774\uC5BC\uB85C\uADF8", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pTop.add(pPopupDlg);
		pPopupDlg.setLayout(new GridLayout(0, 1, 0, 0));

		btnPopupInput = new JButton("입력 다이얼로그");
		pPopupDlg.add(btnPopupInput);

		btnPopupConfirm = new JButton("확인 다이얼로그");
		pPopupDlg.add(btnPopupConfirm);

		btnPopupMsg = new JButton("메시지 다이얼로그");
		pPopupDlg.add(btnPopupMsg);

		lblPopup = new JLabel("New label");
		lblPopup.setHorizontalAlignment(SwingConstants.CENTER);
		pPopupDlg.add(lblPopup);

		pFileDlg = new JPanel();
		pFileDlg.setBorder(
				new TitledBorder(null, "\uD30C\uC77C\uC5F4\uAE30/\uC800\uC7A5 \uB2E4\uC774\uC5B4\uB85C\uADF8",
						TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pTop.add(pFileDlg);
		pFileDlg.setLayout(new BoxLayout(pFileDlg, BoxLayout.Y_AXIS));

		btnFileOpen = new JButton("파일 열기");
		pFileDlg.add(btnFileOpen);

		btnFileSave = new JButton("파일 저장");
		pFileDlg.add(btnFileSave);

		lblImg = new JLabel("");
		pFileDlg.add(lblImg);

		pColorDlg = new JPanel();
		pColorDlg.setBorder(new TitledBorder(null, "\uCEEC\uB7EC \uB2E4\uC774\uC5BC\uB85C\uADF8", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pTop.add(pColorDlg);
		pColorDlg.setLayout(new BorderLayout(0, 0));
		
		btnColor = new JButton("색 선택");
		btnColor.addActionListener(this);
		pColorDlg.add(btnColor, BorderLayout.NORTH);
		
		lblColor = new JLabel("Hello");
		lblColor.setFont(new Font("HY헤드라인M", Font.BOLD | Font.ITALIC, 16));
		lblColor.setHorizontalAlignment(SwingConstants.CENTER);
		pColorDlg.add(lblColor, BorderLayout.CENTER);

		pCenter = new JPanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		pCenter.add(tabbedPane, BorderLayout.CENTER);
		
		lblTab1 = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\images\\apple.jpg"));
		tabbedPane.addTab("tab1", null, lblTab1, null);
		
		pStudent = new StudentPanel();
		tabbedPane.addTab("학생관리", null, pStudent, null);

		btnPopupInput.addActionListener(this);
		btnPopupConfirm.addActionListener(this);
		btnPopupMsg.addActionListener(this);
		btnFileOpen.addActionListener(this);
		btnFileSave.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnColor) {
			btnColorActionPerformed(e);
		}
		if (e.getSource() == btnFileSave) {
			btnFileSaveActionPerformed(e);
		}
		if (e.getSource() == btnFileOpen) {
			btnFileOpenActionPerformed(e);
		}
		if (e.getSource() == btnPopupConfirm) {
			btnPopupConfirmActionPerformed(e);
		}
		if (e.getSource() == btnPopupMsg) {
			btnPopupMsgActionPerformed(e);
		}
		if (e.getSource() == btnPopupInput) {
			btnPopupInputActionPerformed(e);
		}
	}

	protected void btnPopupInputActionPerformed(ActionEvent e) {
		/*
		 * parentComponent the parent Component for the dialog message the Object to
		 * display title the String to display in the dialog title bar messageType the
		 * type of message to be displayed: ERROR_MESSAGE, INFORMATION_MESSAGE,
		 * WARNING_MESSAGE, QUESTION_MESSAGE, or PLAIN_MESSAGE icon the Icon image to
		 * display selectionValues an array of Objects that gives the possible
		 * selections initialSelectionValue the value used to initialize the input field
		 * 
		 */
		String[] selectionValues = { "국어", "영어", "수학" };
		String res = (String) JOptionPane.showInputDialog(this, "과목을 선택하세요", "과목 선택", JOptionPane.QUESTION_MESSAGE,
				null, selectionValues, selectionValues[0]);
		if (res == null) {
			lblPopup.setText("선택없음");
			return;
		}
		lblPopup.setText(res);

	}

	protected void btnPopupConfirmActionPerformed(ActionEvent e) {
		int res = JOptionPane.showConfirmDialog(this, "잠오니 상원아?", "졸음체크", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.WARNING_MESSAGE);
		System.out.println(res);
		if (res == JOptionPane.YES_OPTION) {
			lblPopup.setText("확인");
		}
		if (res == JOptionPane.NO_OPTION) {
			lblPopup.setText("아니오");
		}
		if (res == JOptionPane.CANCEL_OPTION) {
			lblPopup.setText("취소");
		}
		if (res == JOptionPane.CLOSED_OPTION) {
			lblPopup.setText("창을 닫음");
		}
	}

	protected void btnPopupMsgActionPerformed(ActionEvent e) {
		ImageIcon icon = new ImageIcon(System.getProperty("user.dir") + "\\images\\icon1.png");
		JOptionPane.showMessageDialog(null, "열시미", "자바 프로젝트", JOptionPane.ERROR_MESSAGE, icon);
	}

	protected void btnFileOpenActionPerformed(ActionEvent e) {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF & PNG", "jpg", "gif", "png");
		chooser.setFileFilter(filter);
		int res = chooser.showOpenDialog(this);
		if(res != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(this, "파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		String filePath = chooser.getSelectedFile().getPath();
		lblImg.setIcon(new ImageIcon(filePath));
	}

	protected void btnFileSaveActionPerformed(ActionEvent e) {
		int res = chooser.showSaveDialog(this);
		if(res != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(this, "파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		String filePath = chooser.getSelectedFile().getPath();
		System.out.println(filePath);
	}
	
	protected void btnColorActionPerformed(ActionEvent e) {
		Color selectedColor = JColorChooser.showDialog(null, "Color", Color.YELLOW);
		if(selectedColor != null) {
			lblColor.setForeground(selectedColor);
		}
	}
}
