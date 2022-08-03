package com.example.buildathon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class stuCourse extends AppCompatActivity {
    
    Button bbbttt1, bbbttt2, bbbttt3, bbbttt4, bbbttt5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_course);
        bbbttt1 = findViewById(R.id.bbtt1);
        bbbttt2 = findViewById(R.id.bbtt2);
        bbbttt3 = findViewById(R.id.bbtt3);
        bbbttt4 = findViewById(R.id.bbtt4);
        bbbttt5 = findViewById(R.id.bbtt5);
        
        bbbttt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(stuCourse.this, "Field only editable by Admin Department", Toast.LENGTH_SHORT).show();
            }
        });
        bbbttt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(stuCourse.this, "Field only editable by Admin Department", Toast.LENGTH_SHORT).show();
            }
        });
        bbbttt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(stuCourse.this, "Field only editable by Admin Department", Toast.LENGTH_SHORT).show();
            }
        });
        bbbttt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(stuCourse.this, "Field only editable by Admin Department", Toast.LENGTH_SHORT).show();
            }
        });
        bbbttt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(stuCourse.this, "Field only editable by Admin Department", Toast.LENGTH_SHORT).show();
            }
        });
        
    }
}