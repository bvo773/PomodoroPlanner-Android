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
        mTimerButton = findViewById(R.id.btn_timer);
        mPlannerButton = findViewById(R.id.btn_planner);
        mStatisticsButoon = findViewById(R.id.btn_statistics);
    }
}
