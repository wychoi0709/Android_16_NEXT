package com.wonyoung.canisit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by WonYoung on 16. 8. 15..
 */
public class InsertPathActivity extends AppCompatActivity{

    @BindView(R.id.departureEdit)
    EditText departureEdit;
    @BindView(R.id.destinationEdit)
    EditText destinationEdit;
    @BindView(R.id.searchingRecyclerView)
    RecyclerView searchingRecyclerView;
    Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_path);
        ButterKnife.bind(this);

        context = InsertPathActivity.this;
    }

    @OnClick(R.id.departureSearchBtn)
    public void onDepartureSearchClick(){

    }

    @OnClick(R.id.destinationSearchBtn)
    public void onDestinationSearchClick(){

    }

    @OnClick(R.id.resultBtn)
    public void onResultClick(){
        Log.d("InsertPathActivity", "onResultClick() START");
        Intent intent = new Intent(context, ResultActivity.class);
        startActivity(intent);
        Log.d("InsertPathActivity", "onResultClick() END");
    }
}
