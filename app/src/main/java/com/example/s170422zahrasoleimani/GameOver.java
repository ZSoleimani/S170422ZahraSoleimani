package com.example.s170422zahrasoleimani;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class GameOver extends AppCompatActivity {

    private TextView getWordTextView;

    @Override
    protected void onCreate(Bundle savedInstantanceState) {
        super.onCreate(savedInstantanceState);
        setContentView(R.layout.activity_game_over);

        getWordTextView = findViewById(R.id.get_word_id);

        Bundle bundle = getIntent().getExtras();
        String data = bundle.getString("getWord");
        getWordTextView.setText(data);

    }
}


