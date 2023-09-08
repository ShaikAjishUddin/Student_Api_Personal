package com.studentApi.StudentApi.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.studentApi.StudentApi.entity.FactStudententDetails;
import com.studentApi.StudentApi.pojo.FactStudentDetailsPojo;

@Service
public interface FactStudentDetailsService {

	public List<FactStudententDetails> insertStudenDetailsService(List<FactStudentDetailsPojo> detailsPojo);
	
}
