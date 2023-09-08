package com.studentApi.StudentApi.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.studentApi.StudentApi.entity.AcademicYear;
import com.studentApi.StudentApi.entity.ClassEntity;
import com.studentApi.StudentApi.entity.FactStudententDetails;
import com.studentApi.StudentApi.entity.Student;
import com.studentApi.StudentApi.pojo.ClassWiseStudentsPojo;
import com.studentApi.StudentApi.repository.AcademicYearRepository;
import com.studentApi.StudentApi.repository.ClassRepository;
import com.studentApi.StudentApi.repository.FactStudentDetailsRepository;
import com.studentApi.StudentApi.repository.StudentRepository;
import com.studentApi.StudentApi.service.ClassWiseStudentsService;

@Service
public class ClassWiseStudentsServiceImpl implements ClassWiseStudentsService {

	@Autowired
	private AcademicYearRepository academicYearRepo;

	@Autowired
	private FactStudentDetailsRepository detailsRepo;

	@Autowired
	private ClassRepository classRepo;

	@Autowired
	private StudentRepository StdRepository;

	@Override
	public List<ClassWiseStudentsPojo> getClassWiseStudentsService(Integer academicYear, Integer className) {
		List<ClassWiseStudentsPojo> listOfClassWisePojos = new ArrayList<ClassWiseStudentsPojo>();
		List<FactStudententDetails> factData = detailsRepo.findAll();
		Map<Integer, Integer> uniqueAcademicYears = new HashMap<Integer, Integer>();
		for (FactStudententDetails acYear : factData) {
			if (!uniqueAcademicYears.containsKey(acYear.getAcademicYearId())) {
				uniqueAcademicYears.put(acYear.getAcademicYearId(), acYear.getAcademicYearId());
			}
		}
		if (academicYear == 0 && className == 0) {
			for (Map.Entry<Integer, Integer> entry : uniqueAcademicYears.entrySet()) {
				ClassWiseStudentsPojo classWiseStudentsPojo = new ClassWiseStudentsPojo();
				AcademicYear acYear = academicYearRepo.findByIdAndActive(entry.getValue(), true);
				List<FactStudententDetails> details = detailsRepo.findByAcademicYearId(entry.getValue());
				classWiseStudentsPojo.setAcademicYear(acYear.getName());
				classWiseStudentsPojo.setNoOfClasses(details.size());
				List<Map> classEntities = new ArrayList<>();
				for (FactStudententDetails classs : details) {
					ClassEntity classEntity = classRepo.findByIdAndActive(classs.getClassId(), true);
					Map<String, Object> klass = new HashMap<String, Object>();
					klass.put("Class Name", classEntity.getName());
					classEntities.add(klass);
					List<Map<String, Object>> listOfStudents = new ArrayList<>();
					for (FactStudententDetails factStudententDetails : factData) {
						if (classs.getClassId() == factStudententDetails.getClassId()) {
							Map<String, Object> stDetail = new HashMap<>();
							stDetail.put("Roll No", factStudententDetails.getRollNo());
							stDetail.put("Student Id", factStudententDetails.getStudentId());
							Student st = StdRepository.findById(factStudententDetails.getStudentId()).orElse(null);
							stDetail.put("Student Name", st.getName());
							listOfStudents.add(stDetail);
							klass.put("Students", listOfStudents);
							classWiseStudentsPojo.setClasses(classEntities);
						}

					}
				}

				listOfClassWisePojos.add(classWiseStudentsPojo);
			}
		} else if (academicYear != 0 && className == 0) {
			ClassWiseStudentsPojo classWiseStudentsPojo = new ClassWiseStudentsPojo();
			AcademicYear acYear = academicYearRepo.findByNameAndActive(String.valueOf(academicYear), true);
			List<FactStudententDetails> details = detailsRepo.findByAcademicYearId(acYear.getId());
			classWiseStudentsPojo.setAcademicYear(acYear.getName());
			classWiseStudentsPojo.setNoOfClasses(details.size());
			List<Map> classEntities = new ArrayList<>();
			for (FactStudententDetails classs : details) {
				ClassEntity classEntity = classRepo.findByIdAndActive(classs.getClassId(), true);
				Map<String, Object> klass = new HashMap<>();
				klass.put("Class Name", classEntity.getName());
				classEntities.add(klass);
				List<Map<String, Object>> listOfStudents = new ArrayList<>();
				for (FactStudententDetails factStudententDetails : factData) {
					if (classs.getClassId() == factStudententDetails.getClassId()) {
						Map<String, Object> stDetail = new HashMap<>();
						stDetail.put("Roll No", factStudententDetails.getRollNo());
						stDetail.put("Student Id", factStudententDetails.getStudentId());
						Student st = StdRepository.findById(factStudententDetails.getStudentId()).orElse(null);
						stDetail.put("Student Name", st.getName());
						listOfStudents.add(stDetail);
						klass.put("Students", listOfStudents);
						classWiseStudentsPojo.setClasses(classEntities);
					}

				}
			}
			listOfClassWisePojos.add(classWiseStudentsPojo);

		} else if (academicYear != 0 && className != 0) {
			ClassWiseStudentsPojo classWiseStudentsPojo = new ClassWiseStudentsPojo();
			AcademicYear acYear = academicYearRepo.findByNameAndActive(String.valueOf(academicYear), true);
			ClassEntity classEntity = classRepo.findByName(String.valueOf(className));
			List<FactStudententDetails> details = detailsRepo.findByAcademicYearIdAndClassId(acYear.getId(),classEntity.getId());
			
			classWiseStudentsPojo.setAcademicYear(acYear.getName());
			classWiseStudentsPojo.setNoOfClasses(details.size());
			List<Map> classEntities = new ArrayList<>();
			
			Map<String, Object> klass = new HashMap<>();
			klass.put("Class Name", classEntity.getName());
			classEntities.add(klass);
			List<Map<String, Object>> listOfStudents = new ArrayList<>();
			for (FactStudententDetails factStudententDetails : factData) {
				if (classEntity.getId() == factStudententDetails.getClassId()
						&& acYear.getId() == factStudententDetails.getAcademicYearId()) {
					Map<String, Object> stDetail = new HashMap<>();
					stDetail.put("Roll No", factStudententDetails.getRollNo());
					stDetail.put("Student Id", factStudententDetails.getStudentId());
					Student st = StdRepository.findById(factStudententDetails.getStudentId()).orElse(null);
					stDetail.put("Student Name", st.getName());
					listOfStudents.add(stDetail);
					klass.put("Students", listOfStudents)  ;
					classWiseStudentsPojo.setClasses(classEntities);
				}

			}
			listOfClassWisePojos.add(classWiseStudentsPojo);
		} else if (academicYear.equals(0) && !className.equals(0)) {
			for (Map.Entry<Integer, Integer> entry : uniqueAcademicYears.entrySet()) {

				
				AcademicYear acYear = academicYearRepo.findByIdAndActive(entry.getValue(), true);
				List<FactStudententDetails> details = detailsRepo.findByAcademicYearId(entry.getValue());
				ClassEntity classEntity = classRepo.findByName(String.valueOf(className));
	                        List<FactStudententDetails> classWiseYear = detailsRepo.findByAcademicYearIdAndClassId(entry.getValue(),classEntity.getId());
                                
                              
                                
				for(int i =0;i<classWiseYear.size();i++){
				if(classWiseYear.get(i)!=null) {
				    ClassWiseStudentsPojo classWiseStudentsPojo = new ClassWiseStudentsPojo();
				    classWiseStudentsPojo.setAcademicYear(acYear.getName());
					classWiseStudentsPojo.setNoOfClasses(classWiseYear.size());
					List<Map> classEntities = new ArrayList<>();
					Map<String, Object> klass = new HashMap<String, Object>();
					klass.put("Class Name", classEntity.getName());
					classEntities.add(klass);
					List<Map<String, Object>> listOfStudents = new ArrayList<Map<String, Object>>();
					for (FactStudententDetails factStudententDetails : factData) {
						if (classEntity.getId() == factStudententDetails.getClassId()) {
							Map<String, Object> stDetail = new HashMap<String, Object>();
							stDetail.put("Roll No", factStudententDetails.getRollNo());
							stDetail.put("Student Id", factStudententDetails.getStudentId());
							Student st = StdRepository.findById(factStudententDetails.getStudentId()).orElse(null);
							stDetail.put("Student Name", st.getName());
							listOfStudents.add(stDetail);
							klass.put("Students", listOfStudents);
							classWiseStudentsPojo.setClasses(classEntities);
						}
					}
					listOfClassWisePojos.add(classWiseStudentsPojo);
					}
					

				}
				
				
			}

		}

		return listOfClassWisePojos;
	}

}
