package com.studentApi.StudentApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.studentApi.StudentApi.Api.SubjectApi;
import com.studentApi.StudentApi.entity.Subject;
import com.studentApi.StudentApi.service.SubjectService;

@RestController
public class SubjectController implements SubjectApi {
	
	@Autowired
	private SubjectService service;

	@Override
	public List<Subject> getAllAssessmentApi(boolean active) {
		// TODO Auto-generated method stub
		return service.getAllSubjectByActiveService(active);
	}

	@Override
	public Subject getByAssessmentidAndActive(int id, boolean active) {
		// TODO Auto-generated method stub
		return service.getBySubjectIdAndActiveService(id, active);
	}

	@Override
	public Subject insertAssessment(Subject subject) {
		// TODO Auto-generated method stub
		return service.insertSubjectService(subject);
	}

	@Override
	public Subject updateAssessment(Subject subject) {
		// TODO Auto-generated method stub
		return service.updateSubjectService(subject);
	}

	@Override
	public Subject deleteAssessment(int id,boolean active) {
		// TODO Auto-generated method stub
		return service.deleteSubjectService(id, active);
	}

}
