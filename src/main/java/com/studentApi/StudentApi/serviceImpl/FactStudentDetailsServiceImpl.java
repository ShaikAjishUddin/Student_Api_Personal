package com.studentApi.StudentApi.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.studentApi.StudentApi.entity.AcademicYear;
import com.studentApi.StudentApi.entity.ClassEntity;
import com.studentApi.StudentApi.entity.FactStudententDetails;
import com.studentApi.StudentApi.entity.Student;
import com.studentApi.StudentApi.pojo.FactStudentDetailsPojo;
import com.studentApi.StudentApi.repository.AcademicYearRepository;
import com.studentApi.StudentApi.repository.ClassRepository;
import com.studentApi.StudentApi.repository.FactStudentDetailsRepository;
import com.studentApi.StudentApi.repository.StudentRepository;
import com.studentApi.StudentApi.service.FactStudentDetailsService;

@Service
public class FactStudentDetailsServiceImpl implements FactStudentDetailsService{
	
	@Autowired
	private AcademicYearRepository academicYearRepository;
	
	@Autowired
	private ClassRepository classRepository;

	@Autowired
	private FactStudentDetailsRepository detailsRepository;
	
	@Autowired
	private StudentRepository studentRepository;



	@Override
	public List<FactStudententDetails> insertStudenDetailsService(List<FactStudentDetailsPojo> detailsPojos) {
		
		List<FactStudententDetails> f= new ArrayList<FactStudententDetails>();
		int idCounter=1;
		
		for(FactStudentDetailsPojo detailsPojo1: detailsPojos) {
			FactStudententDetails fact= new FactStudententDetails();
			
			List<AcademicYear> acYear=academicYearRepository.findAll();
			for (AcademicYear ac : acYear) {
				if (detailsPojo1.getAcademicYear().equals(ac.getName())) {
					fact.setAcademicYearId(ac.getId());					
				}
			}
			List<ClassEntity> classEntity= classRepository.findAll();
			for (ClassEntity cs : classEntity) {
				if (detailsPojo1.getStudentClass().equals(cs.getName())) {
					fact.setClassId(cs.getId());
				}
			}
			List<Student> st=studentRepository.findAll();
			for (Student s : st) {
                 	if (detailsPojo1.getStudentName().equals(s.getName())) {
						fact.setStudentId(s.getStudentId());
					}			
			}
			fact.setRollNo(detailsPojo1.getRollNo());
			fact.setId(idCounter);
			idCounter++;
			
			detailsRepository.save(fact); 
			f.add(fact);
			
		}
		
//		for (FactStudentDetailsPojo detailsPojo : detailsPojos) {
////			Student st= new Student();
//			FactStudentenDetails fact= new FactStudentenDetails();
//			 Student st =studentRepository.findByName(detailsPojo.getStudentName());
//			 fact.setStudentId(st.getStudentId());
//			 ClassEntity cs= classRepository.findByName(detailsPojo.getStudentClass());
//			 fact.setClassId(cs.getId());
//			 AcademicYear ac=academicYearRepository.findByName(detailsPojo.getAcademicYear());
//			 fact.setAcademicYearID(ac.getId());
//			 fact.setRollNo(detailsPojo.getRollNo());
//			 fact.setId(idCounter);
//			 idCounter++;
//			 detailsRepository.save(fact);
//			 f.add(fact);
//			
//		}
		
		return f;
	}

}
