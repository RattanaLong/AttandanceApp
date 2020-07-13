package com.example.attendanceapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class ViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view);

        //Make a reference to the recyclerview
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        //Create and set a layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        loadAttendance();
    }

    private void loadAttendance() {
        String url = "https://my.api.mockaroo.com/test.json?key=1d03cdf0";

        //Create request
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Convert json string to array of lists using gson
                Gson gson = new Gson();
                Attendance[] attendances = gson.fromJson(response, Attendance[].class);
                ViewAdapter adapter = new ViewAdapter(attendances);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ViewActivity.this, "test", Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(this).add(request);
    }
}
