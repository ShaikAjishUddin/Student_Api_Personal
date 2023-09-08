package com.studentApi.StudentApi.Api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentApi.StudentApi.entity.Assessment;


@RestController
public interface AssessmentApi {

	@GetMapping("/getAllAssessment")
	public List<Assessment> getAllAssessmentApi(@RequestParam (name="Active",required = false,defaultValue = "true")boolean active);
	
	@GetMapping("/getByAssessmentID")
	public Assessment getByAssessmentidAndActive(@RequestParam(name="Id")int id,
			                               @RequestParam(name="Active",required = false,defaultValue = "true")boolean active);
	
	@PostMapping("insertAssessment")
	public Assessment insertAssessment(@RequestBody Assessment assessment);
	
	@PutMapping("/updateAssessment")
	public Assessment updateAssessment(@RequestBody Assessment assessment);
	
	@DeleteMapping("/deleteAssessment")
	public Assessment deleteAssessment(@RequestParam(name="Id")int id,
            @RequestParam(name="Active",required = false,defaultValue = "true")boolean active);
}
