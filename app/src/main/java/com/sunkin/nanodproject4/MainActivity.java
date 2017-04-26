package com.sunkin.nanodproject4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.Joker;

public class MainActivity extends AppCompatActivity implements EndPointTask.JokeCallBack{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tellJoke(View view) {
        Joker joke = new Joker();
        String msg = joke.getJoke();
//        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        new EndPointTask(this, this).execute(this);
    }

    @Override
    public void onReceivedJoke(String newJoke) {
        Toast.makeText(this, newJoke, Toast.LENGTH_SHORT).show();
    }
}
