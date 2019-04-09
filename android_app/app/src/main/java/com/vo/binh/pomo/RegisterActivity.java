package com.vo.binh.pomo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    //Constants


    // UI references
    private ImageView mImageView;
    private AutoCompleteTextView mUserNameView;
    private AutoCompleteTextView mEmailView;
    private EditText mPassWordView;
    private EditText mComfirmPasswordView;
    private Button mSignUpButtonView;
    FirebaseAuth.AuthStateListener mAuthStateListener;

    // Firebase reference variable
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Linking UI refrences to resource
        mUserNameView = (AutoCompleteTextView) findViewById(R.id.register_username);
        mEmailView = (AutoCompleteTextView) findViewById(R.id.register_email);
        mPassWordView = (EditText) findViewById(R.id.register_password);
        mComfirmPasswordView = (EditText) findViewById(R.id.register_confirm_password);
        mSignUpButtonView = (Button) findViewById(R.id.register_btn);

        // Get an instance of FirebaseAuth
        mAuth = FirebaseAuth.getInstance();

        mComfirmPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == 200 || actionId == EditorInfo.IME_NULL) {
                    attemptRegistration();
                    return true;
                }
                return false;
            }
        });

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    Intent intent = new Intent(RegisterActivity.this, MenuActivity.class);
                    startActivity(intent);
                }
            }
        };
        mAuth.addAuthStateListener(mAuthStateListener);

        mSignUpButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptRegistration();
            }
        });

        mImageView = findViewById(R.id.sign_up_image);

        Glide.with(this).load(R.drawable.pomodoro_run).into(mImageView);
    }

    public void signUp(){attemptRegistration();}

    private void attemptRegistration() {
        mEmailView.setError(null);
        mPassWordView.setError(null);

        String email = mEmailView.getText().toString();
        String password = mPassWordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for valid password if the user entered one
        if(TextUtils.isEmpty(password) || !isPasswordValid(password)) {
            mPassWordView.setError("Password is too short or does not match");
            focusView = mPassWordView;
            cancel = true;
        }

        // Check if email is valid
        if(TextUtils.isEmpty(email) || !isEmailValid(email)) {
            mEmailView.setError("requires @");
            focusView = mEmailView;
            cancel = true;
        }

        if(cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            createFirebaseUser();
        }
    }

    private boolean isEmailValid(String email) {
        // TODO: Add more checking logic here
        return email.contains("a");
    }

    private boolean isPasswordValid(String password) {
        String confirmPassword = mComfirmPasswordView.getText().toString();
        return confirmPassword.equals(password) && password.length() > 4;

        // TODO: Add logic for password check
    }

    // TODO: Create a Firebase user
    private void createFirebaseUser() {
        String email = mEmailView.getText().toString();
        String password = mPassWordView.getText().toString();
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d("CreatingUser", "createUser onComplete:" + task.isSuccessful());

                if(!task.isSuccessful()) {
                    Log.d("CreatingUser", "createUser onComplete:" + task.isSuccessful());
                    showErrorDialog("Registration attempt failed");
                }
            }
        });
    }


    // TODO: Save the display name(username) to Shared Preferences


    // TODO: Create an alert dialog to show in case registration failed
    private void showErrorDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Error")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

}
