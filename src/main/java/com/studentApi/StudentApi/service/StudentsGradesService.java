package com.studentApi.StudentApi.service;

import com.studentApi.StudentApi.pojo.AcademicYearPojo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentsGradesService {
    List<AcademicYearPojo> studentsGradesService(int academicYear,int className,String assessment);
}
