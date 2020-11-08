package com.example.s170422zahrasoleimani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameOver extends AppCompatActivity  implements View.OnClickListener {

    TextView wordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        Intent i = getIntent();
        String word = i.getStringExtra("word");

        wordView = findViewById(R.id.theWord);
        wordView.setText(word);
    }

    @Override
    public void onClick(View view) {
        finish();

    }

}