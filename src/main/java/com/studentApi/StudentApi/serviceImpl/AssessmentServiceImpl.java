package com.studentApi.StudentApi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentApi.StudentApi.entity.Assessment;
import com.studentApi.StudentApi.repository.AssessmentRepository;
import com.studentApi.StudentApi.service.AssessmentService;


@Service
public class AssessmentServiceImpl implements AssessmentService{

	
	@Autowired
	private AssessmentRepository assessmentRepository;
	@Override
	public List<Assessment> getAllAssessmentByActiveService(boolean active) {
		// TODO Auto-generated method stub
		return assessmentRepository.findAllByActive(active);
	}

	@Override
	public Assessment getByAssessmentIdAndActiveService(int id, boolean active) {
		// TODO Auto-generated method stub
		return assessmentRepository.findByIdAndActive(id, active);
	}

	@Override
	public Assessment updateAssessmentService(Assessment assessment) {
		// TODO Auto-generated method stub
		return assessmentRepository.save(assessment);
	}

	@Override
	public Assessment insertAssessmentService(Assessment assessment) {
		// TODO Auto-generated method stub
		return assessmentRepository.save(assessment);
	}

	@Override
	public Assessment deleteAssessmentService(int id, boolean active) {
		// TODO Auto-generated method stub
		Assessment assessment= assessmentRepository.findByIdAndActive(id, active);
		assessment.setActive(false);
		return assessmentRepository.save(assessment);
	}

}
