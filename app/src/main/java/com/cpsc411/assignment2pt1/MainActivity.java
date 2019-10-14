package com.cpsc411.assignment2pt1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.cpsc411.assignment2pt1.adapter.SummaryListAdapter;
import com.cpsc411.assignment2pt1.model.CourseEnrollment;
import com.cpsc411.assignment2pt1.model.Student;
import com.cpsc411.assignment2pt1.model.StudentDB;

import java.util.ArrayList;

public class MainActivity extends Activity {

    protected ListView mSummaryView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.student_list_lv);

        createStudents();
        mSummaryView = findViewById(R.id.summary_list_id);
        SummaryListAdapter ad = new SummaryListAdapter();
        mSummaryView.setAdapter(ad);
    }

    protected void createStudents() {
        Student student;
        ArrayList<CourseEnrollment> courses;
        ArrayList<Student> students = new ArrayList<Student>();

        student = new Student("John", "Smith", 123456789);
        courses = new ArrayList<CourseEnrollment>();
        courses.add(new CourseEnrollment("CPSC349", "A-"));
        courses.add(new CourseEnrollment("CPSC452", "B"));
        courses.add(new CourseEnrollment("CPSC471", "C+"));
        courses.add(new CourseEnrollment("CPSC476", "A"));
        student.setCourses(courses);
        students.add(student);

        student = new Student("Mark", "Nguyen", 987654321);
        courses = new ArrayList<CourseEnrollment>();
        courses.add(new CourseEnrollment("CPSC240", "A"));
        courses.add(new CourseEnrollment("CPSC311", "B+"));
        courses.add(new CourseEnrollment("CPSC335", "B-"));
        courses.add(new CourseEnrollment("CPSC481", "A"));
        student.setCourses(courses);
        students.add(student);

        student = new Student("Rachel", "Miller", 111222333);
        courses = new ArrayList<CourseEnrollment>();
        courses.add(new CourseEnrollment("CPSC362", "C"));
        courses.add(new CourseEnrollment("CPSC452", "B"));
        courses.add(new CourseEnrollment("CPSC315", "A-"));
        courses.add(new CourseEnrollment("CPSC332", "B+"));
        student.setCourses(courses);
        students.add(student);

        StudentDB.getInstance().setStudentList(students);
    }
}
