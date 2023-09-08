package com.studentApi.StudentApi.Api;

import java.util.List;

import com.studentApi.StudentApi.pojo.MarksPojo;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentApi.StudentApi.entity.Marks;

@RestController
public interface MarksApi {

	@GetMapping("/getAllMarks")
	public List<Marks> getAllAssessmentApi(@RequestParam (name="Active",required = false,defaultValue = "true")boolean active);
	
	@GetMapping("/getByMarksID")
	public Marks getByAssessmentidAndActive(@RequestParam(name="Id")int id,
			                               @RequestParam(name="Active",required = false,defaultValue = "true")boolean active);
	
	@PostMapping("insertMarks")
	public Marks insertAssessment(@RequestBody Marks marks);
	
	@PutMapping("/updateMarks")
	public Marks updateAssessment(@RequestBody Marks marks);
	
	@DeleteMapping("/deleteMarks")
	public Marks deleteAssessment(@RequestParam(name="Id")int id,
            @RequestParam(name="Active",required = false,defaultValue = "true")boolean active);

	@PostMapping("/marks")
	public List<MarksPojo> insertMarksPojo (@RequestBody List<MarksPojo> marksPojos);
}
