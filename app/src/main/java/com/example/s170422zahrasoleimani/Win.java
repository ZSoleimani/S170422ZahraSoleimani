package com.example.s170422zahrasoleimani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Win extends AppCompatActivity {
    private int wrongWord;
    private TextView wrongWordTextView ;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        wrongWord = getIntent().getByteExtra("wrongWord", (byte) 0);

        wrongWordTextView = findViewById(R.id.theWord);
        preferences = getSharedPreferences("preferences", Context.MODE_PRIVATE);

        win();
    }

    private void win() {
        wrongWordTextView.setText(""+wrongWord);
    }
}
