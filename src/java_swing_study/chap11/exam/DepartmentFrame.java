package java_swing_study.chap11.exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class DepartmentFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel pDept1;
	private JPanel pBtn;
	private DepartmentTbPanel pDeptTb;
	private DepartmentPanel pDept2;
	private JButton btnAdd;
	private JButton btnCancel;
	private ArrayList<Department> dept;
	private int rowIdx;

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
		btnAdd.addActionListener(this);
		pBtn.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtn.add(btnCancel);
		
		pDeptTb = new DepartmentTbPanel();
		contentPane.add(pDeptTb);
//		pDeptTb.setLayout(new BorderLayout(0, 0));
		
		dept = new ArrayList<Department>();
		dept.add(new Department(1, "영업", 8));
		dept.add(new Department(2, "기획", 10));
		dept.add(new Department(3, "개발", 9));
		dept.add(new Department(4, "총무", 7));
		pDeptTb.loadData(dept);
		
		pDeptTb.setPopupMenu(createPopupMenu());
	}

	private JPopupMenu createPopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();
		
		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(myPopMenuListener);
		popMenu.add(updateItem);
		
		JMenuItem deleteItem = new JMenuItem("삭제");
		deleteItem.addActionListener(myPopMenuListener);
		popMenu.add(deleteItem);
		
		return popMenu;
	}
	
	ActionListener myPopMenuListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("수정")) {
				try {
					pDept2.setItem(pDeptTb.getSelectedItem());
					rowIdx = pDeptTb.getSelectedRowIdx();
					btnAdd.setText("수정");
				} catch (RuntimeException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
			if(e.getActionCommand().equals("삭제")) {
				try {
					pDeptTb.removeRow();
				} catch (RuntimeException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		}
	};
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		if (e.getSource() == btnAdd) {
			if(e.getActionCommand().equals("수정")) {
				btnUpdateActionPerformed(e);
			} else {				
				btnAddActionPerformed(e);
			}
		}
	}
	private void btnUpdateActionPerformed(ActionEvent e) {
		Department getDept = pDept2.getItem();
		pDeptTb.updateRow(getDept, rowIdx);
		dept.add(getDept);
		btnAdd.setText("추가");
		pDept2.clearTf();
	}

	protected void btnAddActionPerformed(ActionEvent e) {
		Department getDept = pDept2.getItem();
		pDeptTb.addItem(getDept);
		dept.add(getDept);
		pDept2.clearTf();
	}
	protected void btnCancelActionPerformed(ActionEvent e) {
		pDept2.clearTf();
		btnAdd.setText("추가");
	}
}
