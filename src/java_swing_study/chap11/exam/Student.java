package java_swing_study.chap11.exam;

import javax.swing.JOptionPane;

public class Student{
	private int stdNo;
	private String stdName;
	private int kor;
	private int math;
	private int eng;

	public Student() {}

	public Student(int stdNo) {
		this.stdNo = stdNo;
	}

	public Student(int stdNo, String stdName, int kor, int math, int eng) {
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
	}

	public void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getStdNo() {
		return stdNo;
	}

	public String getStdName() {
		return stdName;
	}

	public int getKor() {
		return kor;
	}

	public int getMath() {
		return math;
	}

	public int getEng() {
		return eng;
	}

	public int total() {
		return kor + math + eng;
	}

	public double avg() {
		return total() / 3.0;
	}

	@Override
	public String toString() {
		return String.format("학생번호:%2d / 학생이름:%s / 국어:%3d / 수학:%3d / 영어:%3d / 총점:%3d / 평균:%.2f", stdNo, stdName, kor, math, eng, total(), avg());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + stdNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		
		Student other = (Student) obj;
		if (stdNo != other.stdNo)
			return false;
		return true;
	}

	
	
}