package com.example.young.fragmentdemoa2;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by young on 2016-04-18.
 */
public class ArrayListFragment extends ListFragment{

    private static String[] NUMBERS = new String[]{"1", "2","3","3","3","3","3","3","3","3","3"};

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_activated_1,
                NUMBERS
        ));
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        getListView().setItemChecked(position, true);
    }
}
