package com.studentApi.StudentApi.Api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentApi.StudentApi.entity.Subject;

@RestController
public interface SubjectApi {

	
	@GetMapping("/getAllSubject")
	public List<Subject> getAllAssessmentApi(@RequestParam (name="Active",required = false,defaultValue = "true")boolean active);
	
	@GetMapping("/getBySubjectID")
	public Subject getByAssessmentidAndActive(@RequestParam(name="Id")int id,
			                               @RequestParam(name="Active",required = false,defaultValue = "true")boolean active);
	
	@PostMapping("insertSubject")
	public Subject insertAssessment(@RequestBody Subject subject);
	
	@PutMapping("/updateSubject")
	public Subject updateAssessment(@RequestBody Subject subject);
	
	@DeleteMapping("/deleteSubject")
	public Subject deleteAssessment(@RequestParam(name="Id")int id,
            @RequestParam(name="Active",required = false,defaultValue = "true")boolean active);
}
