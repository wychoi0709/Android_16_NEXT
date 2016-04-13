package com.example.naver.intentdemoa2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Naver on 2016-03-30.
 */
public class IntentCallee extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intentcallee);

        TextView nameText = (TextView)findViewById(R.id.nameText);
        TextView ageText = (TextView)findViewById(R.id.ageText);
        Button closeBtn = (Button)findViewById(R.id.closeBtn);

        Intent intent = getIntent();
        nameText.setText(intent.getExtras().get("name").toString());
        ageText.setText(intent.getExtras().get("age").toString());

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
