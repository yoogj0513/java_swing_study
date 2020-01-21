package java_swing_study.chap11.exam;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class DepartmentPanel extends AbsItemPanel<Department> {
	private JLabel lblDeptno;
	private JTextField tfDeptno;
	private JLabel lblDeptName;
	private JTextField tfDeptName;
	private JLabel lblFloor;
	private JTextField tfFloor;

	public DepartmentPanel() {

		initialize();
	}
	private void initialize() {
		setBorder(new TitledBorder(null, "\uBD80\uC11C\uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 10, 10));
		
		lblDeptno = new JLabel("부서번호");
		lblDeptno.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblDeptno);
		
		tfDeptno = new JTextField();
		add(tfDeptno);
		tfDeptno.setColumns(10);
		
		lblDeptName = new JLabel("부서명");
		lblDeptName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblDeptName);
		
		tfDeptName = new JTextField();
		add(tfDeptName);
		tfDeptName.setColumns(10);
		
		lblFloor = new JLabel("부서위치");
		lblFloor.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblFloor);
		
		tfFloor = new JTextField();
		tfFloor.setColumns(10);
		add(tfFloor);
	}
	@Override
	public Department getItem() {
		int deptNo = Integer.parseInt(tfDeptno.getText());
		String deptName = tfDeptName.getText();
		int floor = Integer.parseInt(tfFloor.getText());
		return new Department(deptNo, deptName, floor);
	}
	@Override
	public void setItem(Department item) {
		tfDeptno.setText(item.getDeptNo()+"");
		tfDeptName.setText(item.getDeptName());
		tfFloor.setText(item.getFloor()+"");
	}
	@Override
	public void clearTf() {
		tfDeptno.setText("");
		tfDeptName.setText("");
		tfFloor.setText("");
	}

	

}
