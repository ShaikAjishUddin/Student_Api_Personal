package com.studentApi.StudentApi.service;

import java.util.List;

import com.studentApi.StudentApi.pojo.MarksPojo;
import org.springframework.stereotype.Service;

import com.studentApi.StudentApi.entity.Marks;

@Service
public interface MarksService {

	
	public List<Marks> getAllMarksByActiveService(boolean active);
	
	public Marks getByMarksIdAndActiveService(int id,boolean active);
	
	public Marks updateMarksService(Marks marks);
	
	public Marks insertMarksService(Marks marks);
	
	public Marks deleteMarksService(int id,boolean active);
	List<MarksPojo> insertMarksPojo(List<MarksPojo> marksPojos);
}
