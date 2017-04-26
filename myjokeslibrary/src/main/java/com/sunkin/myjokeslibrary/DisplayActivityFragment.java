package com.sunkin.myjokeslibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.sunkin.myjokeslibrary.DisplayActivity.JOKE_KEY;


/**
 * Created by skai0001 on 4/23/17.
 */

public class DisplayActivityFragment extends Fragment {

    public DisplayActivityFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_display, container, false);
        String joke = getActivity().getIntent().getStringExtra(JOKE_KEY);
        if (joke != null && joke.length() != 0) {
            TextView jokeTextView = (TextView) rootView.findViewById(R.id.joke_text_view);
            jokeTextView.setText(joke);
        }
        return rootView;
    }
}
