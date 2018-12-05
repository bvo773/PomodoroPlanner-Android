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

public class PomodoroTimer extends AppCompatActivity {
    TextView mTimerView;
    Button mStartPauseButton;
    Button mStopButton;
    CountDownTimer timer;
    final int INTERVAL25MINS = 1501000;

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
                timer = new CountDownTimer(INTERVAL25MINS, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        String text = String.format(Locale.getDefault(), "Time Remaining %02d min: %02d sec",
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) % 60,
                                TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60);
                        mTimerView.setText(text);
                        Log.d("timer", text);
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
