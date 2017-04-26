package com.sunkin.nanodproject4;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.example.skai0001.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by skai0001 on 4/23/17.
 */

public class EndPointTask extends AsyncTask<Context, Void, String> {
    protected Context context;
    private static MyApi myApi = null;

    public EndPointTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Context... contexts) {
        context = contexts[0];

        if (myApi == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });

            myApi = builder.build();
        }
        try {
            return myApi.sayHi().execute().getData();
        } catch (IOException e) {
            Log.d("Exception", "Error while getting joke");
        }
        return null;
    }

    @Override
    protected void onPostExecute(String strings) {
        super.onPostExecute(strings);
        Log.d("joke" , " : " + strings);
    }
}
