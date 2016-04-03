package com.example.meganyang.humanitech;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    SharedPreferences example;
    public static final String PASSTOMAIN = "passOff";
    private ArrayAdapter<String> adapter;
    private ArrayList<String> ourList = new ArrayList<>();
    int counter = 0;
    private ArrayList<String> quotes;
    private Random rand;
    PendingIntent pendingIntent;
    Intent intent;
    AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        popoulateView();

    }

    private void popoulateView() {
        // Create list of
        example = getSharedPreferences(PASSTOMAIN, 0);
        String userString = example.getString("theKey", "Nothing");
        String[] arr = userString.split(",");
        for (String string: arr) {
            ourList.add(string);
        }

        // Initialize adapter
        adapter = new ArrayAdapterItem<>(this, R.layout.alarm_list_detail);

        // configure listview
        ListView list = (ListView) findViewById(R.id.alarmList);
        list.setAdapter(adapter);
        //TextView see = (TextView) findViewById(R.id.textView);
        //see.setText(str);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void addAlarm(View view) {
        Intent addAlarm = new Intent(MainActivity.this, AddAlarm.class);
        startActivity(addAlarm);
        finish();
    }

    /**
     * Adapter for list alarms
     */
    public class ArrayAdapterItem<E> extends ArrayAdapter<E> {

        Context mContext;
        int itemCount = 0;

        public ArrayAdapterItem(Context mContext, int layoutResourceId) {

            super(mContext, layoutResourceId);
            this.mContext = mContext;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                // inflate the item
                LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
                convertView = inflater.inflate(R.layout.alarm_list_detail, parent, false);
                int localCounter = counter + 3;
                String[] time = new String[2];
                String name = null;

                // initialize alarm manager
                alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

                // create new intent
                intent = new Intent(mContext,  AlarmReceiver.class);

                for (int i = counter; i < localCounter; i++) {
                    //Log.i("data", ourList.get(i));
                    if (localCounter - i == 3) {
                        time[0] = ourList.get(i);
                    } else if (localCounter - i == 2) {
                        time[1] = ourList.get(i);
                    } else if (localCounter - i == 1) {
                        name = ourList.get(i);
                    }

                }

                // create pending intent
                pendingIntent = PendingIntent.getBroadcast(MainActivity.this,
                        0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                // set alarm manager
                alarmManager.set(AlarmManager.RTC_WAKEUP, (long)((60 * Integer.parseInt(time[1].trim()))
                        + (60 * 60 * Integer.parseInt(time[0].trim()))), pendingIntent);


                TextView tvName = (TextView) convertView.findViewById(R.id.alarmName);
                tvName.setText(name);
                TextView tvTime = (TextView) convertView.findViewById(R.id.time);
                tvTime.setText(time[0]);
                //Switch isOn = (Switch) findViewById(R.id.btnOnOff);
            }

            return convertView;
        }

        @Override
        public int getCount() {
            return ourList.size() / 3;
        }
    }
    /*
    public void micahButton(View view) {
        Button wButton = (Button)findViewById(R.id.wButton);
        wButton.setText("Micah's Button");
    } */

// to generate random quotes- to add more
    private void populateQuotes() {
            quotes.add("Start by doing what's necessary; then do what's possible; and suddenly you are doing the impossible." +
                    "\n" + "- Francis of Assisi");
            quotes.add("Believe you can and you're halfway there." +
                "\n" + "- Theodore Roosevelt");
            quotes.add("Start by doing what's necessary; then do what's possible; and suddenly you are doing the impossible." +
                "\n" + "- Francis of Assisi");
            quotes.add("It does not matter how slowly you go as long as you do not stop." +
                "\n" + "- Confucius");
            quotes.add("Our greatest weakness lies in giving up. The most certain way to succeed is always to try just one more time." +
                "\n" + "- Thomas A. Edison");
    }

    private String getRandQuote() {
        return quotes.get(rand.nextInt(5));
    }
}
