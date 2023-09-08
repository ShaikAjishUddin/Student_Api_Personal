package com.studentApi.StudentApi.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import com.studentApi.StudentApi.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.studentApi.StudentApi.pojo.MarksPojo;
import com.studentApi.StudentApi.repository.AcademicYearRepository;
import com.studentApi.StudentApi.repository.AssessmentRepository;
import com.studentApi.StudentApi.repository.ClassRepository;
import com.studentApi.StudentApi.repository.MarksFacttableRepository;
import com.studentApi.StudentApi.repository.MarksRepository;
import com.studentApi.StudentApi.repository.StudentRepository;
import com.studentApi.StudentApi.repository.SubjectRepository;
import com.studentApi.StudentApi.service.MarksService;


@Service
public class MarksServiceImpl implements MarksService{
	
	@Autowired
	private MarksRepository marksRepo;
	@Autowired
	private AcademicYearRepository academicYearRepository;
	@Autowired
	private AssessmentRepository assessmentRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private SubjectRepository subjectRepository;
	@Autowired
	private ClassRepository classRepository;
	@Autowired
	private MarksFacttableRepository facttableRepository;

	@Override
	public List<Marks> getAllMarksByActiveService(boolean active) {
		// TODO Auto-generated method stub
		return marksRepo.findAllByActive(active);
	}

	@Override
	public Marks getByMarksIdAndActiveService(int id, boolean active) {
		// TODO Auto-generated method stub
		return marksRepo.findByIdAndActive(id, active);
	}

	@Override
	public Marks updateMarksService(Marks marks) {
		// TODO Auto-generated method stub
		return marksRepo.save(marks);
	}

	@Override
	public Marks insertMarksService(Marks marks) {
		// TODO Auto-generated method stub
		return marksRepo.save(marks);
	}

	@Override
	public Marks deleteMarksService(int id, boolean active) {
		// TODO Auto-generated method stub
		Marks marks=marksRepo.findByIdAndActive(id, active);
		marks.setActive(false);
		return marksRepo.save(marks);
	}



	@Override
	public List<MarksPojo> insertMarksPojo(List<MarksPojo> marksPojos) {
		List<MarksFactTable> listOfMarksPojos=new ArrayList<>();

		for (MarksPojo marksPojoObject : marksPojos){

			MarksFactTable  marksObject=new MarksFactTable();
			AcademicYear academicYear= academicYearRepository.findByNameAndActive(String.valueOf(marksPojoObject.getAcademicYear()), true);
			
				marksObject.setAcademicYearId(academicYear.getId());
			
			Assessment assessment = assessmentRepository.findByNameAndActive(marksPojoObject.getAssessmentName(),true);
			
				marksObject.setAssessmentId(assessment.getId());
			
			ClassEntity classEntity=classRepository.findByNameAndActive(String.valueOf(marksPojoObject.getClassName()),true);
			
				marksObject.setClassId(classEntity.getId());
			
			marksObject.setMaxMarks(marksPojoObject.getMaxMarks());
			marksObject.setScoredMarks(marksPojoObject.getScore());

			Student student=studentRepository.findByName(marksPojoObject.getStudentName());
			
				marksObject.setStudentId(student.getStudentId());
			
			Subject subject=subjectRepository.findByNameAndActive(marksPojoObject.getSubjectName(),true);
			
				marksObject.setSubjectId(subject.getId());
			
				facttableRepository.save(marksObject);	
			listOfMarksPojos.add(marksObject);
		}

		return marksPojos;
	}

}
