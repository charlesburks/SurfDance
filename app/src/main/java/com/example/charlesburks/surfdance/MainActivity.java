package com.example.charlesburks.surfdance;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends ActionBarActivity {

    AnimationDrawable swingAnimation, birdAnimation, sunAnimation;
    MediaPlayer startUp, birdStart, sunHello;
    int spins = 0;
    int clicks = 0;
    int birdCliks = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //dancers
        ImageView imgFrame=(ImageView)findViewById(R.id.imgSwing);
        imgFrame.setBackgroundResource(R.drawable.animation);
        swingAnimation=(AnimationDrawable) imgFrame.getBackground();
        //birds
        ImageView birdFrame=(ImageView)findViewById(R.id.imgBird);
        birdFrame.setBackgroundResource(R.drawable.birdmove);
        birdAnimation=(AnimationDrawable) birdFrame.getBackground();
        //sun
        ImageView sunFrame=(ImageView)findViewById(R.id.imgSun);
        sunFrame.setBackgroundResource(R.drawable.sunmove);
        sunAnimation=(AnimationDrawable) sunFrame.getBackground();

        startUp = new MediaPlayer();
        startUp = MediaPlayer.create(this, R.raw.surf);
        birdStart = new MediaPlayer();
        birdStart = MediaPlayer.create(this, R.raw.seagull);
        sunHello = new MediaPlayer();
        sunHello = MediaPlayer.create(this, R.raw.hellosun);

        sunFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sunAnimation.start();
                sunHello.start();
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        sunAnimation.stop();
                       // sunHello.pause();
                        //sunHello.release();

                    }
                };
                Timer opening = new Timer();
                opening.schedule(task, 1000);

                TimerTask helloTask = new TimerTask() {
                    @Override
                    public void run() {
                        //sunAnimation.stop();
                        sunHello.pause();
                        //sunHello.release();

                    }
                };
                Timer helloVoice = new Timer();
                helloVoice.schedule(helloTask, 900);


            }
        });

        imgFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (clicks){
                    case (0):
                        swingAnimation.start();
                        startUp.start();
                        clicks +=1;
                        break;
                    case (1):
                        swingAnimation.stop();
                        startUp.pause();
                        clicks = 0;
                        break;
                }

            }
        });
        birdFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        birdAnimation.start();
                        birdStart.start();
                        //birdCliks =1;


                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        //clicks =0;
                        birdAnimation.stop();
                        birdStart.pause();
                        //birdStart.release();

                    }
                };
                Timer opening = new Timer();
                opening.schedule(task, 2500);


            }
        });



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
}
