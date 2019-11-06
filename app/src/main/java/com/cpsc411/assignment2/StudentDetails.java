package com.cpsc411.assignment2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.cpsc411.assignment2.adapter.CourseListAdapter;
import com.cpsc411.assignment2.model.CourseEnrollment;
import com.cpsc411.assignment2.model.Student;
import com.cpsc411.assignment2.model.StudentDB;

import java.util.ArrayList;

public class StudentDetails extends AppCompatActivity {

    Menu mOptions;
    Button mButton;
    boolean studentExists;
    Student student = new Student();
    ArrayList<CourseEnrollment> courses;
    ArrayList<EditText> courseIDs = new ArrayList<EditText>();
    ArrayList<EditText> grades = new ArrayList<EditText>();
    ArrayList<LinearLayout> rows = new ArrayList<LinearLayout>();
    LinearLayout courseList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_student);

        mButton = findViewById(R.id.add_course);
        int index = getIntent().getIntExtra("StudentIndex", -1);
        studentExists = index >= 0;

        if(studentExists) {
            student = StudentDB.getInstance().getStudentList().get(index);

//            fill in student info
            EditText editText = findViewById(R.id.first_name);
            editText.setText(student.getFirstName());
            editText.setEnabled(false);
            editText = findViewById(R.id.last_name);
            editText.setText(student.getLastName());
            editText.setEnabled(false);
            editText = findViewById(R.id.cwid);
            editText.setText(Integer.toString(student.getCWID()));
            editText.setEnabled(false);
            courses = student.getCourses();

//            hide add course button
            mButton.setVisibility(View.GONE);
        }
        else {
//            initialize empty course list
            courses = new ArrayList<CourseEnrollment>();
            student.setCourses(courses);
        }

//        create adapter for course list
        ListView courseList = findViewById(R.id.course_list_view);
        CourseListAdapter adapter = new CourseListAdapter(student);
        courseList.setAdapter(adapter);
    }

    public void addCourse(View v) {
        courseList = findViewById(R.id.course_list);

//        add rows to listview
        LayoutInflater inflater = LayoutInflater.from(this);
        LinearLayout row = (LinearLayout) inflater.inflate(R.layout.course_row, courseList, false);
        rows.add(row);
        courseList.addView(row);

//        save EditTexts for referencing
        EditText course = row.findViewById(R.id.course_id);
        EditText grade = row.findViewById(R.id.grade);
        courseIDs.add(course);
        grades.add(grade);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);

        if(studentExists) {
            menu.findItem(R.id.edit).setVisible(true);
            menu.findItem(R.id.save).setVisible(false);
            menu.findItem(R.id.create).setVisible(false);
        }
        else {
            menu.findItem(R.id.edit).setVisible(false);
            menu.findItem(R.id.save).setVisible(false);
            menu.findItem(R.id.create).setVisible(true);
        }

        mOptions = menu;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.create || item.getItemId() == R.id.save) {
            mOptions.findItem(R.id.edit).setVisible(true);
            mOptions.findItem(R.id.save).setVisible(false);

//            get text and disable editing
            EditText editText = findViewById(R.id.first_name);
            editText.setEnabled(false);
            String firstName = editText.getText().toString();
            editText = findViewById(R.id.last_name);
            editText.setEnabled(false);
            String lastName = editText.getText().toString();
            editText = findViewById(R.id.cwid);
            editText.setEnabled(false);
            int cwid = Integer.parseInt(editText.getText().toString());

//            remove add course button
            mButton.setVisibility(View.GONE);

//            save student info
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setCWID(cwid);

//            adds new courses to student
            for(int i = 0; i < rows.size(); i++) {
                String courseID = courseIDs.get(i).getText().toString();
                String grade = grades.get(i).getText().toString();
                courses.add(new CourseEnrollment(courseID, grade));
                courseList.removeView(rows.get(i));
            }

//            creates new student in student list
            if(item.getItemId() == R.id.create) {
                mOptions.findItem(R.id.create).setVisible(false);
                StudentDB.getInstance().getStudentList().add(student);
            }
        }
        else if (item.getItemId() == R.id.edit) {
            mOptions.findItem(R.id.edit).setVisible(false);
            mOptions.findItem(R.id.save).setVisible(true);

//            enable editing student info
            EditText editText = findViewById(R.id.first_name);
            editText.setEnabled(true);
            editText = findViewById(R.id.last_name);
            editText.setEnabled(true);
            editText = findViewById(R.id.cwid);
            editText.setEnabled(true);

//            show add course button
            mButton.setVisibility(View.VISIBLE);

//            clear arrays
            courseIDs.clear();
            grades.clear();
            rows.clear();
        }

        return super.onOptionsItemSelected(item);
    }
}
