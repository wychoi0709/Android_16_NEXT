package com.example.naver.alertdialogdemoc2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final View loView = getLoginView();
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("로그인")
                        .setView(loView)
                        .setNeutralButton("닫기", new DialogInterface.OnClickListener() {
 
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText id = (EditText) loView.findViewWithTag("id");
                                EditText pw = (EditText) loView.findViewWithTag("pw");

                                Toast.makeText(MainActivity.this,
                                        "ID: " + id.getText().toString() +
                                                "\nPW: " + pw.getText().toString(),
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
    }

    private View getLoginView() {

        LinearLayout idLayout = new LinearLayout(this);
        idLayout.setOrientation(LinearLayout.HORIZONTAL);
        TextView idText = new TextView(this);
        idText.setWidth(100);
        idText.setGravity(Gravity.CENTER);
        idText.setText("ID");
        EditText idEdit = new EditText(this);
        idEdit.setTag("id");
        idEdit.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        idLayout.addView(idText);
        idLayout.addView(idEdit);

        LinearLayout pwLayout = new LinearLayout(this);
        pwLayout.setOrientation(LinearLayout.HORIZONTAL);
        TextView pwText = new TextView(this);
        pwText.setWidth(100);
        pwText.setGravity(Gravity.CENTER);
        pwText.setText("PW");
        EditText pwEdit = new EditText(this);
        pwEdit.setTag("pw");
        pwEdit.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        pwLayout.addView(pwText);
        pwLayout.addView(pwEdit);

        LinearLayout loginLayout = new LinearLayout(this);
        loginLayout.setOrientation(LinearLayout.VERTICAL);
        loginLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        loginLayout.addView(idLayout);
        loginLayout.addView(pwLayout);


        return loginLayout;
    }
}
