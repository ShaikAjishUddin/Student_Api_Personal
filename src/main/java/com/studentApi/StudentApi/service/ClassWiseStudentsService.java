package com.studentApi.StudentApi.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.studentApi.StudentApi.pojo.ClassWiseStudentsPojo;

@Service
public interface ClassWiseStudentsService {
List<ClassWiseStudentsPojo> getClassWiseStudentsService(Integer academicYear, Integer className);
}
