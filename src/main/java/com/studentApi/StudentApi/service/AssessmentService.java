package com.studentApi.StudentApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.studentApi.StudentApi.entity.Assessment;

@Service
public interface AssessmentService {

	public List<Assessment> getAllAssessmentByActiveService(boolean active);
	
	public Assessment getByAssessmentIdAndActiveService(int id,boolean active);
	
	public Assessment updateAssessmentService(Assessment assessment);
	
	public Assessment insertAssessmentService(Assessment assessment);
	
	public Assessment deleteAssessmentService(int id,boolean active);
}
