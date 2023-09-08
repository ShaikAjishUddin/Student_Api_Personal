package com.studentApi.StudentApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.studentApi.StudentApi.Api.ClassApi;
import com.studentApi.StudentApi.entity.ClassEntity;
import com.studentApi.StudentApi.service.ClassService;


@RestController
public class ClassController implements ClassApi {

	@Autowired
	private ClassService classService;

	@Override
	public List<ClassEntity> getAllAssessmentApi(boolean active) {
		// TODO Auto-generated method stub
		return classService.getAllClassByActiveService(active);
	}

	@Override
	public ClassEntity getByAssessmentidAndActive(int id, boolean active) {
		// TODO Auto-generated method stub
		return classService.getByClassIdAndActiveService(id, active);
	}

	@Override
	public ClassEntity insertAssessment(ClassEntity classs) {
		// TODO Auto-generated method stub
		return classService.insertClassService(classs);
	}

	@Override
	public ClassEntity updateAssessment(ClassEntity classs) {
		// TODO Auto-generated method stub
		return classService.updateClassService(classs);
	}

	@Override
	public ClassEntity deleteAssessment(int id, boolean active) {
		// TODO Auto-generated method stub
		return classService.deleteClassService(id, active);
	}
}
