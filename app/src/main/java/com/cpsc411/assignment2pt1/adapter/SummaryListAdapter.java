package com.cpsc411.assignment2pt1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cpsc411.assignment2pt1.R;
import com.cpsc411.assignment2pt1.model.Student;
import com.cpsc411.assignment2pt1.model.StudentDB;

public class SummaryListAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return StudentDB.getInstance().getStudentList().size();
    }

    @Override
    public Object getItem(int position) {
        return StudentDB.getInstance().getStudentList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row_view;

        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            row_view = inflater.inflate(R.layout.student_row, parent, false);
        }
        else {
            row_view = convertView;
        }

        Student s = StudentDB.getInstance().getStudentList().get(position);

        ((TextView) row_view.findViewById(R.id.first_name)).setText(s.getFirstName());
        ((TextView) row_view.findViewById(R.id.last_name)).setText(s.getLastName());
        ((TextView) row_view.findViewById(R.id.cwid)).setText(Integer.toString(s.getCWID()));

        return row_view;
    }
}
