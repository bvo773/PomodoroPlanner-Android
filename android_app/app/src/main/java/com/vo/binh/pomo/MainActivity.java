package com.vo.binh.pomo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    // Member Variables (Global)
    Button mTimerButton;
    Button mPlannerButton;
    Button mStatisticsButoon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Views
        mTimerButton = findViewById(R.id.timerB);
        mPlannerButton = findViewById(R.id.plannerB);
        mStatisticsButoon = findViewById(R.id.statisticsB);
        startTimer();
    }

    public void startTimer() {
        Timer time = new Timer(15000);
    }
}
