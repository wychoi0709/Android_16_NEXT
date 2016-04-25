package com.example.young.fragmentdemob3;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.textservice.TextInfo;
import android.widget.TextView;

/**
 * Created by young on 2016-04-20.
 */
public class DetailsFragment extends Fragment {

    public static DetailsFragment newInstance(int position) {
        DetailsFragment df = new DetailsFragment();

        Bundle args = new Bundle();
        args.putInt("position", position);
        df.setArguments(args);

        return df;
    }

    public int getPosition() {
        return getArguments().getInt("position", 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.detail_view, container, false);

        TextView  textView = (TextView)v.findViewById(R.id.details);
        textView.setText(BookInfo.DETAILS[getPosition()]);

        return v;
    }
}
