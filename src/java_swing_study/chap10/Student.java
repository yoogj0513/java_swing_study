package java_swing_study.chap10;

public class Student {
	private String name;
	private int stdNo;
	private String dept;
	private String subj;
	
	public Student(String name, int stdNo, String dept, String subj) {
		this.name = name;
		this.stdNo = stdNo;
		this.dept = dept;
		this.subj = subj;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStdNo() {
		return stdNo;
	}

	public void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getSubj() {
		return subj;
	}

	public void setSubj(String subj) {
		this.subj = subj;
	}

	@Override
	public String toString() {
		return String.format("Student [name=%s, stdNo=%s, dept=%s, subj=%s]", name, stdNo, dept, subj);
	}
}
