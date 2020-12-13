package com.example.uicustomviews;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class TitleLayout extends LinearLayout implements View.OnClickListener {

    public TitleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title,this);
        Button button1 = (Button) findViewById(R.id.title_back);
        Button button2 = (Button) findViewById(R.id.title_edit);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_back:
                ((Activity) getContext()).finish();
                break;
            case R.id.title_edit:
                Toast.makeText(getContext(),"you click Edit button ",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

    }
}