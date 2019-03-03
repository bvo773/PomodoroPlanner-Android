package com.vo.binh.pomo;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;


public class PomodoroTimerActivity extends AppCompatActivity {
    private static final long INTERVAL25MINS_IN_MILLIS = 1500000;
    private TextView mCountDownTextview;
    private Button mStartPauseButton;
    private Button mResetButton;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = INTERVAL25MINS_IN_MILLIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pomodoro_timer);


        mCountDownTextview = findViewById(R.id.countdown_textview);
        mStartPauseButton = findViewById(R.id.start_pause_button);
        mResetButton = findViewById(R.id.reset_button);

        mStartPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer();
            }
        });

        updateCountDownText();
    }

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long l) { // millisUntilFinished
                mTimeLeftInMillis = l;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                mStartPauseButton.setText("Start");
                mStartPauseButton.setVisibility(View.INVISIBLE);
                mResetButton.setVisibility(View.VISIBLE);
            }
        }.start();

        mTimerRunning = true;
        mStartPauseButton.setText("pause");
        mResetButton.setVisibility(View.INVISIBLE);
    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        mStartPauseButton.setText("start");
        mResetButton.setVisibility(View.VISIBLE);
        mStartPauseButton.setVisibility(View.VISIBLE);

    }

    private void resetTimer() {
        mTimeLeftInMillis = INTERVAL25MINS_IN_MILLIS;
        updateCountDownText();
        mResetButton.setVisibility(View.INVISIBLE);
        mStartPauseButton.setVisibility(View.VISIBLE);

    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000 / 60);
        int seconds = (int) (mTimeLeftInMillis / 1000 % 60);

        String timeLeftFortmatted = String.format(Locale.getDefault(), "%20d:%20d", minutes, seconds);

        //mCountDownTextview.setText(timeLeftFortmatted);
    }









}
