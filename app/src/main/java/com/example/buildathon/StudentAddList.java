
package com.example.buildathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentAddList extends AppCompatActivity {
    Button btnAddStu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_add_list);
        btnAddStu = findViewById(R.id.btnAddStu);

        btnAddStu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentAddList.this, AddStudent.class);
                startActivity(intent);
            }
        });
    }
}