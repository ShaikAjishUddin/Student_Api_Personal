package com.studentApi.StudentApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentApi.StudentApi.entity.AcademicYear;

@Repository
public interface AcademicYearRepository extends JpaRepository<AcademicYear, Integer> {
	
	
	public List<AcademicYear> findAllByActive(boolean active);
	
	public AcademicYear findByIdAndActive(int id,boolean active);

	public List<AcademicYear> findAllByName(String valueOf);
	
	public AcademicYear findByNameAndActive(String name,boolean active);


}
