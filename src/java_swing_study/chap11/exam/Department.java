package java_swing_study.chap11.exam;

public class Department {
	private int deptNo;
	private String deptName;
	private int floor;

	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(int deptNo) {
		super();
		this.deptNo = deptNo;
	}

	public Department(int deptNo, String deptName, int floor) {
		super();
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.floor = floor;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	@Override
	public String toString() {
		return String.format("Department [deptNo=%s, deptName=%s, floor=%s]", deptNo, deptName, floor);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deptNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (deptNo != other.deptNo)
			return false;
		return true;
	}

}
