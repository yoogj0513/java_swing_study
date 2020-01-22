package java_swing_study.chap14.exam.ui;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java_swing_study.chap14.exam.ui.panel.DepartmentPanel;
import java_swing_study.chap14.exam.ui.panel.DepartmentTblPanel;
import javax.swing.JButton;

public class DepartmentMainPanel extends JPanel {
	private JPanel pDeptInput;
	private JPanel pBtn;
	private DepartmentTblPanel pDeptTbl;
	private DepartmentPanel pDept;
	private JButton btnAdd;
	private JButton btnCancel;

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
//		pDeptTbl.setLayout(new BorderLayout(0, 0));
	}

}
