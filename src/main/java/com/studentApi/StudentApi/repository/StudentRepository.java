package com.studentApi.StudentApi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentApi.StudentApi.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	
	public List<Student> findAllByActive(boolean active);
	
	public Student  findByIdAndActive(int id,boolean active);
	
	public Student findByName(String name);

	public Object findByStudentId(int studentId);
}
