package java_swing_study.chap14.exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java_swing_study.chap14.exam.ui.DepartmentMainPanel;
import java_swing_study.chap14.exam.ui.StudentMainPanel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ERPFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnManagement;
	private JMenuItem mntmStd;
	private JMenuItem mntmDept;
	private DepartmentMainPanel dmp;
	private StudentMainPanel smp;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ERPFrame frame = new ERPFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ERPFrame() {
		initialize();
	}
	private void initialize() {
		setTitle("ERPFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnManagement = new JMenu("관리");
		menuBar.add(mnManagement);
		
		mntmStd = new JMenuItem("학생관리");
		mnManagement.add(mntmStd);
		
		mntmDept = new JMenuItem("부서관리");
		mnManagement.add(mntmDept);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//ActionListener들
		mntmStd.addActionListener(this);
		mntmDept.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmDept) {
			mntmDeptActionPerformed(e);
		}
		if (e.getSource() == mntmStd) {
			mntmStdActionPerformed(e);
		}
	}
	protected void mntmStdActionPerformed(ActionEvent e) {
		if(contentPane.getComponentCount() > 0) {
			contentPane.remove(dmp);
		}
		smp = new StudentMainPanel();
		contentPane.add(smp, BorderLayout.CENTER);
		revalidate();
		repaint();
	}
	protected void mntmDeptActionPerformed(ActionEvent e) {
		if(contentPane.getComponentCount() > 0) {
			contentPane.remove(smp);
		}
		dmp = new DepartmentMainPanel();
		contentPane.add(dmp, BorderLayout.CENTER);
		revalidate();
		repaint();
	}
}
