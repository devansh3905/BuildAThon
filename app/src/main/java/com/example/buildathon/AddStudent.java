package com.example.buildathon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudent extends AppCompatActivity {
    private EditText v1, v2, v3, v4, v5, v6;
    Button btnsubm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        btnsubm = findViewById(R.id.btnsub);
        v1 = findViewById(R.id.fstname);
        v2 = findViewById(R.id.lstname);
        v3 = findViewById(R.id.course);
        v4 = findViewById(R.id.section);
        v5 = findViewById(R.id.usernameAdd);
        v6 = findViewById(R.id.passAdd);
        btnsubm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (v1.getText().toString().trim().equals("") || v2.getText().toString().trim().equals("") || v3.getText().toString().trim().equals("") || v4.getText().toString().trim().equals("") || v5.getText().toString().trim().equals("") || v6.getText().toString().trim().equals("")){
                    Toast.makeText(AddStudent.this, "Some fields might be empty", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(AddStudent.this, "Student information added", Toast.LENGTH_SHORT).show();
                    v1.setText("");
                    v2.setText("");
                    v3.setText("");
                    v4.setText("");
                    v5.setText("");
                    v6.setText("");
                }
            }
        });
    }
}