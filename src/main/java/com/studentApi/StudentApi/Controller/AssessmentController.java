package com.studentApi.StudentApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.studentApi.StudentApi.Api.AssessmentApi;
import com.studentApi.StudentApi.entity.Assessment;
import com.studentApi.StudentApi.service.AssessmentService;


@RestController
public class AssessmentController implements AssessmentApi {
	
	@Autowired
	private AssessmentService assessmentService;

	@Override
	public List<Assessment> getAllAssessmentApi(boolean active) {
		// TODO Auto-generated method stub
		return assessmentService.getAllAssessmentByActiveService(active);
	}

	@Override
	public Assessment getByAssessmentidAndActive(int id, boolean active) {
		// TODO Auto-generated method stub
		return assessmentService.getByAssessmentIdAndActiveService(id, active);
	}

	@Override
	public Assessment insertAssessment(Assessment assessment) {
		// TODO Auto-generated method stub
		return assessmentService.insertAssessmentService(assessment);
	}

	@Override
	public Assessment updateAssessment(Assessment assessment) {
		// TODO Auto-generated method stub
		return assessmentService.updateAssessmentService(assessment);
	}

	@Override
	public Assessment deleteAssessment(int id, boolean active) {
		// TODO Auto-generated method stub
		return assessmentService.deleteAssessmentService(id, active);
	}

}
