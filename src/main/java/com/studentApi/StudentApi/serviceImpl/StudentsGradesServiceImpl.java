package com.studentApi.StudentApi.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.studentApi.StudentApi.entity.AcademicYear;
import com.studentApi.StudentApi.entity.Assessment;
import com.studentApi.StudentApi.entity.ClassEntity;
import com.studentApi.StudentApi.entity.FactStudententDetails;
import com.studentApi.StudentApi.entity.MarksFactTable;
import com.studentApi.StudentApi.entity.Student;
import com.studentApi.StudentApi.entity.Subject;
import com.studentApi.StudentApi.pojo.AcademicYearPojo;
import com.studentApi.StudentApi.pojo.ClassWiseMarksPojo;
import com.studentApi.StudentApi.pojo.MarksPojos;
import com.studentApi.StudentApi.pojo.StudentsPojo;
import com.studentApi.StudentApi.pojo.SubjectPojo;
import com.studentApi.StudentApi.repository.AcademicYearRepository;
import com.studentApi.StudentApi.repository.AssessmentRepository;
import com.studentApi.StudentApi.repository.ClassRepository;
import com.studentApi.StudentApi.repository.FactStudentDetailsRepository;
import com.studentApi.StudentApi.repository.MarksFacttableRepository;
import com.studentApi.StudentApi.repository.StudentRepository;
import com.studentApi.StudentApi.repository.SubjectRepository;
import com.studentApi.StudentApi.service.StudentsGradesService;

@Service
public class StudentsGradesServiceImpl implements StudentsGradesService {

	@Autowired
	private MarksFacttableRepository factMarksRepo;

	@Autowired
	private AcademicYearRepository academicYearRepo;

	@Autowired
	private ClassRepository classRepository;

	@Autowired
	private StudentRepository StudentRepo;

	@Autowired
	private AssessmentRepository assessmentRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	@Autowired
	private FactStudentDetailsRepository studentDetailsRepository;

