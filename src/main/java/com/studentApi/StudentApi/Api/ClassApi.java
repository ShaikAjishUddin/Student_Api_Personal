package com.studentApi.StudentApi.Api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentApi.StudentApi.entity.ClassEntity;


@RestController
public interface ClassApi {

	@GetMapping("/getAllClass")
	public List<ClassEntity> getAllAssessmentApi(@RequestParam (name="Active",required = false,defaultValue = "true")boolean active);
	
	@GetMapping("/getByClassID")
	public ClassEntity getByAssessmentidAndActive(@RequestParam(name="Id")int id,
			                               @RequestParam(name="Active",required = false,defaultValue = "true")boolean active);
	
	@PostMapping("insertClass")
	public ClassEntity insertAssessment(@RequestBody ClassEntity classs);
	
	@PutMapping("/updateClass")
	public ClassEntity updateAssessment(@RequestBody ClassEntity classs);
	
	@DeleteMapping("/deleteClass")
	public ClassEntity deleteAssessment(@RequestParam(name="Id")int id,
            @RequestParam(name="Active",required = false,defaultValue = "true")boolean active);
}
