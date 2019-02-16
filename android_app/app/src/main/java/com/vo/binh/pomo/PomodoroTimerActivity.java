package com.vo.binh.pomo;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class PomodoroTimerActivity extends AppCompatActivity {
    TextView mTimerView;
    Button mStartPauseButton;
    Button mStopButton;
    CountDownTimer timer;
    final int INTERVAL25MINS = 1501000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pomodoro_timer);


    }






}
