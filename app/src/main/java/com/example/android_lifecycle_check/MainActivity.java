package com.example.android_lifecycle_check;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final String STATE_COUNT = "count";
    private int mCount = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            mCount = savedInstanceState.getInt(STATE_COUNT);
        }
        String text = getResources().getString(R.string.activity_count, mCount);
        TextView textView = findViewById(R.id.activity_text);
        textView.setText(text);
        textView.startAnimation(AnimationUtils.loadAnimation(this,R.anim.count_animation));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_COUNT, mCount + 1);
        super.onSaveInstanceState(outState);
    }
}
