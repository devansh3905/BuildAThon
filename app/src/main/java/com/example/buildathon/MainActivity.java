package com.example.buildathon;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText t1, t2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = findViewById(R.id.username);
        t2 = findViewById(R.id.password);
        b1 = findViewById(R.id.logbtn);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(t1.getText().toString().trim(),t2.getText().toString().trim());

            }
        });
    }
    private void validate(String userName, String passWord){

        if((userName.equals("admin1")) && (passWord.equals("admin1"))){
            //------------------------------------------------------------------------------------------
            b1.setEnabled(false);
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {

                    // This method will be executed once the timer is over
                    b1.setEnabled(true);
                }
            },30000);// set time as per your requirement
            //------------------------------------------------------------------------------------------
            Intent intent = new Intent(MainActivity.this, admin1.class);
            startActivity(intent);
        }else if (userName.equals("faculty1") && passWord.equals("faculty1")){
            //------------------------------------------------------------------------------------------
            b1.setEnabled(false);
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {

                    // This method will be executed once the timer is over
                    b1.setEnabled(true);
                }
            },30000);// set time as per your requirement
            //------------------------------------------------------------------------------------------
            Intent intent2 = new Intent(this, facultyMain.class);
            startActivity(intent2);
        }

        else if (userName.equals("1000015062") && passWord.equals("5062")){
            //------------------------------------------------------------------------------------------
            b1.setEnabled(false);
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {

                    // This method will be executed once the timer is over
                    b1.setEnabled(true);
                }
            },30000);// set time as per your requirement
            //------------------------------------------------------------------------------------------
            String sap = t1.getText().toString();
            Toast.makeText(this, "Logged in as " +sap, Toast.LENGTH_LONG).show();
            Intent intent2 = new Intent(this, studentTry.class);
            intent2.putExtra("key_sap", sap);
            startActivity(intent2);

        }

        else if (userName.equals("1000015145") && passWord.equals("5145")) {
            //------------------------------------------------------------------------------------------
            b1.setEnabled(false);
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {

                    // This method will be executed once the timer is over
                    b1.setEnabled(true);
                }
            },30000);// set time as per your requirement
            //------------------------------------------------------------------------------------------
            String sap = t1.getText().toString();
            Toast.makeText(this, "Logged in as " +sap, Toast.LENGTH_LONG).show();
            Intent intent2 = new Intent(this, studentTry.class);
            intent2.putExtra("key_sap", sap);
            startActivity(intent2);
        }

        else if (userName.equals("1000015169") && passWord.equals("5169")) {
            //------------------------------------------------------------------------------------------
            b1.setEnabled(false);
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {

                    // This method will be executed once the timer is over
                    b1.setEnabled(true);
                }
            },30000);// set time as per your requirement
            //------------------------------------------------------------------------------------------
            String sap = t1.getText().toString();
            Toast.makeText(this, "Logged in as " +sap, Toast.LENGTH_LONG).show();
            Intent intent2 = new Intent(this, studentTry.class);
            intent2.putExtra("key_sap", sap);
            startActivity(intent2);
        }

        else if (userName.equals("1000014909") && passWord.equals("4909")) {
            //------------------------------------------------------------------------------------------
            b1.setEnabled(false);
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {

                    // This method will be executed once the timer is over
                    b1.setEnabled(true);
                }
            },30000);// set time as per your requirement
            //------------------------------------------------------------------------------------------
            String sap = t1.getText().toString();
            Toast.makeText(this, "Logged in as " +sap, Toast.LENGTH_LONG).show();
            Intent intent2 = new Intent(this, studentTry.class);
            intent2.putExtra("key_sap", sap);
            startActivity(intent2);
        }
        else{
            Toast.makeText(this, "Enter your Username and Password", Toast.LENGTH_SHORT).show();
        }

    }
}