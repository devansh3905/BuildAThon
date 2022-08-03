package com.example.buildathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class createSession extends AppCompatActivity {

    String [] time_start = {"9 AM", "10 AM", "11 AM", "12 PM", "1 PM", "2 PM", "3 PM", "4 PM", "5 PM"};
    String [] time_end = {"10 AM", "11 AM", "12 PM", "1 PM", "2 PM", "3 PM", "4 PM", "5 PM"};

    AutoCompleteTextView autoCompleteTextView, autoCompleteTextView2;

    ArrayAdapter<String> adapterItems, adapterItems2;
    Button btn_crea;

    EditText et1, et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_session);

        autoCompleteTextView = findViewById(R.id.auto_complete_text);
        autoCompleteTextView2 = findViewById(R.id.auto_complete_text2);
        btn_crea = findViewById(R.id.crea_session);
        et1 = findViewById(R.id.enterSubject);
        et2 = findViewById(R.id.enterSection);


        adapterItems = new ArrayAdapter<>(this, R.layout.list_item,time_start);
        adapterItems2 = new ArrayAdapter<>(this, R.layout.list_item,time_end);

        autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView2.setAdapter(adapterItems2);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(createSession.this, item, Toast.LENGTH_SHORT).show();
            }
        });
        autoCompleteTextView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(createSession.this, item, Toast.LENGTH_SHORT).show();
            }
        });
        btn_crea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et1.getText().toString().trim().equals("") || et2.getText().toString().trim().equals("")){
                    Toast.makeText(createSession.this, "Subject and Section feild cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    String subject_go = et1.getText().toString();
                    String section_go = et2.getText().toString();
                    Intent intent = new Intent(createSession.this, ScannerfacTry1.class);
                    intent.putExtra("sub_go", subject_go);
                    intent.putExtra("sec_go", section_go);
                    startActivity(intent);
                    Toast.makeText(createSession.this, "Creating session..", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}