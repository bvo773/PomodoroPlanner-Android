package com.vo.binh.pomo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MenuActivity extends AppCompatActivity {
    // Member Variables (Global)
    CardView mCardView1, mCardView2, mCardView3, mCardView4;
    TextView mTodayDateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mTodayDateText = findViewById(R.id.text_date);
        mTodayDateText.setText(getTodayDate());

        inflateCardViews(mCardView1, mCardView2, mCardView3, mCardView4);

        mCardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent PomodoroTimerActivity = new Intent(MenuActivity.this, PomodoroTimerActivity.class);
                startActivity(PomodoroTimerActivity);
            }
        });

        mCardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent PomodoroPlannerActivity = new Intent(MenuActivity.this, TaskListActivity.class);
                startActivity(PomodoroPlannerActivity);
            }
        });
    }

    public String getTodayDate() {
        Date date = new Date();
        String fDate = new SimpleDateFormat("MMMM dd, yyyy").format(date);
        return fDate;
    }

    private void inflateCardViews(CardView cardView1, CardView cardView2, CardView cardView3, CardView cardView4) {
        mCardView1 = findViewById(R.id.card_view1);
        mCardView2 = findViewById(R.id.card_view2);
        mCardView3 = findViewById(R.id.card_view3);
        mCardView4 = findViewById(R.id.card_view4);
    }
    private void slideToRightAnimation(CardView cardView1, CardView cardView2, CardView cardView3, CardView cardView4) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.lefttoright);
        cardView1.startAnimation(animation);
        cardView2.startAnimation(animation);
        cardView3.startAnimation(animation);
        cardView4.startAnimation(animation);
    }


}
