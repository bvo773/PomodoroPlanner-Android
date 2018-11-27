package com.vo.binh.pomo;

import android.os.CountDownTimer;
import android.os.Debug;
import android.util.Log;

public class Timer {

    private long seconds;

    private CountDownTimer timer;

    public Timer(long seconds) {
        timer = new CountDownTimer(seconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.d("Timer", "seconds remaining: " + millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                Log.d("Timer", "done!");
            }
        }.start();
    }

}
