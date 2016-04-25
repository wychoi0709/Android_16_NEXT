package com.example.young.fragmentdemoa3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayListFragment list = new ArrayListFragment();//직접 만든 Fragment

        String[] numbers = new String[]{"1", "2","3","3","3","3","3","3","3","3","3"};

        Bundle bundle = new Bundle();
        bundle.putStringArray("numbers", numbers);
        list.setArguments(bundle);

        android.app.FragmentManager fm = getFragmentManager();
        android.app.FragmentTransaction ft = fm.beginTransaction();
        ft.add(android.R.id.content, list);
        ft.commit();


    }
}
