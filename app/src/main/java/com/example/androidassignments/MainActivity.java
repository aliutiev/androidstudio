package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button startButton;

    protected static final String ACTIVITY_NAME = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(ACTIVITY_NAME, "In onCreate()");

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int requestCode = 10;
                Intent intent = new Intent(MainActivity.this, ListItemsActivity.class);
                startActivityForResult(intent, requestCode);
                onActivityResult(requestCode, intent);
            }
        });

        startButton = (Button) findViewById(R.id.chatButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(ACTIVITY_NAME,"User clicked Start Chat");
                Intent intent = new Intent(MainActivity.this, ChatWindow.class);
                startActivity(intent);
            }
        });
    }

    public void onActivityResult(int requestCode, Intent data){
        if(requestCode == 10){
            Log.i(ACTIVITY_NAME, "Returned to MainActivity.onActivityResult");
        }
    }

    protected void onResume(){
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");

    }

    protected void onStart(){
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");

    }

    protected void onPause(){
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");

    }
    protected void onStop(){
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");

    }
    protected void onDestroy(){
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");

    }
}