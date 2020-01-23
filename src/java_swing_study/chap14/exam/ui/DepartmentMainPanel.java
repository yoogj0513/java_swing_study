package java_swing_study.chap14.exam.ui;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.util.ArrayList;

import java_swing_study.chap14.exam.dto.Department;
import java_swing_study.chap14.exam.ui.panel.DepartmentPanel;
import java_swing_study.chap14.exam.ui.panel.DepartmentTblPanel;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class DepartmentMainPanel extends JPanel implements ActionListener {
	private JPanel pDeptInput;
	private JPanel pBtn;
	private DepartmentTblPanel pDeptTbl;
	private DepartmentPanel pDept;
	private JButton btnAdd;
	private JButton btnCancel;
	private ArrayList<Department> depts;
	private int selRow;

	public DepartmentMainPanel() {

		initialize();
	}

	private void initialize() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		pDeptInput = new JPanel();
		add(pDeptInput);
		pDeptInput.setLayout(new BorderLayout(0, 0));

		pDept = new DepartmentPanel();
		pDeptInput.add(pDept, BorderLayout.CENTER);

		pBtn = new JPanel();
		add(pBtn);

		btnAdd = new JButton("추가");
		pBtn.add(btnAdd);

		btnCancel = new JButton("취소");
		pBtn.add(btnCancel);

		pDeptTbl = new DepartmentTblPanel();
		add(pDeptTbl);

		depts = new ArrayList<Department>();
		depts.add(new Department(1, "개발", 9));
		pDeptTbl.loadData(depts);
//		pDeptTbl.setLayout(new BorderLayout(0, 0));

		btnAdd.addActionListener(this);
		btnCancel.addActionListener(this);
		pDeptTbl.setPopupMenu(createPopupMenu());
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
					Department item = pDeptTbl.getSelectedItem();
					pDept.setItem(item);
					selRow = pDeptTbl.getSelectedRowIdx();
					btnAdd.setText("수정");
				} catch (RuntimeException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
			if(e.getActionCommand().equals("삭제")) {
				try {					
					pDeptTbl.removeRow();
				} catch (RuntimeException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		}
	};

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			if(e.getActionCommand().equals("수정")) {
				btnUpdateActionPerformed(e);
			} else {				
				btnAddActionPerformed(e);
			}
		}
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
	}

	private void btnUpdateActionPerformed(ActionEvent e) {
		Department item = pDept.getItem();
		pDeptTbl.updateRow(item, selRow);
		depts.set(selRow, item);
		pDept.clearTf();
		btnAdd.setText("추가");
	}

	protected void btnCancelActionPerformed(ActionEvent e) {
		pDept.clearTf();
		btnAdd.setText("추가");
	}

	protected void btnAddActionPerformed(ActionEvent e) {
		try {			
			Department item = pDept.getItem();
			pDeptTbl.addItem(item);
			depts.add(item);
			pDept.clearTf();
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(this, "정보를 입력해주세요.");
		}
	}
}
