package com.vo.binh.pomo;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class LoginActivity extends AppCompatActivity {
    private Button mLogInButton;
    private Button mSignUpButton;
    private ImageView mLogInImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLogInButton = findViewById(R.id.login_button);
        mLogInImageView= findViewById(R.id.log_in_image);
        mSignUpButton = findViewById(R.id.signup_button);

        Glide.with(this).load(R.drawable.pomodoro_grow).into(mLogInImageView);

        mLogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogIn();
            }
        });

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUp();
            }
        });

        /* Animation */
        slideToRightAnimation(mLogInButton, mSignUpButton);

        FragmentManager fragmentManager = getSupportFragmentManager();
       // Fragment fragment = fragmentManager.findFragmentById(R.id.);

    }

    private void LogIn() {
        Intent menuActivity = new Intent(this, MenuActivity.class);
        startActivity(menuActivity);
    }

    private void SignUp() {
        Intent signupActivity = new Intent(this, SignupActivity.class);
        startActivity(signupActivity);
    }

    private void slideToRightAnimation(Button a, Button b) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.lefttoright);
        a.startAnimation(animation);
        b.startAnimation(animation);
    }
}
