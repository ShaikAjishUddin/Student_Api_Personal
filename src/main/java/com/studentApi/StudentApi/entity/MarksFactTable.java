package com.studentApi.StudentApi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table
@Entity(name="MarksFactTable")
@Getter
@Setter
public class MarksFactTable {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAcademicYearId() {
        return academicYearId;
    }

    public void setAcademicYearId(int academicYearId) {
        this.academicYearId = academicYearId;
    }

    public int getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(int assessmentId) {
        this.assessmentId = assessmentId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getMaxMarks() {
        return maxMarks;
    }

    public void setMaxMarks(int maxMarks) {
        this.maxMarks = maxMarks;
    }

    public int getScoredMarks() {
        return scoredMarks;
    }

    public void setScoredMarks(int scoredMarks) {
        this.scoredMarks = scoredMarks;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    @Column(name="AcademicYearId")
    private int academicYearId;

    @Column(name="AssessmentId")
    private int assessmentId;

    @Column(name="ClassId")
    private int classId;

    @Column(name="MaxMarks")
    private int maxMarks;

    @Column(name="ScoreMarks")
    private int scoredMarks;

    @Column(name="StudentId")
    private int studentId;

    @Column(name="SubjectId")
    private int subjectId;
}
