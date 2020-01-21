package java_swing_study.chap11.exam;

import javax.swing.SwingConstants;

public class DepartmentTbPanel extends AbstractTblPanel<Department> {

	public DepartmentTbPanel() {

	}

	@Override
	protected void setTblWidthAlign() {
		tableSetWidth(50, 150, 50);
		tableCellAlign(SwingConstants.CENTER, 0, 1, 2);
	}

	@Override
	protected String[] getColNames() {
		return new String [] {"부서번호", "부서명", "부서위치"};
	}

	@Override
	protected Object[] toArray(Department item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateRow(Department time, int updateIdx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department getSelectedItem() {
		// TODO Auto-generated method stub
		return null;
	}

}
