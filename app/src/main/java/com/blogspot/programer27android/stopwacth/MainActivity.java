package com.blogspot.programer27android.stopwacth;

import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView c;
    private CountDownTimer countDownTimer;
    private long timeleftmilisecond = 600000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c = (TextView) findViewById(R.id.c_text);
        startTimer();
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(timeleftmilisecond, 1000) {
            @Override
            public void onTick(long l) {
                timeleftmilisecond = l;
                try {
                    updateTimer();
                }catch (Exception e){
                }
            }
            @Override
            public void onFinish() {
            }
        }.start();

    }
    private void updateTimer() {
        int minute= (int) timeleftmilisecond / 60000;
        int second= (int) timeleftmilisecond % 60000/1000;

        String timeset;

        timeset = ""+minute;
        timeset +=":";
        if (second<10) timeset += "0";
        timeset += second;
        c.setText(timeset);
    }
    private void stopTimer() {
        countDownTimer.cancel();
    }
    public void start(View v){
        countDownTimer.cancel();    }



}

