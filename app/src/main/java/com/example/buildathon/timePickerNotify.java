package com.example.buildathon;

import androidx.appcompat.app.AppCompatActivity;


import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.util.Calendar;

public class timePickerNotify extends AppCompatActivity {
    Button slctTime, confirm;
    TextView txtviu;
    EditText edttxt1, edttxt2;
    Switch swtch;

    private Calendar calendar;
    private AlarmManager alarmManager;
    PendingIntent pendingIntent;
    private MaterialTimePicker picker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker_notify);

        createNotificationChannel();

        slctTime = findViewById(R.id.slcttime);
        confirm = findViewById(R.id.confirm);
        txtviu = findViewById(R.id.showMeTime);
        edttxt1 = findViewById(R.id.subCode);
        edttxt2 = findViewById(R.id.secCode);
        swtch = findViewById(R.id.switch1);




        slctTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showTimePicker();

            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setAlarm();

                txtviu.setText("");
                edttxt1.setText("");
                edttxt2.setText("");
            }
        });
    }

    private void setAlarm() {
    alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this,AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(this,0,intent,0);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);
        if (swtch.isChecked()){
            alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);
            Toast.makeText(this, "Class Scheduled Successfully, will be repeated tomorrow.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Class Scheduled Successfully", Toast.LENGTH_SHORT).show();
        }
    }

    private void showTimePicker() {

        picker = new MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .setHour(12)
                .setMinute(0)
                .setTitleText("Select Lecture Time")
                .build();

        picker.show(getSupportFragmentManager(),"timepicker");

        picker.addOnPositiveButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (picker.getHour()>12){
                    txtviu.setText((picker.getHour()-12)+":"+picker.getMinute()+" PM");
                }
                else{
                    txtviu.setText(picker.getHour()+":"+picker.getMinute()+" AM");
                }

                calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY,picker.getHour());
                calendar.set(Calendar.MINUTE,picker.getMinute());
                calendar.set(Calendar.SECOND,0);
                calendar.set(Calendar.MILLISECOND,0);
            }
        });
    }

    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            CharSequence name = "NotificationChannel";
            String description = "Channel for Notification";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel("timepicker",name,importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
