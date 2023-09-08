package com.studentApi.StudentApi.Controller;

import com.studentApi.StudentApi.Api.StudentsGradesApi;
import com.studentApi.StudentApi.pojo.AcademicYearPojo;
import com.studentApi.StudentApi.service.StudentsGradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class StudentsGradesController implements StudentsGradesApi {
    @Autowired
    private StudentsGradesService studentsGradesService;

    @Override
    public List<AcademicYearPojo> studentsGradesApi(int academicYear, int className, String assessment) {
        return studentsGradesService.studentsGradesService(academicYear, className,assessment);
    }
}
