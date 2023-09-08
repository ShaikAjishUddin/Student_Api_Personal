package com.studentApi.StudentApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentApi.StudentApi.entity.MarksFactTable;
@Repository
public interface MarksFacttableRepository extends JpaRepository<MarksFactTable, Integer>{
    List<MarksFactTable> findAll();
    List<MarksFactTable> findByClassId(int classId);
    List<MarksFactTable> findByStudentId(int studentId);
    List<MarksFactTable> findByAssessmentId(int assessmentId);
    List<MarksFactTable> findBySubjectId(int subjectId);
    List<MarksFactTable> findByAcademicYearIdAndClassIdAndAssessmentId(int academicYearId,int classId,int assessmentId);
    List<MarksFactTable> findByAcademicYearId(int academicYearId);
    List<MarksFactTable> findByAcademicYearIdAndClassId(int academicYearId,int classId);
    List<MarksFactTable> findByAcademicYearIdAndAssessmentId(int academicYearId,int assessmentId);
    List<MarksFactTable> findByClassIdAndAssessmentId(int classId,int assessmentId);
    List<MarksFactTable> findByAcademicYearIdAndClassIdAndStudentId(int academicYearId,int classId,int studentId);
	List<MarksFactTable> findByAcademicYearIdAndClassIdAndStudentIdAndAssessmentId(int academicYearId, int classId, int studentId,
			int assessmentId);
	List<MarksFactTable> findByAcademicYearIdAndClassIdAndStudentIdAndAssessmentIdAndSubjectId(int academicYearid, int classId,
			int studentId, int assessmentId, int subjectId);
	List<MarksFactTable> findByAssessmentIdAndSubjectId(int assessmentId, int subjectId);
	List<MarksFactTable> findByAssessmentIdAndStudentIdAndSubjectId(int assessmentId, int studentId, int subjectId);
	List<MarksFactTable> findByAssessmentIdAndStudentId(int assessmentId, int studentsId);
	List<MarksFactTable> findByAssessmentIdAndStudentIdAndSubjectIdAndClassId(int assessmentId, int studentId, int subjectId, int classId);
	List<MarksFactTable> findByAssessmentIdAndStudentIdAndClassId(int assessmentId, int studentId, int classId);
	List<MarksFactTable> findByAssessmentIdAndStudentIdAndSubjectIdAndClassIdAndAcademicYearId(int assessmentId, int studentId, int subjectId,
			int classId,int academicYearId);
	List<MarksFactTable> findByAssessmentIdAndStudentIdAndClassIdAndAcademicYearId(int assessmentId, int studentId, int classId, int academicYearId);
	List<MarksFactTable> findByClassIdAndAcademicYearId(int classId, int academicYearId);
	
}