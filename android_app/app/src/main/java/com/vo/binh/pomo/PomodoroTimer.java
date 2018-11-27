package com.vo.binh.pomo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class PomodoroTimer extends AppCompatActivity {
    TextView mTimerView;
    Button mStartPauseButton;
    Button mStopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pomodoro_timer);

        // Views
        mTimerView = findViewById(R.id.timerT);
        mStartPauseButton = findViewById(R.id.startPauseB);
        mStopButton = findViewById(R.id.stopB);

    }
}
