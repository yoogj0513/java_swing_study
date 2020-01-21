package java_swing_study.chap11.exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

public class StudentFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel pBtn;
	private StudentTblPanel pStdTb;
	private JButton btnAdd;
	private JButton btnCancel;
	private JPanel pStd;
	private StudentPanel pStudent;
	private ArrayList<Student> stds;
	private int selCol;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentFrame frame = new StudentFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StudentFrame() {
		initialize();
	}
	private void initialize() {
		setTitle("StudentFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		pStd = new JPanel();
		contentPane.add(pStd);
		pStd.setLayout(new BorderLayout(0, 0));
		
		pStudent = new StudentPanel();
		pStd.add(pStudent, BorderLayout.CENTER);
		pBtn = new JPanel();
		contentPane.add(pBtn);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtn.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtn.add(btnCancel);
		
		pStdTb = new StudentTblPanel();
		contentPane.add(pStdTb);
		
		stds = new ArrayList<Student>();
		stds.add(new Student(1, "서현진", 80, 90, 70));
		stds.add(new Student(2, "이성경", 90, 90, 40));
		stds.add(new Student(3, "이유영", 50, 50, 60));
		
		pStdTb.loadData(stds);
//		panel03.setLayout(new BorderLayout(0, 0));
		
		pStdTb.setPopupMenu(createPopupMenu());
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
					pStudent.setItem(pStdTb.getSelectedItem());
					selCol = pStdTb.getSelectedRowIdx();
					btnAdd.setText("수정");
				} catch (RuntimeException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
			if(e.getActionCommand().equals("삭제")) {
				try {					
					pStdTb.removeRow();
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
		Student item = pStudent.getItem();
		pStdTb.updateRow(item, selCol);
		stds.set(selCol, item);
		btnAdd.setText("추가");
		pStudent.clearTf();
	}

	protected void btnAddActionPerformed(ActionEvent e) {
		Student std = pStudent.getItem();
//		textArea.append(std.toString()+"\n");
		pStdTb.addItem(std);
		stds.add(std);
		
		pStudent.clearTf();
	}
	protected void btnCancelActionPerformed(ActionEvent e) {
		pStudent.clearTf();
	}
}
