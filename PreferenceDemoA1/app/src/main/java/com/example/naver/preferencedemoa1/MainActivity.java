package com.example.naver.preferencedemoa1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText wifi;
    EditText network;
    EditText bluetooth;
    EditText device;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wifi = (EditText)findViewById(R.id.wifi);
        network = (EditText)findViewById(R.id.network);
        bluetooth = (EditText)findViewById(R.id.bluetooth);
        device = (EditText)findViewById(R.id.device);

        Button button = (Button)findViewById(R.id.Edit);
        button.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);

        wifi.setText(new Boolean(pref.getBoolean("wifi", false)).toString());
        network.setText(pref.getString("network", "000"));
        bluetooth.setText(new Boolean(pref.getBoolean("bluetooth", false)).toString());
        device.setText(pref.getString("device",""));
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, PrefEdit.class);
        startActivity(intent);
    }
}
