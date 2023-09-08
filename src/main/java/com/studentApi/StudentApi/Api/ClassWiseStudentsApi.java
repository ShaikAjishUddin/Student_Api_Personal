package com.studentApi.StudentApi.Api;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentApi.StudentApi.pojo.ClassWiseStudentsPojo;


@RestController
public interface ClassWiseStudentsApi {
	
	@GetMapping("/getClassWiseStudents")
	public List<ClassWiseStudentsPojo> classWiseStudentsApi(@RequestParam(name="AcademicYear", required = false,defaultValue = "0")Integer academicYear,
			                                                @RequestParam(name="ClassName",required = false,defaultValue = "0")Integer className);

}
