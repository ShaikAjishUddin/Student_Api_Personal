package com.studentApi.StudentApi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentApi.StudentApi.entity.Subject;
@Repository
public interface SubjectRepository extends JpaRepository<Subject,Integer> {

	public List<Subject> findAllByActive(boolean active);
	
	public Subject findByIdAndActive(int id,boolean active);

    Subject findByNameAndActive(String subjectName, boolean active);
}
