package com.vo.binh.pomo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class LoginActivity extends AppCompatActivity {
    private Button mLogInButton;
    private Button mSignUpButton;
    private ImageView mLogInImageView;

    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLogInButton = findViewById(R.id.login_button);
        mLogInImageView= findViewById(R.id.log_in_image);
        mSignUpButton = findViewById(R.id.signup_button);

        mEmailView = findViewById(R.id.register_email);
        mPasswordView = findViewById(R.id.register_password);


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
        fadeInAnimation(mLogInImageView);
        slideToRightAnimation(mLogInButton, mSignUpButton);


    }

    public void signInExistingUser(View v) {
        //TODO:
    }

    public void registerNewUser(View v) {
        Intent intent = new Intent(this, RegisterActivity.class);
        finish();
        startActivity(intent);
    }


    private void attemptLogin() {
        // TODO: Use FirebaseAutho to sign in with email and password
    }

    // TODO: Show error on screen with an alert dialog

    private void LogIn() {
        Intent menuActivity = new Intent(LoginActivity.this, MenuActivity.class);
        startActivity(menuActivity);
    }

    private void SignUp() {
        Intent signupActivity = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(signupActivity);
    }

    private void slideToRightAnimation(Button a, Button b) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.lefttoright);
        a.startAnimation(animation);
        b.startAnimation(animation);
    }

    private void fadeInAnimation(ImageView imageView) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        imageView.startAnimation(animation);
    }
}
