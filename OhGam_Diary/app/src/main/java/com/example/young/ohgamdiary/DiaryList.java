package com.example.young.ohgamdiary;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by young on 2016-04-17.
 */
public class DiaryList extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diarylist);

        Button button = (Button)findViewById(R.id.button1);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DiaryList.this,"가나다라",Toast.LENGTH_LONG).show();
            }
        });
    }
}
