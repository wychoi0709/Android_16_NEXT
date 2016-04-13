package com.example.naver.alertdialogdemoc1;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.loginButton);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        showAlertDialog();
    }

    private void showAlertDialog() {
        LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout loginLayout = (LinearLayout)vi.inflate(R.layout.logindialog, null);

        final EditText id = (EditText)loginLayout.findViewById(R.id.id);
        final EditText pw = (EditText)loginLayout.findViewById(R.id.pw);

        new AlertDialog.Builder(this)
               .setTitle("로그인")
                .setView(loginLayout)
                .setNeutralButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,
                                "ID: " + id.getText().toString()+
                                        "\nPW: " + pw.getText().toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                }).show();

    }
}
