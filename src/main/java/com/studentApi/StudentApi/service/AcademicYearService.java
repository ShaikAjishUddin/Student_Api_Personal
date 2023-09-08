package com.studentApi.StudentApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.studentApi.StudentApi.entity.AcademicYear;
@Service
public interface AcademicYearService {

	
	public List<AcademicYear> getAllAcademicYearByActiveService(boolean active);
	
	public AcademicYear getByAcademicYearIdAndActiveService(int id,boolean active);
	
	public AcademicYear updateAcademicYearService(AcademicYear academicYear);
	
	public AcademicYear insertAcademicYearService(AcademicYear academicYear);
	
	public AcademicYear deleteAcademicYearService(int id,boolean active);
}
