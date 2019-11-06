package com.cpsc411.assignment2.model;

import java.util.ArrayList;

public class StudentDB {
    private static final StudentDB ourInstance = new StudentDB();

    private ArrayList<Student> mStudentList = new ArrayList<Student>();

    public static StudentDB getInstance() {
        return ourInstance;
    }

    private StudentDB() {
        makeStudents();
    }

    public ArrayList<Student> getStudentList() {
        return mStudentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        mStudentList = studentList;
    }

    protected void makeStudents() {
        Student student;
        ArrayList<CourseEnrollment> courses;

        student = new Student("John", "Smith", 123456789);
        courses = new ArrayList<CourseEnrollment>();
        courses.add(new CourseEnrollment("CPSC349", "A"));
        courses.add(new CourseEnrollment("CPSC452", "B"));
        courses.add(new CourseEnrollment("CPSC471", "C"));
        courses.add(new CourseEnrollment("CPSC476", "A"));
        student.setCourses(courses);
        mStudentList.add(student);

        student = new Student("Mark", "Nguyen", 987654321);
        courses = new ArrayList<CourseEnrollment>();
        courses.add(new CourseEnrollment("CPSC240", "A"));
        courses.add(new CourseEnrollment("CPSC311", "B"));
        courses.add(new CourseEnrollment("CPSC335", "B"));
        courses.add(new CourseEnrollment("CPSC481", "A"));
        student.setCourses(courses);
        mStudentList.add(student);

        student = new Student("Rachel", "Miller", 111222333);
        courses = new ArrayList<CourseEnrollment>();
        courses.add(new CourseEnrollment("CPSC362", "C"));
        courses.add(new CourseEnrollment("CPSC452", "B"));
        courses.add(new CourseEnrollment("CPSC315", "A"));
        courses.add(new CourseEnrollment("CPSC332", "B"));
        student.setCourses(courses);
        mStudentList.add(student);
    }
}
