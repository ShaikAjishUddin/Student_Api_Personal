package com.studentApi.StudentApi.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.studentApi.StudentApi.Api.ClassWiseStudentsApi;
import com.studentApi.StudentApi.pojo.ClassWiseStudentsPojo;
import com.studentApi.StudentApi.service.ClassWiseStudentsService;

@RestController
public class ClassWiseStudentsController implements ClassWiseStudentsApi{

	@Autowired
	private ClassWiseStudentsService StudentsServices;
	
	@Override
	public List<ClassWiseStudentsPojo> classWiseStudentsApi(Integer academicYear, Integer   className) {
		// TODO Auto-generated method stub
		return   StudentsServices.getClassWiseStudentsService(academicYear, className);
	}

}
