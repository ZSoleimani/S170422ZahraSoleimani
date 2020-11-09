package com.example.s170422zahrasoleimani;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Win extends AppCompatActivity {
  private int getNrOfWrongGuess;
  private TextView getNrOfWrongGuessTextView;

  SharedPreferences sharedPreferences;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_win);

      getNrOfWrongGuess = getIntent().getByteExtra("getNrOfWrongGuess", (byte) 0);

      getNrOfWrongGuessTextView = findViewById(R.id.getNrOfWrongGuess);

      sharedPreferences = getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE);
      win();
  }

    @SuppressLint("SetTextI18n")
    private void win() {
      getNrOfWrongGuessTextView.setText("" +getNrOfWrongGuess);
    }

}
