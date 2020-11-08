package com.example.s170422zahrasoleimani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartGame extends AppCompatActivity implements View.OnClickListener{

    Button gameStart;
    TextView playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);
        gameStart = findViewById(R.id.button);
        gameStart.setOnClickListener((View.OnClickListener) this);
        playerName = findViewById(R.id.gameName);
    }

    public void onClick(View v){
        if(v == gameStart){
            String n = playerName.getText().toString();
            System.out.println(n);
            Intent intent = new Intent(this, GameActivity.class);
            intent.putExtra("playersName", n);
            if(n.length() > 0){
                this.startActivity(intent);
            }else{
                playerName.setHint("Write Your Name");
            }
        }
    }
}