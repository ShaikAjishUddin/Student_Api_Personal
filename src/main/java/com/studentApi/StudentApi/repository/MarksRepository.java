package com.studentApi.StudentApi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentApi.StudentApi.entity.Marks;
@Repository
public interface MarksRepository extends JpaRepository<Marks,Integer> {

	
	public List<Marks> findAllByActive(boolean active);
	
	public Marks findByIdAndActive(int id,boolean active);

}
