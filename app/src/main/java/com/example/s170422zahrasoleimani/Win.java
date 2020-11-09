package com.example.s170422zahrasoleimani;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Win extends AppCompatActivity {


    private TextView getNrOfWrongGuessTextView;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);


        getNrOfWrongGuessTextView = findViewById(R.id.nrOfWrongGuessid);
        Bundle bundle = getIntent().getExtras();

        String data = bundle.getString("getNrOfWrongGuess");
        getNrOfWrongGuessTextView.setText("Number of wrong guess: "+data + " Words");


        /* getNrOfWrongGuess = getIntent().getByteExtra("AntalForkerteBogstaver", (byte) 0);   */

        sharedPreferences = getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE);
    }



}
