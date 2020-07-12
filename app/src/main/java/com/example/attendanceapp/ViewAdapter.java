package com.example.attendanceapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewAdapter extends RecyclerView.Adapter<AttendanceViewHolder> {

    private Attendance[] attendances;

    public ViewAdapter(Attendance[] attendances) {
        this.attendances = attendances;
    }

    @NonNull
    @Override
    public AttendanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.view_holder_attendance, parent,false);

        return new AttendanceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AttendanceViewHolder holder, int position) {
        Attendance attendance = attendances[position];
        holder.bind(attendance);
    }

    @Override
    public int getItemCount() {
        return attendances.length;
    }
}
