package com.studentApi.StudentApi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentApi.StudentApi.entity.ClassEntity;
import com.studentApi.StudentApi.repository.ClassRepository;
import com.studentApi.StudentApi.service.ClassService;


@Service
public class ClassServiceImpl implements ClassService {

	@Autowired
	private ClassRepository classRepo;

	@Override
	public List<ClassEntity> getAllClassByActiveService(boolean active) {
		// TODO Auto-generated method stub
		return classRepo.findAllByActive(active);
	}

	@Override
	public ClassEntity getByClassIdAndActiveService(int id, boolean active) {
		// TODO Auto-generated method stub
		return classRepo.findByIdAndActive(id, active);
	}

	@Override
	public ClassEntity updateClassService(ClassEntity classEntity) {
		// TODO Auto-generated method stub
		return classRepo.save(classEntity);
	}

	@Override
	public ClassEntity insertClassService(ClassEntity classEntity) {
		// TODO Auto-generated method stub
		return classRepo.save(classEntity);
	}

	@Override
	public ClassEntity deleteClassService(int id, boolean active) {
		// TODO Auto-generated method stub
		ClassEntity classEntity= classRepo.findByIdAndActive(id, active);
		classEntity.setActive(false);
		return classRepo.save(classEntity);
	}
}
