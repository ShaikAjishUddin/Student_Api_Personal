package com.studentApi.StudentApi.Api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentApi.StudentApi.entity.AcademicYear;


@RestController
public interface AcademicYearApi {

	@GetMapping("/getAllAcademicYear")
	public List<AcademicYear> getAllAcademicYearApi(@RequestParam (name="Active",required = false,defaultValue = "true")boolean active);
	
	@GetMapping("/getByAcademicYearID")
	public AcademicYear getByAcademicYearidAndActive(@RequestParam(name="Id")int id,
			                               @RequestParam(name="Active",required = false,defaultValue = "true")boolean active);
	
	@PostMapping("insertAcademicYear")
	public AcademicYear insertAcademicYear(@RequestBody AcademicYear academicYear);
	
	@PutMapping("/updateAcademicYear")
	public AcademicYear updateAcademicYear(@RequestBody AcademicYear academicYear);
	
	@DeleteMapping("/deleteAcademicYear")
	public AcademicYear deleteAcademicYear(@RequestParam(name="Id")int id,
            @RequestParam(name="Active",required = false,defaultValue = "true")boolean active);
}
