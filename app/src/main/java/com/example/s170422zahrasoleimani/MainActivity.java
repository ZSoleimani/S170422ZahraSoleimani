package com.example.s170422zahrasoleimani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private String[] words;
    private Random random;
    private String currentWord;
    private LinearLayout wordLinearLayout;
    private TextView[] charViews;
    private ImageView imageView;

    private GridView letters;
    private LetterAdapter letterAdapter;

    private int currentPic;
    private int nunChars;
    private int numCorrect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources resources=getResources();
        words=resources.getStringArray(R.array.words);
        random=new Random();
        currentWord="";
        wordLinearLayout = findViewById(R.id.word);
        imageView=findViewById(R.id.imageView);

        letters=findViewById(R.id.letters);

        playGame();
    }

    private void playGame(){
        imageView.setVisibility(View.INVISIBLE);
        String newWord=words[random.nextInt(words.length)];

        while (newWord.equals(currentWord))
            newWord=words[random.nextInt(words.length)];
        currentWord=newWord;

        charViews =new TextView[currentWord.length()];
        wordLinearLayout.removeAllViews();

        for(int c=0;c<currentWord.length();c++){
            charViews[c]=new TextView(this);
            charViews[c].setText(""+currentWord.charAt(c));
            charViews[c].setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            charViews[c].setGravity(Gravity.CENTER);
            charViews[c].setTextColor(Color.WHITE);
            charViews[c].setBackgroundResource(R.drawable.dash);
            wordLinearLayout.addView(charViews[c]);
        }

        letterAdapter=new LetterAdapter(this);
        letters.setAdapter(letterAdapter);

        currentPic=0;
        nunChars=currentWord.length();
        numCorrect=0;

    }

    public void letterPressed(View view){
        String letter=((TextView)view).getText().toString();
        char letterChar=letter.charAt(0);
        view.setEnabled(false);
        view.setBackgroundResource(R.drawable.letter_down);
        boolean correct=false;
        for (int k=0; k<currentWord.length();k++){
            if (currentWord.charAt(k)==letterChar){
                correct=true;
                numCorrect++;
                charViews[k].setTextColor(Color.BLACK);
            }
        }

    }
}