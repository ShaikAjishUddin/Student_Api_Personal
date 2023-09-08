package com.studentApi.StudentApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.studentApi.StudentApi.entity.Subject;

@Service
public interface SubjectService {

	
	public List<Subject> getAllSubjectByActiveService(boolean active);
	
	public Subject getBySubjectIdAndActiveService(int id,boolean active);
	
	public Subject updateSubjectService(Subject subject);
	
	public Subject insertSubjectService(Subject subject);

	Subject deleteSubjectService(int id,boolean active);
}
