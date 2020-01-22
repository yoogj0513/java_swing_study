package java_swing_study.chap14.exam.ui;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java_swing_study.chap14.exam.ui.panel.StudentPanel;
import javax.swing.JButton;
import java_swing_study.chap14.exam.ui.panel.StudentTblPanel;

public class StudentMainPanel extends JPanel {
	private JPanel pStdInput;
	private JPanel pBtn;
	private StudentTblPanel pStdTbl;
	private StudentPanel pStd;
	private JButton btnAdd;
	private JButton btnCancel;

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
	}

}
