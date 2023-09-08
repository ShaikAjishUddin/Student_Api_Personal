package com.studentApi.StudentApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.studentApi.StudentApi.entity.Student;
import com.studentApi.StudentApi.pojo.StudentDetailsPojo;

@Service
public interface StudentService {
	
	public List<Student> getAllStudentByActiveService(boolean active);
	
	public Student getStudentByIdAndActiveService(int id,boolean active);
	
	public Student updateStudentService(Student student);
	
	public Student insertStudentService(Student student);
	
	public Student deleteStudentService(int id,boolean active);
	
	public StudentDetailsPojo studentDetailsByActive(boolean active);
	
	

}
