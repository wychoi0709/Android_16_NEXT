package com.wonyoung.canisit;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    private Timer timer;
    private TimerTask task;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Log.d("SplashActivity", "onCreate() START");
        context = this;

        //TimerTask 생성 및 Intent 생성 START
        task = new TimerTask() {
            @Override
            public void run() {
                Intent intent;
                intent = new Intent(context, InsertPathActivity.class);
                Log.d("SplashActivity", "Next intent: " + intent);

                startActivity(intent);
                finish();
            }
        };
        //TimerTask 생성 및 Intent 생성 END

        timer = new Timer();
        timer.schedule(task, 1000);
        Log.d("SplashActivity", "onCreate() END");
    }

    @Override
    protected void onPause() {
        Log.d("SplashActivity", "onPause() START");
        timer.cancel();
        super.onPause();
        Log.d("SplashActivity", "onPause() END");
    }

}

