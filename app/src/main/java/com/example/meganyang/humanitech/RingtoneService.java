package com.example.meganyang.humanitech;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Christian Girala on 4/2/2016.
 */
public class RingtoneService extends Service {

    MediaPlayer song;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("LocalService", "Received start id " + startId + ": " + intent);

        song = MediaPlayer.create(this, R.raw.dancin_krono_remix);
        song.start();

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        // Tell the user we stopped.
        Toast.makeText(this, "onDestroy called", Toast.LENGTH_SHORT).show();
    }

}
