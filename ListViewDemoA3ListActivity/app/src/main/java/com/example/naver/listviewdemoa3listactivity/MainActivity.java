package com.example.naver.listviewdemoa3listactivity;

import android.app.Activity;
import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends ListActivity {

    private String[] cars = {"1111", "AfFAF", "E4MFJ","EFJ","ejfk2lw", "AFAF", "EwMFJ","EFJ","easel"};
    private TextView selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setListAdapter(new NewArrayAdapter(this));

        selected = (TextView)findViewById(R.id.selected);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        selected.setText(cars[position]);
    }

    public class NewArrayAdapter extends ArrayAdapter {
        Activity context;

        @SuppressWarnings("unchecked")
        public NewArrayAdapter(Activity context) {
            super(context, R.layout.list_row, cars);
            this.context = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater =   context.getLayoutInflater();

            View row = inflater.inflate(R.layout.list_row, null);
            TextView textView = (TextView)row.findViewById(R.id.label);
            textView.setText(cars[position]);

            if(cars[position].equals("SONATA")){
                ImageView imageView = (ImageView)row.findViewById(R.id.icon);
                imageView.setImageResource(R.drawable.sonata);
            }

            return row;
        }
    }
}
