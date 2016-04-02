package com.example.meganyang.humanitech;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    SharedPreferences example;
    public static final String PASSTOMAIN = "passOff";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        popoulateView();
    }

    private void popoulateView() {

        // Create list of
        example = getSharedPreferences(PASSTOMAIN, 0);
        String userString = example.getString("theKey", "Nothing");
        String[] arr = userString.split(", ");
        String str = new String("");
        for (String string: arr) {
            str += string;
        }
        /*
        String name = arr[0];
        String hour = arr[1];
        String minute = arr[2];
        */
        TextView see = (TextView) findViewById(R.id.textView);
        see.setText(str);
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



    /*
    public void micahButton(View view) {
        Button wButton = (Button)findViewById(R.id.wButton);
        wButton.setText("Micah's Button");
    } */
}
