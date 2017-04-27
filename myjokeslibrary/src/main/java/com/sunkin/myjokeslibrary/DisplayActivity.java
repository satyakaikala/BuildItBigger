package com.sunkin.myjokeslibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DisplayActivity extends AppCompatActivity {
    public static String JOKE_KEY = "Joke_key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}
