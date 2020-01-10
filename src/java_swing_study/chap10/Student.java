package java_swing_study.chap10;

import javax.swing.JTextField;

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

	public int getStdNo() {
		return stdNo;
	}

	public String getDept() {
		return dept;
	}

	public String getSubj() {
		return subj;
	}
	
	@Override
	public String toString() {
		return String.format("학생정보 %n 이름 : %s%n 학번 : %s%n 학과 : %s%n 과목 : %s", name, stdNo, dept, subj);
	}

}
