package com.vo.binh.pomo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MenuActivity extends AppCompatActivity {
    // Member Variables (Global)
    Button mTimerButton;
    Button mPlannerButton;
    Button mStatisticsButoon;
    TextView mTodayDateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mTodayDateText = findViewById(R.id.text_date);
        mTodayDateText.setText(getTodayDate());

    }

    public String getTodayDate() {
        Date date = new Date();
        String fDate = new SimpleDateFormat("MMMM dd, yyyy").format(date);
        return fDate;
    }
}
