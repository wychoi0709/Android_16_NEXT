package com.example.young.fragmentdemob1;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by young on 2016-04-18.
 */
public class TitleFragment extends ListFragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_activated_1,
                BookInfo.TITLE));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        DetailFragment detail = (DetailFragment) getFragmentManager().findFragmentById(R.id.details);

        if(detail == null || detail.getPosition() != position){
            detail = DetailFragment.newInstance(position);
            android.app.FragmentTransaction ft  = getFragmentManager().beginTransaction();
            ft.replace(R.id.details, detail);
            ft.commit();
        }


    }
}
