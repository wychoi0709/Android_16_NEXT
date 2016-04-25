package com.example.young.fragmentdemob1;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by young on 2016-04-18.
 */
public class DetailFragment extends Fragment {

    public static DetailFragment newInstance(int position){
        DetailFragment df = new DetailFragment();

        Bundle args = new Bundle();
        args.putInt("position", position);
        df.setArguments(args);

        return df;
    }

    private DetailFragment(){}

    public int getPosition(){
        return getArguments().getInt("position");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.detail_view, container, false);
        TextView textView = (TextView) v.findViewById(R.id.details);
        textView.setText(BookInfo.DETAILS[getPosition()]);
        return v;
    }
}
