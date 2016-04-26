package com.example.young.ohgamdiary;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends Activity {

    private Timer timer;
    private TimerTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //TimerTask 생성 및 Intent 생성 START
        task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), Introduction.class);
                startActivity(intent);
                finish();
            }
        };
        //TimerTask 생성 및 Intent 생성 END
        timer = new Timer();
        timer.schedule(task, 3000);

    }

    @Override
    protected void onDestroy() {
        timer.cancel();
        super.onDestroy();
    }
}
