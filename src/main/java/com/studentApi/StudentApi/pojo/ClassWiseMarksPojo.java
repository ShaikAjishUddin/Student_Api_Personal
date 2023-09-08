package com.studentApi.StudentApi.pojo;

import java.util.List;

public class ClassWiseMarksPojo {
    private String className;
    private double overAllMarks;
    private int noOfStudents;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getOverAllMarks() {
        return overAllMarks;
    }

    public void setOverAllMarks(double overAllMarks) {
        this.overAllMarks = overAllMarks;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public List<StudentsPojo> getStudents() {
        return students;
    }

    public void setStudents(List<StudentsPojo> students) {
        this.students = students;
    }

    private List<StudentsPojo> students;

}
