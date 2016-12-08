package com.example.mrbennerham.calendar;

import android.os.AsyncTask;
import android.view.View;

import com.google.api.client.googleapis.extensions.android.gms.auth.GooglePlayServicesAvailabilityIOException;
import com.google.api.client.googleapis.extensions.android.gms.auth.UserRecoverableAuthIOException;

import java.io.IOException;

/**
 * Created by MR.BENNERHAM on 10/30/2016.
 */
public abstract class  CalendarAsyncTask extends AsyncTask<Void, Void, Boolean> {

    final MainActivity activity;
    final com.google.api.services.calendar.Calendar client;


    CalendarAsyncTask(MainActivity activity) {
        this.activity = activity;
        client = activity.client;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        activity.numAsyncTasks++;
    }
    @Override
    protected final Boolean doInBackground(Void... ignored) {
        try {
            doInBackground();
            return true;
        }
        catch (IOException e) {
            Utils.logAndShow(activity, MainActivity.TAG, e);
        }
        return false;
    }
    abstract protected void doInBackground() throws IOException;
}
