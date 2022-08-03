package com.example.buildathon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addTeach extends AppCompatActivity {
    private EditText v1, v2, v3, v4;
    private Button btnTeach;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teach);

        btnTeach = findViewById(R.id.btnaddteach);
        v1 = findViewById(R.id.fstnameteach);
        v2 = findViewById(R.id.lstnameteach);
        v3 = findViewById(R.id.usernameAddteach);
        v4 = findViewById(R.id.passaddteach);

        btnTeach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (v1.getText().toString().trim().equals("") || v2.getText().toString().trim().equals("") || v3.getText().toString().trim().equals("") || v4.getText().toString().trim().equals("")){
                    Toast.makeText(addTeach.this, "Some fields might be empty", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(addTeach.this, "Faculty information added", Toast.LENGTH_SHORT).show();
                    v1.setText("");
                    v2.setText("");
                    v3.setText("");
                    v4.setText("");
                }
            }
        });

    }
}