package java_swing_study.chap11.exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class DepartmentFrame extends JFrame {

	private JPanel contentPane;
	private JPanel pDept1;
	private JPanel pBtn;
	private DepartmentTbPanel pDeptTb;
	private DepartmentPanel pDept2;
	private JButton btnAdd;
	private JButton btnCancel;
	private ArrayList<Department> dept;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartmentFrame frame = new DepartmentFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DepartmentFrame() {
		initialize();
	}
	private void initialize() {
		setTitle("Department");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		pDept1 = new JPanel();
		contentPane.add(pDept1);
		pDept1.setLayout(new BorderLayout(0, 0));
		
		pDept2 = new DepartmentPanel();
		pDept1.add(pDept2);
		
		pBtn = new JPanel();
		contentPane.add(pBtn);
		
		btnAdd = new JButton("추가");
		pBtn.add(btnAdd);
		
		btnCancel = new JButton("취소");
		pBtn.add(btnCancel);
		
		pDeptTb = new DepartmentTbPanel();
		contentPane.add(pDeptTb);
		pDeptTb.setLayout(new BorderLayout(0, 0));
		
		dept = new ArrayList<Department>();
//		dept.add(new Department(deptNo, deptName, floor));
		pDeptTb.loadData(dept);
	}

}
