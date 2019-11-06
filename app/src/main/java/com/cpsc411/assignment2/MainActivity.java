package com.cpsc411.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.cpsc411.assignment2.adapter.SummaryListAdapter;

public class MainActivity extends AppCompatActivity {

    protected ListView mSummaryView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.summary_list);

//        create summary of students
        mSummaryView = findViewById(R.id.summary_list_id);
        SummaryListAdapter ad = new SummaryListAdapter();
        mSummaryView.setAdapter(ad);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.summary_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add_student) {
//            go to new activity to create new student
            Intent intent = new Intent(this, StudentDetails.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
