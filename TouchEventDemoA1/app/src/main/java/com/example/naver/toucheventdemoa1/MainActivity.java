package com.example.naver.toucheventdemoa1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyView myView = new MyView(this);
        myView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    Log.d("tag", "onCreate()안에 있는 내부클래스");
                    return false;
                }
                return true;
            }
        });
        setContentView(myView);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            Log.d("tag", "onTouchEvent 안에 놓음");
            return  false;
        }
        return true;
    }

    class MyView extends View{
        public MyView(Context context) {
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {

            if(event.getAction() == MotionEvent.ACTION_DOWN){
                Log.d("tag", "MyView에서 찍힘");
                return false;
            }

            return true;
        }
    }
}

