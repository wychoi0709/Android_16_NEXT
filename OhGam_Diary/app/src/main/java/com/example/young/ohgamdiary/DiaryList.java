package com.example.young.ohgamdiary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by young on 2016-04-17.
 */
public class DiaryList extends AppCompatActivity {

    Button onlyBtn;
    Button writeDiaryBtn;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diarylist);

        onlyBtn = (Button) findViewById(R.id.onlyBtn);
        writeDiaryBtn = (Button)findViewById(R.id.writeDiaryBtn);

        onlyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DiaryList.this, DiaryDetail.class);
                startActivity(intent);
            }
        });

    }
}