	@Override
	public List<AcademicYearPojo> studentsGradesService(int academicYear, int className, String assessment) {
		List<AcademicYear> listofAcadmicYears = new ArrayList<AcademicYear>();
		List<ClassEntity> listOfClassEntities = new ArrayList<ClassEntity>();
		List<Assessment> listofAssessments = new ArrayList<Assessment>();

		if (academicYear == 0) {
			List<MarksFactTable> allData = factMarksRepo.findAll();
			Map<Integer, Integer> uniqueYears = new HashMap<Integer, Integer>();
			for (MarksFactTable factTable : allData) {
				if (!uniqueYears.containsKey(factTable.getAcademicYearId())) {
					uniqueYears.put(factTable.getAcademicYearId(), factTable.getAcademicYearId());
					listofAcadmicYears.add(academicYearRepo.findByIdAndActive(factTable.getAcademicYearId(), true));
				}
			}
		} else {
			listofAcadmicYears.add(academicYearRepo.findByNameAndActive(String.valueOf(academicYear), true));
		}
		if (className == 0) {
			List<MarksFactTable> allData = factMarksRepo.findAll();
			Map<Integer, Integer> uniqueClaases = new HashMap<Integer, Integer>();
			for (MarksFactTable factTable : allData) {
				if (!uniqueClaases.containsKey(factTable.getClassId())) {
					uniqueClaases.put(factTable.getClassId(), factTable.getClassId());
					listOfClassEntities.add(classRepository.findByIdAndActive(factTable.getClassId(), true));
				}
			}
		} else {
			listOfClassEntities.add(classRepository.findByName(String.valueOf(className)));
		}
		if (assessment.equals("0")) {
			List<MarksFactTable> allData = factMarksRepo.findAll();
			Map<Integer, Integer> uniqueAssessment = new HashMap<Integer, Integer>();
			for (MarksFactTable factTable : allData) {
				if (!uniqueAssessment.containsKey(factTable.getAssessmentId())) {
					uniqueAssessment.put(factTable.getAssessmentId(), factTable.getAssessmentId());
					listofAssessments.add(assessmentRepository.findByIdAndActive(factTable.getAssessmentId(), true));
				}
			}
		} else {
			listofAssessments.add(assessmentRepository.findByNameAndActive(assessment, true));
		}
//		AcademicYearPojo Implementation
		List<AcademicYearPojo> academicYearPojos = new ArrayList<AcademicYearPojo>();
		for (AcademicYear year : listofAcadmicYears) {
			int no_Of_Students=0;
			List<MarksFactTable> factTables = factMarksRepo.findByAcademicYearId(year.getId());
			AcademicYearPojo academicYearPojo = new AcademicYearPojo();
			academicYearPojo.setAcademicYear(Integer.parseInt(year.getName()));
//			No of Classes and No of Students and OverAllGrades
			Map<Integer, Integer> uniqueClasses = new HashMap<Integer, Integer>();
			Map<Integer, Integer> uniqueStudents = new HashMap<Integer, Integer>();
			int totalMarks = 0;
			int scoredMarks = 0;
			for (MarksFactTable factTable : factTables) {
				if (!uniqueClasses.containsKey(factTable.getClassId())) {
					uniqueClasses.put(factTable.getClassId(), factTable.getClassId());
				}
				if (!uniqueStudents.containsKey(factTable.getStudentId())) {
					uniqueStudents.put(factTable.getStudentId(), factTable.getStudentId());
				}
				totalMarks += factTable.getMaxMarks();
				scoredMarks += factTable.getScoredMarks();
			}

			academicYearPojo.setOverAllGrades((double) scoredMarks / totalMarks * 100);

//		ClassWisePojo Implementation
			List<ClassWiseMarksPojo> classWiseMarksPojos = new ArrayList<ClassWiseMarksPojo>();
			String counterForClassPojo = "";
			for (ClassEntity classEntity : listOfClassEntities) {
				int totalMaksClassWise=0;
				int scoredMarksClassWise=0;
				List<MarksFactTable> classWiseData = factMarksRepo.findByClassIdAndAcademicYearId(classEntity.getId(),
						year.getId());
                 
				for (MarksFactTable factTable : classWiseData) {
					totalMarks += factTable.getMaxMarks();
					scoredMarks += factTable.getScoredMarks();
					if (factTable.getAcademicYearId() != 0 && !counterForClassPojo.equals(classEntity.getName())) {
						ClassWiseMarksPojo classWiseMarksPojo = new ClassWiseMarksPojo();
						classWiseMarksPojo.setClassName(classEntity.getName());
						counterForClassPojo = classEntity.getName();


						
//		StudentPojo Implementation
						List<StudentsPojo> studentsPojos = new ArrayList<StudentsPojo>();
						List<Student> listOfStudents = StudentRepo.findAll();
						for (Student student : listOfStudents) {
							int scoredMarksByStudent = 0;
							int totalMarksByStudent = 0;
							List<FactStudententDetails> studentData = studentDetailsRepository
									.findByStudentIdAndClassIdAndAcademicYearId(student.getStudentId(),
											classEntity.getId(), year.getId());
							for (FactStudententDetails factTable1 : studentData) {
								if (factTable1.getStudentId() != 0) {
									StudentsPojo studentsPojo = new StudentsPojo();
									studentsPojo.setStudentId(factTable1.getStudentId());
									studentsPojo.setStudentName(student.getName());
									studentsPojo.setRollNo(factTable1.getRollNo());

//		MarksPojo Implementation
									List<MarksPojos> marksPojos = new ArrayList<MarksPojos>();
									for (Assessment assessmen : listofAssessments) {
										List<MarksFactTable> assessments = factMarksRepo
												.findByAssessmentIdAndStudentIdAndClassIdAndAcademicYearId(
														assessmen.getId(), student.getId(), classEntity.getId(),
														year.getId());
										String counterForMarks = "";
										int scoredMarksforSubjects = 0;
										int totalMarksForSubjects = 0;
										for (MarksFactTable studentFactData : assessments) {

											if (studentFactData.getAssessmentId() != 0) {
												if (!counterForMarks.equals(assessmen.getName())) {
													MarksPojos marksPojo = new MarksPojos();
													marksPojo.setAssessmentName(assessmen.getName());

													counterForMarks = assessmen.getName();

													// SubjectPojo Implementation
													List<SubjectPojo> subjectPojos = new ArrayList<SubjectPojo>();
													List<Subject> subjects = subjectRepository.findAll();

													for (Subject subject : subjects) {
														List<MarksFactTable> marksforOneSubject = factMarksRepo
																.findByAssessmentIdAndStudentIdAndSubjectIdAndClassIdAndAcademicYearId(
																		assessmen.getId(), student.getId(),
																		subject.getId(), classEntity.getId(),
																		year.getId());
														for (MarksFactTable subject2 : marksforOneSubject) {
															if (subject2.getSubjectId() != 0) {
																SubjectPojo subjectPojo = new SubjectPojo();
																subjectPojo.setName(subject.getName());
																subjectPojo.setMarks(subject2.getScoredMarks());
																subjectPojo.setMaxMarks(subject2.getMaxMarks());
																subjectPojo.setGrade((double) subject2.getScoredMarks()
																		/ subject2.getMaxMarks() * 100);
																subjectPojos.add(subjectPojo);
																scoredMarksforSubjects += subject2.getScoredMarks();
																totalMarksForSubjects += subject2.getMaxMarks();
															}

														}
													}

													marksPojo.setTotalMarks(totalMarksForSubjects);
													marksPojo.setOverAllGrade((double) scoredMarksforSubjects
															/ totalMarksForSubjects * 100);
													
													marksPojo.setSubjects(subjectPojos);
													marksPojos.add(marksPojo);
												}
											}
										}
										
										scoredMarksByStudent += scoredMarksforSubjects;
										totalMarksByStudent += totalMarksForSubjects;
										studentsPojo.setOverAllGrades(
												(double) scoredMarksByStudent / totalMarksByStudent * 100);
										
									}
                                    if(marksPojos.size()>0) {
    									studentsPojo.setMarks(marksPojos);
    									studentsPojos.add(studentsPojo);
                                    }


								}
							}
                            scoredMarksClassWise+=scoredMarksByStudent;
                            totalMaksClassWise+=totalMarksByStudent;
                            classWiseMarksPojo.setOverAllMarks((double)scoredMarksClassWise/totalMaksClassWise*100);
                                
						}
						classWiseMarksPojo.setNoOfStudents(studentsPojos.size());
						no_Of_Students+=studentsPojos.size();
						
                       if(studentsPojos.size()>0) {
   						classWiseMarksPojo.setStudents(studentsPojos);
   						classWiseMarksPojos.add(classWiseMarksPojo);
                       }


					}
				}
			}
			academicYearPojo.setNoOfStudents(no_Of_Students);
			academicYearPojo.setNoOfClasses(classWiseMarksPojos.size());
			if(classWiseMarksPojos.size()>0) {
				academicYearPojo.setClassWiseMarks(classWiseMarksPojos);
				academicYearPojos.add(academicYearPojo);
			}


		}
		return academicYearPojos;
	}

}
