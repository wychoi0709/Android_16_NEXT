package com.example.naver.buttonclickdemoa1;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView text;
    EditText edit;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = (EditText)findViewById(R.id.edit1);
        text = (TextView)findViewById(R.id.text1);

        button = (Button)findViewById(R.id.button1);
//        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == button.getId()) {
            text.setText(edit.getText());
        }
    }

    public void clickclickbutton(View view) {
        text.setText(edit.getText());
    }
}
