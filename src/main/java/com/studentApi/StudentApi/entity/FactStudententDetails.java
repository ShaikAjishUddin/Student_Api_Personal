package com.studentApi.StudentApi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="FactStudentenDetails")
public class FactStudententDetails extends BaseEntity {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="Id")
	private int id;
	
	@Column(name="AcademicYearId")
	private int academicYearId;
	
	@Column(name="ClassId")
	private int classId;
	
	@Column(name="StudentId")
	private int studentId;
	
	@Column(name="RollNo")
	private int rollNo;

//	Getters & Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAcademicYearId() {
		return academicYearId;
	}

	public void setAcademicYearId(int academicYearID) {
		this.academicYearId = academicYearID;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}


}
