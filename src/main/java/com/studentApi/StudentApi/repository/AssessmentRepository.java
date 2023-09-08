package com.studentApi.StudentApi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.studentApi.StudentApi.entity.Assessment;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment,Integer> {

	
	public List<Assessment> findAllByActive(boolean active);
	
	public Assessment findByIdAndActive(int id,boolean active);

    Assessment findByNameAndActive(String assessmentName, boolean active);
}
