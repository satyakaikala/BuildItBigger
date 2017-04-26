package com.sunkin.nanodproject4;

import android.content.Context;
import android.os.AsyncTask;


import com.example.skai0001.myapplication.backend.myApi.MyApi;

import java.util.ArrayList;

/**
 * Created by skai0001 on 4/23/17.
 */

public class EndPointTask extends AsyncTask<Context, Void, String> {
    private Context context;
    private static MyApi myApi = null;

    @Override
    protected String doInBackground(Context... contexts) {
        context = contexts[0];

        if (myApi == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("http://localhost:8080/");

            myApi = builder.build();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String strings) {
        super.onPostExecute(strings);
    }
}
