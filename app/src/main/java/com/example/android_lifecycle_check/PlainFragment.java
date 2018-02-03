package com.example.android_lifecycle_check;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PlainFragment extends Fragment {

    static final String STATE_COUNT = "count";
    private int mCount = 1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            mCount = savedInstanceState.getInt(STATE_COUNT);
        }
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plain, container, false);

        String text = getResources().getString(R.string.fragment_count, mCount);
        TextView textView = view.findViewById(R.id.fragment_text);
        textView.setText(text);

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_COUNT, mCount + 1);
        super.onSaveInstanceState(outState);
    }
}
