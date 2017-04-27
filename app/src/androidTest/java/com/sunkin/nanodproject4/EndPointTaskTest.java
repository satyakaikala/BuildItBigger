package com.sunkin.nanodproject4;

import android.content.Context;
import android.support.test.runner.AndroidJUnit4;
import android.text.TextUtils;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

/**
 * Created by skai0001 on 4/26/17.
 */

@RunWith(AndroidJUnit4.class)
public class EndPointTaskTest {
    EndPointTask endPointTask;
    Context context;

    @Before
    public void setUp() throws Exception {

        endPointTask = new EndPointTask(context);
        endPointTask.context = context;
    }

    @Test
    public void testDoInBackgroud() {
        String jokeResult = null;

        try {
            jokeResult = endPointTask.execute(context).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        Log.i("EndPointTaskTest", jokeResult);
        assertNotNull("Joke Not Found", jokeResult);
        assertFalse(TextUtils.isEmpty(jokeResult));
    }
}