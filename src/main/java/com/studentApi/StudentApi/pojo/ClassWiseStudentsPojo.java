package com.studentApi.StudentApi.pojo;

import java.util.List;
import java.util.Map;



public class ClassWiseStudentsPojo {
	

	public String getAcademicYear() {
		return academicYear;
	}
	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}
	public int getNoOfClasses() {
		return noOfClasses;
	}
	public void setNoOfClasses(int noOfClasses) {
		this.noOfClasses = noOfClasses;
	}
	public List<Map> getClasses() {
		return classes;
	}
	public void setClasses(List<Map> classes) {
		this.classes = classes;
	}
	private String academicYear;
	private int noOfClasses;
	private List<Map> classes;

	


	
	



}
