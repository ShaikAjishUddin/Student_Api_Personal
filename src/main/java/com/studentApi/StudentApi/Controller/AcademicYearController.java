package com.studentApi.StudentApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.studentApi.StudentApi.Api.AcademicYearApi;
import com.studentApi.StudentApi.entity.AcademicYear;
import com.studentApi.StudentApi.service.AcademicYearService;
@RestController
public class AcademicYearController implements AcademicYearApi{

	@Autowired
	private AcademicYearService academicYearService;

	@Override
	public List<AcademicYear> getAllAcademicYearApi(boolean active) {
		// TODO Auto-generated method stub
		return academicYearService.getAllAcademicYearByActiveService(active);
	}

	@Override
	public AcademicYear getByAcademicYearidAndActive(int id, boolean active) {
		// TODO Auto-generated method stub
		return academicYearService.getByAcademicYearIdAndActiveService(id, active);
	}

	@Override
	public AcademicYear insertAcademicYear(AcademicYear academicYear) {
		// TODO Auto-generated method stub
		return academicYearService.insertAcademicYearService(academicYear);
	}

	@Override
	public AcademicYear updateAcademicYear(AcademicYear academicYear) {
		// TODO Auto-generated method stub
		return academicYearService.updateAcademicYearService(academicYear);
	}

	@Override
	public AcademicYear deleteAcademicYear(int id, boolean active) {
		// TODO Auto-generated method stub
		return academicYearService.deleteAcademicYearService(id, active);
	}
}
