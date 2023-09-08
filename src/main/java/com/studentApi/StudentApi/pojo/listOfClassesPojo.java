package com.studentApi.StudentApi.pojo;

import java.util.List;

import com.studentApi.StudentApi.entity.Student;

public class listOfClassesPojo {
public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
private String className;
private List<Student> students;
}
