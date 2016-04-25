package com.example.young.fragmentdemob3;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by young on 2016-04-20.
 */
public class TitlesFragment extends ListFragment {
    boolean isDual;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_activated_1,
                BookInfo.TITLE
        ));

        View detailFrame = getActivity().findViewById(R.id.details);
        isDual = ((detailFrame != null) && (detailFrame.getVisibility() == View.VISIBLE));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        if(isDual){
            showFragment(position);
        }else{
            showActitivy(position);
        }
    }

    private void showFragment(int position) {
        DetailsFragment details = (DetailsFragment)getFragmentManager().findFragmentById(R.id.details);

        if(details == null || details.getPosition() != position){
            details = DetailsFragment.newInstance(position);

            android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.details, details);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }
    }

    private void showActitivy(int position) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), DetailActivity.class);
        intent.putExtra("position", position);
        startActivity(intent);
    }

}
