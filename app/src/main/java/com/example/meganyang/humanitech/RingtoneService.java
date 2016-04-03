package com.example.meganyang.humanitech;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.security.Provider;

/**
 * Created by Christian Girala on 4/2/2016.
 */
public class RingtoneService extends Service {


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStart(Intent intent) {
        Log.i("Within the RingTone", "Service is true");
        return START_NOT_STICKY;
    }
}
