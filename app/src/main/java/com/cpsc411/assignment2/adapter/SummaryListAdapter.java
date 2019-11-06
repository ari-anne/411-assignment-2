package com.cpsc411.assignment2.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cpsc411.assignment2.R;
import com.cpsc411.assignment2.StudentDetails;
import com.cpsc411.assignment2.model.Student;
import com.cpsc411.assignment2.model.StudentDB;

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
        View row_view = convertView;

        if(row_view == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            row_view = inflater.inflate(R.layout.summary_list_row, parent, false);
        }

        Student s = StudentDB.getInstance().getStudentList().get(position);

        ((TextView) row_view.findViewById(R.id.first_name)).setText(s.getFirstName());
        ((TextView) row_view.findViewById(R.id.last_name)).setText(s.getLastName());
        ((TextView) row_view.findViewById(R.id.cwid)).setText(Integer.toString(s.getCWID()));
        row_view.setTag(new Integer(position));

        row_view.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), StudentDetails.class);
                        intent.putExtra("StudentIndex", ((Integer)v.getTag()).intValue());
                        v.getContext().startActivity(intent);
                    }
                }
        );

        return row_view;
    }
}
