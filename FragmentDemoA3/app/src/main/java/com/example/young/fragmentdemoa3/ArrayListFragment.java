package com.example.young.fragmentdemoa3;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by young on 2016-04-18.
 */
public class ArrayListFragment extends ListFragment{



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_activated_1,
                getListContents()
        ));
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

    private String[] getListContents() {
        return getArguments().getStringArray("numbers");
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        getListView().setItemChecked(position, true);
    }

}
