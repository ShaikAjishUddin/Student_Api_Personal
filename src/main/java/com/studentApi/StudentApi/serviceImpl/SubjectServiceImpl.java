package com.studentApi.StudentApi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentApi.StudentApi.entity.Subject;
import com.studentApi.StudentApi.repository.SubjectRepository;
import com.studentApi.StudentApi.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService{

	@Autowired
	private SubjectRepository subjectRepo;

	@Override
	public List<Subject> getAllSubjectByActiveService(boolean active) {
		// TODO Auto-generated method stub
		return subjectRepo.findAllByActive(active);
	}

	@Override
	public Subject getBySubjectIdAndActiveService(int id, boolean active) {
		// TODO Auto-generated method stub
		return subjectRepo.findByIdAndActive(id, active);
	}

	@Override
	public Subject updateSubjectService(Subject subject) {
		// TODO Auto-generated method stub
		return subjectRepo.save(subject);
	}

	@Override
	public Subject insertSubjectService(Subject subject) {
		// TODO Auto-generated method stub
		return subjectRepo.save(subject);
	}

	@Override
	public Subject deleteSubjectService(int id, boolean active) {
		// TODO Auto-generated method stub
		Subject subject= subjectRepo.findByIdAndActive(id, active);
		subject.setActive(false);
		return subjectRepo.save(subject);
	}
}
