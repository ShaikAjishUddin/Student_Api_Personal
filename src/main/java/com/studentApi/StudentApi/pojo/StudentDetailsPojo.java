package com.studentApi.StudentApi.pojo;

public class StudentDetailsPojo {
	
	private String academicYear;
	private String classs;
	private String studentName;
	private int studentId;
	
	public String getAcademicYear() {
		return academicYear;
	}
	public String setAcademicYear(String string) {
		return this.academicYear = string;
	}
	public String getClasss() {
		return classs;
	}
	public void setClasss(String classs) {
		this.classs = classs;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


}
