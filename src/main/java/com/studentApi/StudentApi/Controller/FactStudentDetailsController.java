package com.studentApi.StudentApi.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.studentApi.StudentApi.Api.FactStudentDetailsApi;
import com.studentApi.StudentApi.entity.FactStudententDetails;
import com.studentApi.StudentApi.pojo.FactStudentDetailsPojo;
import com.studentApi.StudentApi.service.FactStudentDetailsService;
@RestController
public class FactStudentDetailsController implements FactStudentDetailsApi{
	
	@Autowired
	private FactStudentDetailsService detailsService;

	@Override
	public List<FactStudententDetails> insertStudenDetailsApi(List<FactStudentDetailsPojo> detailsPojo) {
		return detailsService.insertStudenDetailsService(detailsPojo);
	}

	@Override
	public String demo() {
		// TODO Auto-generated method stub
		return "done";
	}

}
