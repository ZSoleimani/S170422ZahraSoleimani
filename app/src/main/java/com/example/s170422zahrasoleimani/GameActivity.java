package com.example.s170422zahrasoleimani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import java.util.Random;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private String[] words;
    private Random random;
    private String currentWord;
    private LinearLayout wordLinearLayout;
    private TextView[] charViews;
    private ImageView imageView;
    private GridView letters;
    private int currentPic, nunChars,numCorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Resources resources=getResources();
        words=resources.getStringArray(R.array.words);
        random=new Random();
        currentWord="";
        wordLinearLayout = findViewById(R.id.word);
        imageView=findViewById(R.id.imageView);

        letters=findViewById(R.id.letters);

        playGame();
    }

    //https://faradars.org/courses/fvand9901-project-oriented-android-studio-creating-word-guessing-game?fbclid=IwAR3AU75_q82Xvy4vNIAjDEwsOgPjprPNB9CbW9i5ytz9_HLQ90-W2bwkbSk
    @SuppressLint("SetTextI18n")
    private void playGame(){
        imageView.setVisibility(View.VISIBLE);
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

        Letter_Adapter letterAdapter = new Letter_Adapter(this);
        letters.setAdapter(letterAdapter);

        currentPic=0;
        nunChars=currentWord.length();
        numCorrect=0;
    }

    @SuppressLint("UseCompatLoadingForDrawables")
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
        if (correct){
            if (numCorrect==nunChars){

                Intent win = new Intent(GameActivity.this, Win.class);
                win.putExtra("getNrOfWrongGuess",currentPic+"");
                startActivity(win);
                }
            }


        else if(currentPic<6){
            imageView.setVisibility(View.VISIBLE);
            switch (currentPic) {
                case 0:
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.p1));
                    break;
                case 1:
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.p2));
                    break;
                case 2:
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.p3));
                    break;
                case 3:
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.p4));
                    break;
                case 4:
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.p5));
                    break;
                case 5:
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.p6));
                    break;
            }
            currentPic++;
        }
        else{
            Intent gameOver = new Intent(GameActivity.this, GameOver.class);
            gameOver.putExtra("getWord",currentWord);

            startActivity(gameOver);
        }
    }
}