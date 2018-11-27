package com.vo.binh.pomo;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PomodoroTimer extends AppCompatActivity {
    TextView mTimerView;
    Button mStartPauseButton;
    Button mStopButton;
    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pomodoro_timer);

        // Views
        mTimerView = findViewById(R.id.timerT);
        mStartPauseButton = findViewById(R.id.startPauseB);
        mStopButton = findViewById(R.id.stopB);

        mStartPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer = new CountDownTimer(30000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        Log.d("Timer", "seconds remaining: " + millisUntilFinished/1000);
                        mTimerView.setText(Long.toString(millisUntilFinished/1000));
                    }

                    @Override
                    public void onFinish() {
                        Log.d("Timer", "done!");
                    }
                }.start();
            }
        });
    }






}
