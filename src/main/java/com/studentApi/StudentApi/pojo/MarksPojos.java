package com.studentApi.StudentApi.pojo;

import java.util.List;

public class MarksPojos {
    private String assessmentName;
    private int totalMarks;
    private double overAllGrade;
    private int noOfSubjects;

    public String getAssessmentName() {
        return assessmentName;
    }

    public void setAssessmentName(String assessmentName) {
        this.assessmentName = assessmentName;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public double getOverAllGrade() {
        return overAllGrade;
    }

    public void setOverAllGrade(double overAllGrade) {
        this.overAllGrade = overAllGrade;
    }

    public List<SubjectPojo> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectPojo> subjects) {
        this.subjects = subjects;
    }

    private List<SubjectPojo> subjects;
}
