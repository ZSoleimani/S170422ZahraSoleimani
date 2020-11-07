package com.example.s170422zahrasoleimani;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

public class LetterAdapter extends BaseAdapter {

    private final String[] letters;
    private final LayoutInflater letterInflater;

    public LetterAdapter(Context context){
        letters=new String[26];
        for(int a=0; a<letters.length; a++){
            letters[a]=""+(char)(a+'A');
        }
        letterInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return letters.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Button letterButton;
        letterButton= (Button) letterInflater.inflate(R.layout.letter,viewGroup,false);
        letterButton.setText(letters[i]);
        return letterButton;
    }
}
