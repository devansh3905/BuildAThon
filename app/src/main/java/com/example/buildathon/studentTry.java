package com.example.buildathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class studentTry extends AppCompatActivity {
    public static TextView naam_kisikaaa;
    Button stu_btn1, stu_btn2, stu_btn3, stu_btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_try);

        naam_kisikaaa = findViewById(R.id.naam_kisika);
        stu_btn1 = findViewById(R.id.stu_open_qr);
        stu_btn2 = findViewById(R.id.stu_open_course);
        stu_btn3 = findViewById(R.id.stu_open_atten);
        stu_btn4 = findViewById(R.id.stu_open_sett);

        String user_sap = getIntent().getStringExtra("key_sap");
        naam_kisikaaa.setText(user_sap);

        stu_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String qr_info = naam_kisikaaa.getText().toString();
                Intent intent = new Intent(studentTry.this, qrGeneMain.class);
                intent.putExtra("qr_info_key", qr_info);
                startActivity(intent);
            }
        });
        stu_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(studentTry.this, stuCourse.class);
                startActivity(intent);
            }
        });
        stu_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(studentTry.this, "Interface not added yet.", Toast.LENGTH_SHORT).show();
            }
        });
        stu_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(studentTry.this, settingAll.class);
                startActivity(intent);
            }
        });


    }
}