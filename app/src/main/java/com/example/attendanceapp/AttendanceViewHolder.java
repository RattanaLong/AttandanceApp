package com.example.attendanceapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AttendanceViewHolder extends RecyclerView.ViewHolder {

    private TextView txtName;
    private TextView txtEmail;
//    private TextView txtAttendance;


    public AttendanceViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void bind(Attendance attendance) {
        txtName.setText(attendance.getName());
        txtEmail.setText(attendance.getEmail());
//        txtAttendance.setText(attendance.getAttendance());

    }
}
