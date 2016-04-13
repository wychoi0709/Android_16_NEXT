package com.example.naver.intentdemoa2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendBtn = (Button) findViewById(R.id.sendBtn);
        final EditText nameEdit = (EditText) findViewById(R.id.nameEdit);
        final EditText ageEdit = (EditText) findViewById(R.id.ageEdit);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IntentCallee.class);

                intent.putExtra("name", nameEdit.getText());
                intent.putExtra("age", ageEdit.getText());

                startActivity(intent);
            }
        });
    }
}
