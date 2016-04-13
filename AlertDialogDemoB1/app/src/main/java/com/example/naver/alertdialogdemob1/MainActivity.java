package com.example.naver.alertdialogdemob1;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button itemBtn = (Button) findViewById(R.id.itemBtn);
        Button singleBtn = (Button)findViewById(R.id.singleItemBtn);
        Button mulBtn = (Button) findViewById(R.id.multiItemBtn);
        singleBtn.setOnClickListener(this);
        mulBtn.setOnClickListener(this);
        itemBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final String[] items = {"차1", "차2", "차3", "차4", "차5"};

        if(v.getId() == R.id.itemBtn){


            new AlertDialog.Builder(this)
                    .setItems(items, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "선택됨", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNeutralButton("닫기", null)
                    .show();

        }else if(v.getId() == R.id.singleItemBtn){
            new AlertDialog.Builder(this)
                    .setSingleChoiceItems(items,2,new DialogInterface.OnClickListener(){

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, items[which], Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNeutralButton("닫기",null)
                    .show();
        }else{
            new AlertDialog.Builder(this)

                    .setMultiChoiceItems(items,null, new DialogInterface.OnMultiChoiceClickListener()
            {

                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                        }
                    })

                    .setNeutralButton("닫기", new DialogInterface.OnClickListener() {
                        //선택되었을때, 배열에 넣어놨다가 꺼내서 돌릴 것
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .show();
        }
    }
}
