package com.example.meganyang.humanitech;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Christian Girala on 4/2/2016.
 */
public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("in the receiver", "true");

        // create an intent to the ringtone service
        Intent serviceIntent = new Intent(context, RingtoneService.class);

        // start ringtone service
        context.startService(serviceIntent);
    }
}
