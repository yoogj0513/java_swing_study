package java_swing_study.chap11;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import java_swing_study.chap11.exam.Student;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java_swing_study.chap11.exam.StudentPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StudentTableEx2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private StudentPanel pStudent;
	private JPanel pList;
	private JPanel pBtns;
	private JButton btnAdd;
	private JButton btnCancle;
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentTableEx2 frame = new StudentTableEx2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StudentTableEx2() {
		initialize();
	}

	private void initialize() {
		setTitle("학생리스트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 441, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pStudent = new StudentPanel();
		contentPane.add(pStudent, BorderLayout.NORTH);
		
		pList = new JPanel();
		contentPane.add(pList, BorderLayout.CENTER);
		pList.setLayout(new BorderLayout(0, 0));
		
		panel = new StudentTblPanel();
		pList.add(panel, BorderLayout.CENTER);
		
		pBtns = new JPanel();
		contentPane.add(pBtns, BorderLayout.SOUTH);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);
		
		btnCancle = new JButton("취소");
		btnCancle.addActionListener(this);
		pBtns.add(btnCancle);
		
		panel.setPopupMenu(createPopupMenu());
	}
	
//	public Student getStudent() {
//		return pStudent.getItem();
//	}
//	
//	public void setStudent(Student student) {
//		pStudent.setItem(student);
//	}
	
	private JPopupMenu createPopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();
		
		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(myPopMenuListenr);
		popMenu.add(updateItem);
		
		JMenuItem deleteItem = new JMenuItem("삭제");
		deleteItem.addActionListener(myPopMenuListenr);
		popMenu.add(deleteItem);
		
		JMenuItem getSelectItem = new JMenuItem("선택한 학생 확인");
		getSelectItem.addActionListener(myPopMenuListenr);
		popMenu.add(getSelectItem);
		
		return popMenu;
	}
	
	ActionListener myPopMenuListenr = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("수정")) {
				try {
					Student selItem = panel.getSelectedItem();
					pStudent.setItem(selItem);
					btnAdd.setText("수정");
				} catch (RuntimeException e1) {
					JOptionPane.showMessageDialog(null, "선택된 학생이 없습니다.");
				}
			}
			if(e.getActionCommand().equals("삭제")) {
				try {
					panel.removeRow();
				} catch (RuntimeException e1) {
					JOptionPane.showMessageDialog(null, "선택된 학생이 없습니다.");
				}
			}
			if(e.getActionCommand().equals("선택한 학생 확인")) {
				try {
					Student selectedStd = panel.getSelectedItem();
					JOptionPane.showMessageDialog(null, selectedStd);
				} catch (RuntimeException e1) {
					JOptionPane.showMessageDialog(null, "선택된 학생이 없습니다");
				}
			}
		}
	};
	
	private StudentTblPanel panel;
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancle) {
			btnCancleActionPerformed(e);
		}
		if (e.getSource() == btnAdd) {
			btnAddActionPerformed(e);
		}
	}
	
	protected void btnAddActionPerformed(ActionEvent e) {
		if(btnAdd.getText().equals("추가")) {			
			Student newStr = pStudent.getItem();
			panel.addItem(newStr);
			pStudent.clearTf();
		}
		
		if(btnAdd.getText().equals("수정")) {		
			Student newStr = pStudent.getItem();
			int idx = panel.getSelectedRowIdx();
			panel.updateRow(newStr, idx);
			btnAdd.setText("추가");
			pStudent.clearTf();
		}
	}
	
	protected void btnCancleActionPerformed(ActionEvent e) {
		pStudent.clearTf();
		btnAdd.setText("추가");
	}
}
