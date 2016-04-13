package com.example.naver.intentdemoc1caller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Naver on 2016-03-30.
 */
public class IntentCallee extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_callee);

        final EditText nameEdit = (EditText) findViewById(R.id.nameEdit);
        final EditText ageEdit = (EditText) findViewById(R.id.ageEdit);

        Button sendBtn = (Button)findViewById(R.id.sendBtn);

        final Intent intent = getIntent();
        nameEdit.setText(intent.getExtras().get("name").toString());
        ageEdit.setText(intent.getExtras().get("age").toString());

        final Intent sendIntent = new Intent(this, MainActivity.class);


        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendIntent.putExtra("name", nameEdit.getText());
                sendIntent.putExtra("age", ageEdit.getText());

                setResult(RESULT_OK, sendIntent);
                finish();
            }
        });
    }

}
