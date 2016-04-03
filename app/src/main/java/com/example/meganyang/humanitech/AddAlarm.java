package com.example.meganyang.humanitech;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.meganyang.humanitech.Model.Alarm;

import java.util.Calendar;

public class AddAlarm extends AppCompatActivity {

    private int hour;
    private int minute;
    private String name;
    private String timeOfDay;
    private Alarm alarm;
    private Context context;
    PendingIntent pendingIntent;
    Intent intent;
    AlarmManager alarmManager;
    public static final String PASSTOMAIN = "passOff";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = this;
        setContentView(R.layout.activity_add_alarm);

        // initialize alarm manager
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        // create new intent
        intent = new Intent(context,  AlarmReceiver.class);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_alarm, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void returnToMenu(View view){
        Intent returnToMenu = new Intent(AddAlarm.this, MainActivity.class);
        TimePicker time = (TimePicker) findViewById(R.id.timePicker);
        TextView daName = (TextView) findViewById(R.id.textView2);
        hour = time.getHour();
        minute = time.getMinute();
        name = daName.getText().toString();
        String total = hour + ", " + minute + ", " + name;
        SharedPreferences prefs = getSharedPreferences(PASSTOMAIN, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("theKey", total);
        editor.apply();

        // create pending intent
        pendingIntent = PendingIntent.getBroadcast(AddAlarm.this,
                0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        // set alarm manager
        alarmManager.set(AlarmManager.RTC_WAKEUP, (long)((60 * minute)
                + (60 * 60 * hour)), pendingIntent);
        startActivity(returnToMenu);
    }
}
