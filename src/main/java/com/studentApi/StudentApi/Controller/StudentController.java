package com.studentApi.StudentApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.studentApi.StudentApi.Api.StudentApi;
import com.studentApi.StudentApi.entity.Student;
import com.studentApi.StudentApi.pojo.StudentDetailsPojo;
import com.studentApi.StudentApi.service.StudentService;

@RestController
public class StudentController implements StudentApi{

	@Autowired
	private StudentService studentService;
	
	@Override
	public List<Student> getAllStudentsApi(boolean active) {
		// TODO Auto-generated method stub
		return studentService.getAllStudentByActiveService(active);
	}

	@Override
	public Student getByStudentidAndActive(int id, boolean active) {
		// TODO Auto-generated method stub
		return studentService.getStudentByIdAndActiveService(id, active);
	}

	@Override
	public Student insertStudent(Student student) {
		// TODO Auto-generated method stub
		return studentService.insertStudentService(student);
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentService.updateStudentService(student);
	}

	@Override
	public Student deleteStudent(int id,boolean active) {
		// TODO Auto-generated method stub
		return studentService.deleteStudentService(id,active);
	}

	@Override
	public StudentDetailsPojo studentDetailsByActive(boolean active) {
		// TODO Auto-generated method stub
		return null;
	}

}
