package com.studentApi.StudentApi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentApi.StudentApi.entity.AcademicYear;
import com.studentApi.StudentApi.repository.AcademicYearRepository;
import com.studentApi.StudentApi.service.AcademicYearService;


@Service
public class AcademicYearServiceImpl implements AcademicYearService {
	
	@Autowired
	private AcademicYearRepository academicYearRepository;

	@Override
	public List<AcademicYear> getAllAcademicYearByActiveService(boolean active) {
		// TODO Auto-generated method stub
		return academicYearRepository.findAllByActive(active);
	}

	@Override
	public AcademicYear getByAcademicYearIdAndActiveService(int id, boolean active) {
		// TODO Auto-generated method stub
		return academicYearRepository.findByIdAndActive(id, active);
	}

	@Override
	public AcademicYear updateAcademicYearService(AcademicYear academicYear) {
		// TODO Auto-generated method stub
		return academicYearRepository.save(academicYear);
	}

	@Override
	public AcademicYear insertAcademicYearService(AcademicYear academicYear) {
		// TODO Auto-generated method stub
		return academicYearRepository.save(academicYear);
	}

	@Override
	public AcademicYear deleteAcademicYearService(int id, boolean active) {
		// TODO Auto-generated method stub
		
		AcademicYear academicYear= academicYearRepository.findByIdAndActive(id, active);
		academicYear.setActive(false);
		return academicYearRepository.save(academicYear);
	}

}
