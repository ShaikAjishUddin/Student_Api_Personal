package com.studentApi.StudentApi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentApi.StudentApi.entity.ClassEntity;
@Repository
public interface ClassRepository extends JpaRepository<ClassEntity,Integer> {

	
	public List<ClassEntity> findAllByActive(boolean active);
	
	public ClassEntity findByIdAndActive(int id,boolean active);

	public ClassEntity findByName(String studentClass);
	
	public ClassEntity findByNameAndActive(String className,boolean active);

}
