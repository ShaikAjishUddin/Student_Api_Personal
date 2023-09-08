package com.studentApi.StudentApi.Api;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.studentApi.StudentApi.entity.FactStudententDetails;
import com.studentApi.StudentApi.pojo.FactStudentDetailsPojo;

@RestController
public interface FactStudentDetailsApi {
	
	@PostMapping("/studentDetails")
	public  List<FactStudententDetails> insertStudenDetailsApi(@RequestBody List<FactStudentDetailsPojo> detailsPojo );
	
	@GetMapping("/demo")
	public String demo();
	

}
