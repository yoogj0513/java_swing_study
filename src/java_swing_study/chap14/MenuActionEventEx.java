package java_swing_study.chap14;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java_swing_study.chap11.exam.Student;
import java_swing_study.chap11.exam.StudentPanel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingConstants;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class MenuActionEventEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnScrren;
	private JMenuItem mntmLoad;
	private JMenuItem mntmHide;
	private JMenuItem mntmReShow;
	private JMenuItem mntmExit;
	private JLabel lblImg;
	private String imgDirPath = System.getProperty("user.dir") + "\\images\\";
	private JMenuItem mntmStudent;
	private JSeparator separator;
	private JToolBar toolBar;
	private JButton btnNew;
	private JButton btnImg;
	private JSeparator separator_1;
	private JButton btnModal;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuActionEventEx frame = new MenuActionEventEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MenuActionEventEx() {
		initialize();
	}

	private void initialize() {
		setTitle("Menu달기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnScrren = new JMenu("Screen");
		menuBar.add(mnScrren);

		mntmLoad = new JMenuItem("Load");
		mnScrren.add(mntmLoad);

		mntmHide = new JMenuItem("Hide");
		mnScrren.add(mntmHide);

		mntmReShow = new JMenuItem("ReShow");
		mnScrren.add(mntmReShow);
		
		mntmStudent = new JMenuItem("학생");
		mnScrren.add(mntmStudent);
		
		separator = new JSeparator();
		mnScrren.add(separator);

		mntmExit = new JMenuItem("Exit");
		mnScrren.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		lblImg = new JLabel("");
		contentPane.add(lblImg, BorderLayout.CENTER);

		mntmLoad.addActionListener(this);
		mntmHide.addActionListener(this);
		mntmReShow.addActionListener(this);
		mntmExit.addActionListener(this);
		
		mntmStudent.addActionListener(this);
		
		toolBar = new JToolBar();
		toolBar.setName("Kitae Menu");
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		btnNew = new JButton("학생정보 입력");
		btnNew.addActionListener(this);
		btnNew.setToolTipText("학생정보 대화상자");
		toolBar.add(btnNew);
		
		btnImg = new JButton("");
		btnImg.setIcon(new ImageIcon(imgDirPath + "open.jpg"));
		toolBar.add(btnImg);
		
//		separator_1 = new JSeparator();
//		separator_1.setMaximumSize(new Dimension(5, 32767));
//		separator_1.setOrientation(SwingConstants.VERTICAL);
		toolBar.addSeparator();;
		
		btnModal = new JButton("모달 대화상자");
		btnModal.addActionListener(this);
		toolBar.add(btnModal);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModal) {
			btnModalActionPerformed(e);
		}
		if (e.getSource() == btnNew) {
			btnNewActionPerformed(e);
		}
		if (e.getSource() == mntmStudent) {
			mntmStudentActionPerformed(e);
		}
		if (e.getSource() == mntmHide) {
			mntmHideActionPerformed(e);
		}
		if (e.getSource() == mntmReShow) {
			mntmReShowActionPerformed(e);
		}
		if (e.getSource() == mntmExit) {
			mntmExitActionPerformed(e);
		}
		if (e.getSource() == mntmLoad) {
			mntmLoadActionPerformed(e);
		}
	}

	protected void mntmLoadActionPerformed(ActionEvent e) {
//		JOptionPane.showMessageDialog(null, e.getActionCommand());
		if (lblImg.getIcon() != null) {
			return;
		}

		lblImg.setIcon(new ImageIcon(imgDirPath + "img.jpg"));
	}

	protected void mntmHideActionPerformed(ActionEvent e) {
		if (lblImg.isVisible()) {
			lblImg.setVisible(false);
		}
	}

	protected void mntmExitActionPerformed(ActionEvent e) {
		System.exit(0);// 정상종료
	}

	protected void mntmReShowActionPerformed(ActionEvent e) {
		if (!lblImg.isVisible()) {
			lblImg.setVisible(true);
		}
	}

	protected void mntmStudentActionPerformed(ActionEvent e) {
		StudentPanel sp = new StudentPanel();
		contentPane.add(sp, BorderLayout.SOUTH);
		revalidate();
		repaint();
	}
	protected void btnNewActionPerformed(ActionEvent e) {
		//다이얼로그 연결(생성)
		DialogEx dialog = new DialogEx();
		dialog.setParent(this);
		dialog.setStudent(new Student(1, "장", 90, 80, 70));
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}
	
	public void setStudentText(Student std) {
		lblImg.setText(std.toString());
	}
	protected void btnModalActionPerformed(ActionEvent e) {
		DialogEx dialog = new DialogEx();
		//모달 타입 선택
		dialog.setModal(true);
		
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
		// 다이얼로그 대화상자 닫히면 수행
		Student std = dialog.getInput();
		lblImg.setText(std.toString());
	}
}
