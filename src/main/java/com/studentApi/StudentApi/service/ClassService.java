package com.studentApi.StudentApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.studentApi.StudentApi.entity.ClassEntity;


@Service
public interface ClassService {

	
	public List<ClassEntity> getAllClassByActiveService(boolean active);
	
	public ClassEntity getByClassIdAndActiveService(int id,boolean active);
	
	public ClassEntity updateClassService(ClassEntity classEntity);
	
	public ClassEntity insertClassService(ClassEntity classEntity);
	
	public ClassEntity deleteClassService(int id,boolean active);
}
