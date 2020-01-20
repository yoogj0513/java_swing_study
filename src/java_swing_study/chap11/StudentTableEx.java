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

public class StudentTableEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private StudentPanel pStudent;
	private JPanel pList;
	private JPanel pBtns;
	private JScrollPane scrollPane;
	private JButton btnAdd;
	private JButton btnCancle;
	
	private ArrayList<Student> std;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentTableEx frame = new StudentTableEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StudentTableEx() {
		loadListDate();
		initialize();
	}
	private void loadListDate() {
		std = new ArrayList<Student>();
		std.add(new Student(1, "서현진", 80, 90, 70));
		std.add(new Student(2, "이성경", 90, 90, 40));
		std.add(new Student(3, "이유영", 50, 50, 60));
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
		
		scrollPane = new JScrollPane();
		pList.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		
		scrollPane.setViewportView(table);
		
		pBtns = new JPanel();
		contentPane.add(pBtns, BorderLayout.SOUTH);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);
		
		btnCancle = new JButton("취소");
		btnCancle.addActionListener(this);
		pBtns.add(btnCancle);
		
		loadData();
	}

	private void loadData() {
		table.setModel(new DefaultTableModel(getRows(), getColumnNames())); //(데이터, 컬럼이름)
	}

	private Object[][] getRows() {
		Object[][] rows = new Object[std.size()][];
		for(int i=0; i<rows.length; i++) {
			rows[i] = toArray(std.get(i));
		}
		return rows;
	}

	private Object[] toArray(Student std) {
		return new Object[] {std.getStdNo(), std.getStdName(), std.getKor(), std.getEng(), std.getMath(), std.total(), std.avg()};
	}

	private String[] getColumnNames() {
		return new String[] {"학생번호", "학생명", "국어", "영어", "수학", "총점", "평균"};
	}
	
	public Student getStudent() {
		return pStudent.getItem();
	}
	
	public void setStudent(Student student) {
		pStudent.setItem(student);
	}
	
	private JPopupMenu createPopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();
		
		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(myPopMenuListenr);
		popMenu.add(updateItem);
		
		JMenuItem deleteItem = new JMenuItem("삭제");
		deleteItem.addActionListener(myPopMenuListenr);
		popMenu.add(deleteItem);
		
		return popMenu;
	}
	
	ActionListener myPopMenuListenr = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("수정")) {
//				try {
//					int selIdx = list.getSelectedIndex();
//					pStudent.setItem(std.get(selIdx));
//					btnAdd.setText("수정");
//				} catch (ArrayIndexOutOfBoundsException e1) {
//					JOptionPane.showMessageDialog(null, "선택된 학생이 없습니다.");
//				}
				
			}
			if(e.getActionCommand().equals("삭제")) {
				//list에서 선택된 것이 있는지 판단
				//선택된 index 또는 value를 가져온 후
				//arraylist에 일치하는 삭제
				//jlist에서 setListDate()호출해서 변경된 arraylist를 보여주도록 함.
//				try {
//					int selIdx = list.getSelectedIndex();
//					std.remove(selIdx);
//					list.setListData(new Vector<Student>(std));
//				} catch (ArrayIndexOutOfBoundsException e1) {
//					JOptionPane.showMessageDialog(null, "선택된 학생이 없습니다.");
//				}
				
			}
		}
	};
	private JTable table;
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancle) {
			btnCancleActionPerformed(e);
		}
		if (e.getSource() == btnAdd) {
			btnAddActionPerformed(e);
		}
	}
	protected void btnAddActionPerformed(ActionEvent e) {
//		try {
//			if(btnAdd.getText().equals("추가")) {			
//				Student newStr = pStudent.getItem();
//				std.add(newStr);
//				list.setListData(new Vector<Student>(std));
//				pStudent.clearTf();
//			}
//			
//			if(btnAdd.getText().equals("수정")) {		
//				int selIdx = list.getSelectedIndex();
//				Student newStr = pStudent.getItem();
//				std.remove(selIdx);
//				std.add(selIdx, newStr);
//				list.setListData(new Vector<Student>(std));
//				btnAdd.setText("추가");
//				pStudent.clearTf();
//			}
//			
//		} catch (NumberFormatException e1) {
//			JOptionPane.showMessageDialog(null, "정보를 입력해주세요.");
//		}
		
		
	}
	protected void btnCancleActionPerformed(ActionEvent e) {
		pStudent.clearTf();
		btnAdd.setText("추가");
	}
}
