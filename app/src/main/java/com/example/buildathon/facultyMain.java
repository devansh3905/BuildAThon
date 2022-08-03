package com.example.buildathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class facultyMain extends AppCompatActivity {


    Button bt1, bt2, bt3, bt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_main);

        bt1 = findViewById(R.id.bt_fac1);
        bt2 = findViewById(R.id.bt_fac2);
        bt3 = findViewById(R.id.bt_fac3);
        bt4 = findViewById(R.id.bt_fac4);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(facultyMain.this, createSession.class);
                startActivity(intent);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //managing timetable------
                Intent intent = new Intent(facultyMain.this,timetableAdding.class);
                startActivity(intent);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(facultyMain.this,timePickerNotify.class);
                startActivity(intent);
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(facultyMain.this,settingAll.class);
                startActivity(intent2);
            }
        });
    }
}