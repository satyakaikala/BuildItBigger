package com.sunkin.nanodproject4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.Joker;
import com.sunkin.myjokeslibrary.DisplayActivity;

import java.util.concurrent.ExecutionException;

import static com.sunkin.myjokeslibrary.DisplayActivity.JOKE_KEY;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tellJoke(View view) {
        String newJoke = " ";
        try {
             newJoke = new EndPointTask(this).execute(this).get();
        } catch (InterruptedException | ExecutionException e) {
            Log.e(MainActivity.class.getSimpleName(), "Exception while retrieving new joke: %s ", e);
        }

        if (newJoke != null && newJoke.length() != 0){
            displayJoke(newJoke);
        }
    }

    void displayJoke(String joke) {
        Intent jokeIntent = new Intent(this, DisplayActivity.class);
        jokeIntent.putExtra(JOKE_KEY, joke);
        startActivity(jokeIntent);
    }
}
