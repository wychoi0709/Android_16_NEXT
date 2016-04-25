package com.example.young.fragmentdemob3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by young on 2016-04-20.
 */
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DetailsFragment details = new DetailsFragment();
        details.setArguments(getIntent().getExtras());
        getFragmentManager().beginTransaction().add(android.R.id.content, details).commit();
    }
}
