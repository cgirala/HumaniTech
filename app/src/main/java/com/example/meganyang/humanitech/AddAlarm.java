package com.example.meganyang.humanitech;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class AddAlarm extends AppCompatActivity {

    private int hour;
    private int minute;
    private String name;
    private String timeOfDay;
    public static final String PASSTOMAIN = "passOff";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alarm);
        TimePicker time = (TimePicker) findViewById(R.id.timePicker);
        TextView daName = (TextView) findViewById(R.id.textView2);
        hour = time.getHour();
        minute = time.getMinute();
        name = daName.getText().toString();
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
        startActivity(returnToMenu);
    }





}
