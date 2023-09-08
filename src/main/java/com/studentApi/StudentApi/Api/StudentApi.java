package com.studentApi.StudentApi.Api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentApi.StudentApi.entity.Student;
import com.studentApi.StudentApi.pojo.StudentDetailsPojo;

@RestController
public interface StudentApi {
	
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudentsApi(@RequestParam (name="Active",required = false,defaultValue = "true")boolean active);
	
	@GetMapping("/getByStudentID")
	public Student getByStudentidAndActive(@RequestParam(name="Id")int id,
			                               @RequestParam(name="Active",required = false,defaultValue = "true")boolean active);
	
	@GetMapping("/StudentDetails")
	public StudentDetailsPojo studentDetailsByActive(@RequestParam(name="Active",required = false,defaultValue = "true")boolean active);
	
	@PostMapping("insertStudent")
	public Student insertStudent(@RequestBody Student student);
	
	@PutMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student student);
	
	@DeleteMapping("/deleteStudent")
	public Student deleteStudent(@RequestParam(name="Id")int id,
			                     @RequestParam(name="Active",required = false,defaultValue = "true")boolean active);
	

}
