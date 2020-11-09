package com.example.s170422zahrasoleimani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button gameStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gameStart = findViewById(R.id.button);
        gameStart.setOnClickListener(this);
    }

    public void onClick(View v){
        if(v == gameStart){

            Intent homeIntent = new Intent(MainActivity.this, Game.class);
            startActivity(homeIntent);
        }
    }
}