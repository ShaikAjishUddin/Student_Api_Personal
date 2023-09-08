package com.studentApi.StudentApi.pojo;

import java.util.List;

public class AcademicYearPojo {
    private int academicYear;
    private int noOfClasses;
    private int noOfStudents;
    private double overAllGrades;

    public int getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
    }

    public int getNoOfClasses() {
        return noOfClasses;
    }

    public void setNoOfClasses(int noOfClasses) {
        this.noOfClasses = noOfClasses;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public double getOverAllGrades() {
        return overAllGrades;
    }

    public void setOverAllGrades(double overAllGrades) {
        this.overAllGrades = overAllGrades;
    }

    public List<ClassWiseMarksPojo> getClassWiseMarks() {
        return classWiseMarks;
    }

    public void setClassWiseMarks(List<ClassWiseMarksPojo> classWiseMarks) {
        this.classWiseMarks = classWiseMarks;
    }

    private List<ClassWiseMarksPojo> classWiseMarks;
}
