package com.studentApi.StudentApi.Api;

import com.studentApi.StudentApi.pojo.AcademicYearPojo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface StudentsGradesApi {

    @GetMapping("/getStudentsGrades")
    List<AcademicYearPojo> studentsGradesApi(@RequestParam (name="AcademicYear",required = false,defaultValue = "0")int academicYear,
                                             @RequestParam(name="Class",required = false,defaultValue = "0")int className,
                                             @RequestParam(name="Assessment",required = false,defaultValue = "0")String assessment);
;}
