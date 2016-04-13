package com.example.naver.recyclerviewdemoa1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Naver on 2016-04-04.
 */
//프린트해서 연필로 한번 볼 것

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder>{

    private final String TAG = this.getClass().toString(); //log남길때 사용

    private Context context;
    private List<ViewItem> items;
    private int itemLayout;


    public MyRecyclerAdapter(MainActivity mainActivity, List<ViewItem> item, int itemLayout) {
        this.context = mainActivity;
        this.items = item;
        this.itemLayout = itemLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.text.setText(items.get(position).getText());
        holder.image.setImageResource(items.get(position).getImgRes());

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "아이템 클릭"+position, Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(context, "아이템 롱 클릭"+position, Toast.LENGTH_LONG).show();
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView image;
        public TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.image);
            text = (TextView)itemView.findViewById(R.id.text);
        }
    }
}
