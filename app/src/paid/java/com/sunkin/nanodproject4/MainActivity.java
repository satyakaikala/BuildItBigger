package com.sunkin.nanodproject4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.sunkin.myjokeslibrary.DisplayActivity;

import java.util.concurrent.ExecutionException;

import static com.sunkin.myjokeslibrary.DisplayActivity.JOKE_KEY;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    public ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar) findViewById(R.id.show_progress);
    }

    public void tellJoke(View view) {

        String newJoke = null;
        try {
             progressBar.setVisibility(View.VISIBLE);
            Log.d(TAG, "hiding progress");
             newJoke = new EndPointTask(this).execute(this).get();
        } catch (InterruptedException | ExecutionException e) {
            Log.e(TAG, "Exception while retrieving new joke: %s ", e);
        }

        if (newJoke != null && newJoke.length() != 0){
            displayJoke(newJoke);
        } else {
            throw new NullPointerException("Joke Not Found");
        }
    }

    void displayJoke(String joke) {
        progressBar.setVisibility(View.GONE);
        Intent jokeIntent = new Intent(this, DisplayActivity.class);
        jokeIntent.putExtra(JOKE_KEY, joke);
        startActivity(jokeIntent);

    }
}
