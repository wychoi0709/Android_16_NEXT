package com.example.naver.asynctaskdemoa1;

import android.os.AsyncTask;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button countBtn;
    Button toastBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        countBtn = (Button) findViewById(R.id.countBtn);
        toastBtn = (Button) findViewById(R.id.toastBtn);

        countBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CountAsyncTask().execute();
            }
        });

        toastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "버튼이 클릭되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private class CountAsyncTask extends AsyncTask<String, Integer, Long>{

        @Override
        protected Long doInBackground(String... params) {
            long result = 0;//이게 무슨 의미지?
            for (int i = 0; i <= 100; i++) {
                try {
                    publishProgress(i);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return result;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            textView.setText("" + values[0]);
        }

        @Override
        protected void onPreExecute() {
            textView.setText("시작");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void onPostExecute(Long aLong) {
            textView.setText("종료");
        }
    }
}
