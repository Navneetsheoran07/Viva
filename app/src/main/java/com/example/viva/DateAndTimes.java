package com.example.viva;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class DateAndTimes extends AppCompatActivity {
Button button;
TextView textView;
TimePicker datePicker;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_and_times);

        textView  = findViewById(R.id.textView3);
        button = findViewById(R.id.button2);
        datePicker = findViewById(R.id.datepic);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  date = getTime();
                textView.setText(date);
            }
        });
    }

    private String getTime() {

        int hour = datePicker.getHour();
        int mint = datePicker.getMinute();
        String time = hour+":"+mint;
        return time;
    }

//    private String getDate() {
//
//        int day = datePicker.getDayOfMonth();
//        int month = datePicker.getMonth();
//        int year = datePicker.getYear();
//        String dates = day+"/"+month+"/"+year;
//        return  dates;
//    }
}