package com.studentApi.StudentApi.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentApi.StudentApi.entity.Student;
import com.studentApi.StudentApi.pojo.StudentDetailsPojo;
import com.studentApi.StudentApi.repository.AcademicYearRepository;
import com.studentApi.StudentApi.repository.ClassRepository;
import com.studentApi.StudentApi.repository.StudentRepository;
import com.studentApi.StudentApi.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
	private AcademicYearRepository academicYearRepository;
	
	@Override
	public List<Student> getAllStudentByActiveService(boolean active) {
		// TODO Auto-generated method stub
		return studentRepository.findAllByActive(active);
	}



	@Override
	public Student getStudentByIdAndActiveService(int id, boolean active) {
		// TODO Auto-generated method stub
		return studentRepository.findByIdAndActive( id,active);
	}



	@Override
	public Student updateStudentService(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}



	@Override
	public Student insertStudentService(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}



	@Override
	public Student deleteStudentService(int id,boolean active) {
		// TODO Auto-generated method stub
		
		Student student=studentRepository.findByIdAndActive(id,active);
		student.setActive(false);
		return studentRepository.save(student);
	}



	@Override
	public StudentDetailsPojo studentDetailsByActive(boolean active) {
		// TODO Auto-generated method stub
		List<StudentDetailsPojo> studentPojo= new ArrayList<StudentDetailsPojo>();
		
		List<Student> Students=studentRepository.findAll();
		
		for (Student student : Students) {
			StudentDetailsPojo pojo =new StudentDetailsPojo();
			pojo.setStudentId(student.getId());
			pojo.setStudentName(student.getName());
			pojo.setClasss(classRepository.findByIdAndActive(student.getId(), active).getName());
			pojo.setAcademicYear(academicYearRepository.findByIdAndActive(student.getId(), active).getName());
			studentPojo.add(pojo);
		}
		return (StudentDetailsPojo) studentPojo;
	}

}
