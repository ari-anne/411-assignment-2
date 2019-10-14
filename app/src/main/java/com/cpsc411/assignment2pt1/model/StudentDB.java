package com.cpsc411.assignment2pt1.model;

import java.util.ArrayList;

public class StudentDB {
    private static final StudentDB ourInstance = new StudentDB();

    private ArrayList<Student> mStudentList;

    public static StudentDB getInstance() {
        return ourInstance;
    }

    private StudentDB() {}

    public ArrayList<Student> getStudentList() {
        return mStudentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        mStudentList = studentList;
    }
}
