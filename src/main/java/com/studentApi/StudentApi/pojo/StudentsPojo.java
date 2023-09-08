package com.studentApi.StudentApi.pojo;

import java.util.List;

public class StudentsPojo {

    private int studentId;
    private String studentName;
    private int rollNo;
    private double overAllGrades;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public double getOverAllGrades() {
        return overAllGrades;
    }

    public void setOverAllGrades(double overAllGrades) {
        this.overAllGrades = overAllGrades;
    }

    public List<MarksPojos> getMarks() {
        return marks;
    }

    public void setMarks(List<MarksPojos> marks) {
        this.marks = marks;
    }

    private List<MarksPojos> marks;
}
