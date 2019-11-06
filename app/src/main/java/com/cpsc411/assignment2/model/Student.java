package com.cpsc411.assignment2.model;

import java.util.ArrayList;

public class Student {
    protected String mFirstName;
    protected String mLastName;
    protected int mCWID;

    protected ArrayList<CourseEnrollment> mCourses;

    public Student() {
        mFirstName = "";
        mLastName = "";
        mCWID = 0;
    }

    public Student(String fName, String lName, int cwid) {
        mFirstName = fName;
        mLastName = lName;
        mCWID = cwid;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public int getCWID() {
        return mCWID;
    }

    public void setCWID(int CWID) {
        mCWID = CWID;
    }

    public ArrayList<CourseEnrollment> getCourses() {
        return mCourses;
    }

    public void setCourses(ArrayList<CourseEnrollment> courses) {
        mCourses = courses;
    }
}
