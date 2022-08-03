package com.example.buildathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;

public class resetPass extends AppCompatActivity {
    private Button buttonreset;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pass);

        buttonreset = findViewById(R.id.resettt);
        editText = findViewById(R.id.resetEmail);

        buttonreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
                Toast.makeText(resetPass.this, "Reset link send to your email.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}