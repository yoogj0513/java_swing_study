package java_swing_study.chap14.exam.ui;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;

import java_swing_study.chap14.exam.dto.Student;
import java_swing_study.chap14.exam.ui.panel.StudentPanel;
import javax.swing.JButton;
import javax.swing.JMenuItem;

import java_swing_study.chap14.exam.ui.panel.StudentTblPanel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class StudentMainPanel extends JPanel implements ActionListener {
	private JPanel pStdInput;
	private JPanel pBtn;
	private StudentTblPanel pStdTbl;
	private StudentPanel pStd;
	private JButton btnAdd;
	private JButton btnCancel;
	private ArrayList<Student> stds;
	private int selRow;

	public StudentMainPanel() {

		initialize();
	}

	private void initialize() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		pStdInput = new JPanel();
		add(pStdInput);
		pStdInput.setLayout(new BorderLayout(0, 0));

		pStd = new StudentPanel();
		pStdInput.add(pStd, BorderLayout.CENTER);

		pBtn = new JPanel();
		add(pBtn);

		btnAdd = new JButton("추가");
		pBtn.add(btnAdd);

		btnCancel = new JButton("취소");
		pBtn.add(btnCancel);

		pStdTbl = new StudentTblPanel();
		add(pStdTbl);
//		pStdTbl.setLayout(new BorderLayout(0, 0));
		
		stds = new ArrayList<Student>();
		stds.add(new Student(1, "이성경", 90, 80, 70));
		pStdTbl.loadData(stds);

		pStdTbl.setPopupMenu(createPopupMenu());

		btnAdd.addActionListener(this);
		btnCancel.addActionListener(this);
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
			if(e.getActionCommand() == "수정") {
				Student item = pStdTbl.getSelectedItem();
				pStd.setItem(item);
				selRow = pStdTbl.getSelectedRowIdx();
				btnAdd.setText("수정");
			}
			if(e.getActionCommand() == "삭제") {
				
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
		Student item = pStd.getItem();
		pStdTbl.updateRow(item, selRow);
		stds.set(selRow, item);
		pStd.clearTf();
		btnAdd.setText("추가");
	}

	protected void btnAddActionPerformed(ActionEvent e) {
		Student item = pStd.getItem();
		pStdTbl.addItem(item);
		stds.add(item);
		pStd.clearTf();
	}

	protected void btnCancelActionPerformed(ActionEvent e) {
		pStd.clearTf();
		btnAdd.setText("추가");
	}
}
