package com.example.s170422zahrasoleimani;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameOver extends AppCompatActivity {

    private String getWord;
    private TextView getWordTextView;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstantanceState) {
        super.onCreate(savedInstantanceState);
        setContentView(R.layout.activity_game_over);

        getWord = getIntent().getStringExtra("getWord");
        getWordTextView = findViewById(R.id.getNrOfWrongGuess);

        sharedPreferences = getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE);
        gameOver();
    }

    @SuppressLint("SetTextI18n")
    private void gameOver() {
        getWordTextView.setText(" " + getWord);
    }
}


    /*
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

     */

