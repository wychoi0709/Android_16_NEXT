package com.example.young.fragmentdemoa4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OnFragmentChangeInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayListFragment list = new ArrayListFragment();//직접 만든 Fragment

        android.app.FragmentManager fm = getFragmentManager();
        android.app.FragmentTransaction ft = fm.beginTransaction();
        ft.add(android.R.id.content, list);
        ft.commit();
    }

    @Override
    public void setChangsOfFragment(String number) {
        setTitle(getTitle() + " " + number);

    }
}
