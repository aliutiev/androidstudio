package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    protected static final String ACTIVITY_NAME = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(ACTIVITY_NAME, "In onCreate()");
        setContentView(R.layout.activity_login);

        //save initial value
        SharedPreferences userDetails = getSharedPreferences("LoginActivity", MODE_PRIVATE);
        SharedPreferences.Editor edit = userDetails.edit();
        edit.putString( "DefaultEmail", "email@domain.com");

        edit.commit();

        // set initial text
        EditText loginName= findViewById(R.id.login_name);
        loginName.setText("email@domain.com");

//        final Button button = findViewById(R.id.button_id);
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Log.i(ACTIVITY_NAME, "LOGIN WORKS");
//            }
//        });

    }

    public void storeEmail(View view){

        //parsing text
        EditText rawEmail = findViewById(R.id.login_name);
        String emailValue = rawEmail.getText().toString();

        EditText rawPassword = findViewById(R.id.password);
        String passwordValue = rawPassword.getText().toString();

        // error handling
        if(emailValue.isEmpty() || emailValue.trim() == ""){
            return;
        } else if(!Patterns.EMAIL_ADDRESS.matcher(emailValue).matches()){
            return;
        } else if (passwordValue.isEmpty() || passwordValue.trim() == "") {
            return;
        }

        SharedPreferences userDetails = getSharedPreferences("LoginActivity", MODE_PRIVATE);
        SharedPreferences.Editor edit = userDetails.edit();

        //storing preference
        edit.putString("DefaultEmail", emailValue );
        edit.commit();

//        Log.i(ACTIVITY_NAME, userDetails.getString("DefaultEmail", "email@domain.com"));

        // Start Next Activity
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);

    }

    protected void onResume(){
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume() LOGIN");

    }

    protected void onStart(){
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart() LOGIN");

    }

    protected void onPause(){
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause() LOGIN");

    }
    protected void onStop(){
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop() LOGIN");

    }
    protected void onDestroy(){
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy() LOGIN");

    }
}