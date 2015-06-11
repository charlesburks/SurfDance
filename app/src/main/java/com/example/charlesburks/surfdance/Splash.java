package com.example.charlesburks.surfdance;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Timer;
import java.util.TimerTask;


public class Splash extends ActionBarActivity {

    MediaPlayer startUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        startUp = new MediaPlayer();
        startUp = MediaPlayer.create(this, R.raw.intro);
        startUp.start();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                // TODO Auto-generated method stub
                finish();
                startActivity(new Intent(Splash.this, MainActivity.class));
            }
        };
        Timer opening = new Timer();
        opening.schedule(task, 3000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
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
}
