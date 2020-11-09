package com.example.s170422zahrasoleimani;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Main extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(() -> {
            Intent homeIntent = new Intent(Main.this, Game.class);
            startActivity(homeIntent);
            finish();
        },SPLASH_TIME_OUT);
    }
}