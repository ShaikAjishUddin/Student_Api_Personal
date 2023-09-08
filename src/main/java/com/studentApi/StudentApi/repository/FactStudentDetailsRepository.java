package com.studentApi.StudentApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentApi.StudentApi.entity.FactStudententDetails;

@Repository
public interface FactStudentDetailsRepository extends JpaRepository<FactStudententDetails, Integer>{

	List<FactStudententDetails> findByAcademicYearId(int academicYear);
	List<FactStudententDetails> findAll();
	List<FactStudententDetails> findByAcademicYearIdAndClassId(int academicYear,int classId);
	List<FactStudententDetails> findByClassId(int classId);	
        List<FactStudententDetails> findByStudentId(int studentId);
        List<FactStudententDetails> findByAcademicYearIdAndClassIdAndStudentId(int academicYearId,int classId,int studentId);
		List<FactStudententDetails> findByStudentIdAndClassId(int studentId, int classId);
		List<FactStudententDetails> findByStudentIdAndClassIdAndAcademicYearId(int studentId, int classId, int academicYearId);
}
