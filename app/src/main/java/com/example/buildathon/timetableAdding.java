package com.example.buildathon;


import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class timetableAdding extends AppCompatActivity {

    EditText ttday,ttSTime,ttEtTime,ttSub,ttSec;
    Button addItem, startTimebt,endTimebt;
    ProgressDialog progressDialog;
    private Calendar calendar;
    private MaterialTimePicker picker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable_adding);

        ttday = findViewById(R.id.day);
        ttSTime = findViewById(R.id.stTime);
        ttEtTime = findViewById(R.id.edTime);
        ttSub = findViewById(R.id.ttSub);
        ttSec = findViewById(R.id.ttSec);
        addItem = findViewById(R.id.additems);
        startTimebt = findViewById(R.id.startTimebtn);
        endTimebt = findViewById(R.id.endTimebtn);

        startTimebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectStartTime();
            }
        });

        endTimebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectEndTime();
            }
        });

        progressDialog = new ProgressDialog(timetableAdding.this);
        progressDialog.setMessage("Loading...");

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTTdata();
                progressDialog.show();
                ttday.setText("");
                ttSTime.setText("");
                ttEtTime.setText("");
                ttSec.setText("");
                ttSub.setText("");
            }
        });
    }

    private void selectEndTime() {
        picker = new MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .setHour(12)
                .setMinute(0)
                .setTitleText("Select End Time")
                .build();

        picker.show(getSupportFragmentManager(),"timepicker");

        picker.addOnPositiveButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (picker.getHour()>12){
                    ttEtTime.setText((picker.getHour()-12)+":"+(picker.getMinute())+" PM");
                }
                else{
                    ttEtTime.setText(picker.getHour()+":"+picker.getMinute()+" AM");
                }

                calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY,picker.getHour());
                calendar.set(Calendar.MINUTE,picker.getMinute());
                calendar.set(Calendar.SECOND,0);
                calendar.set(Calendar.MILLISECOND,0);

            }
        });
    }

    private void selectStartTime() {
        picker = new MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .setHour(12)
                .setMinute(0)
                .setTitleText("Select Start Time")
                .build();

        picker.show(getSupportFragmentManager(),"timepicker");

        picker.addOnPositiveButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (picker.getHour()>12){
                    ttSTime.setText((picker.getHour()-12)+":"+(picker.getMinute())+" PM");
                }
                else{
                    ttSTime.setText(picker.getHour()+":"+picker.getMinute()+" AM");
                }

                calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY,picker.getHour());
                calendar.set(Calendar.MINUTE,picker.getMinute());
                calendar.set(Calendar.SECOND,0);
                calendar.set(Calendar.MILLISECOND,0);


            }
        });
    }

    public void addTTdata(){
        String var_day = ttday.getText().toString();
        String var_start_time = ttSTime.getText().toString();
        String var_end_time = ttEtTime.getText().toString();
        String var_sub = ttSub.getText().toString();
        String var_sec = ttSec.getText().toString();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://script.google.com/macros/s/AKfycby1dZ6AHrvj16Qq_WDMSr01vhKwA-8mEruELnT_CISvZ5Wt39ea9Vba9OYaRWv5bwSXKA/exec", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //success pe kya hoga
                Toast.makeText(timetableAdding.this, "Successfully added", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams(){
                Map<String,String> params = new HashMap<>();
                params.put("action", "addItems");
                params.put("vday",var_day);
                params.put("vstime",var_start_time);
                params.put("vetime",var_end_time);
                params.put("vsub",var_sub);
                params.put("vsec",var_sec);

                return params;
            }
        };

        int socketTimeout = 10000;
        RetryPolicy retryPolicy = new DefaultRetryPolicy(socketTimeout,0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }
}