package com.example.naver.toastdemob2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.toastBtn);
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        LinearLayout layoutLL = (LinearLayout)getLayoutInflater().inflate(R.layout.toastlayout, null);

        Toast toast = Toast.makeText(this, "Toast~!~!", Toast.LENGTH_SHORT);
        toast.setView(layoutLL);
        toast.show();
    }
}
