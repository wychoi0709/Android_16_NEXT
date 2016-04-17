package com.example.young.ohgamdiary;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by young on 2016-04-17.
 */
public class SplashScreen extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_splashscreen);

        //1. 시간을 3초 정도 끌기 START
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //1. 시간을 3초 정도 끌기 END

        //2. 화면 넘기기 START
        Intent intent = new Intent(getApplicationContext(), DiaryList.class);
        startActivity(intent);
        finish();
        //2. 화면 넘기기 END

    }
}
