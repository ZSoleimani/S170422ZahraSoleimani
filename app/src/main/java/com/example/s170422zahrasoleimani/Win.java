package com.example.s170422zahrasoleimani;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Win extends AppCompatActivity implements View.OnClickListener {
    TextView wordView, list;

    SharedPreferences preferences;
    Set<String> highscore = new HashSet<>();
    ListView listView;
    ArrayAdapter adapter;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        Intent intent = getIntent();
        String word = intent.getStringExtra("word");

        wordView = findViewById(R.id.theWord);
        list = findViewById(R.id.list);
        highscore = findViewById(R.id.highscores);

        wordView.setText(word);
        list.setText(word);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        highscore = preferences.getStringSet("highscors "+word, highscore);
        List<String> list=new ArrayList<>(highscore);

        adapter =new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1);
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        fileList();

    }
}
