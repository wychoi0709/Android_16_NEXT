package com.example.naver.intentdemoc1caller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button inputBtn = (Button) findViewById(R.id.inputBtn);

        final Intent intent = new Intent(this, IntentCallee.class);

        final TextView nameText = (TextView)findViewById(R.id.nameText);
        final TextView ageText = (TextView)findViewById(R.id.ageText);



        inputBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("name", nameText.getText());
                intent.putExtra("age", ageText.getText());

                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        TextView nameText = (TextView)findViewById(R.id.nameText);
        TextView ageText = (TextView)findViewById(R.id.ageText);

        if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_OK){
                nameText.setText(data.getExtras().get("name").toString());
                ageText.setText(data.getExtras().get("age").toString());
            }
        }

    }
}
