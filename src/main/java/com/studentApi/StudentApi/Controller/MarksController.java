package com.studentApi.StudentApi.Controller;

import java.util.List;

import com.studentApi.StudentApi.pojo.MarksPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.studentApi.StudentApi.Api.MarksApi;
import com.studentApi.StudentApi.entity.Marks;
import com.studentApi.StudentApi.service.MarksService;

@RestController
public class MarksController implements MarksApi{
	
	@Autowired
	private MarksService marksService;

	@Override
	public List<Marks> getAllAssessmentApi(boolean active) {
		// TODO Auto-generated method stub
		return marksService.getAllMarksByActiveService(active);
	}

	@Override
	public Marks getByAssessmentidAndActive(int id, boolean active) {
		// TODO Auto-generated method stub
		return marksService.getByMarksIdAndActiveService(id, active);
	}

	@Override
	public Marks insertAssessment(Marks marks) {
		// TODO Auto-generated method stub
		return marksService.insertMarksService(marks);
	}

	@Override
	public Marks updateAssessment(Marks marks) {
		// TODO Auto-generated method stub
		return marksService.updateMarksService(marks);
	}

	@Override
	public Marks deleteAssessment(int id, boolean active) {
		// TODO Auto-generated method stub
		return marksService.deleteMarksService(id, active);
	}

	@Override
	public List<MarksPojo> insertMarksPojo(List<MarksPojo> marksPojos) {
		return  marksService.insertMarksPojo(marksPojos);
	}

}
