package com.example.s170422zahrasoleimani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

//https://www.youtube.com/watch?v=jXtof6OUtcE
public class WelcomeScreen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        new Handler().postDelayed(() -> {
            Intent homeIntent = new Intent(WelcomeScreen.this, Main.class);
            startActivity(homeIntent);
            finish();
        },SPLASH_TIME_OUT);
    }
}