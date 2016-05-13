package com.example.young.ohgamdiary;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WonYoung on 16. 5. 5..
 */
public class DiaryListRecyclerAdapter extends RecyclerView.Adapter<DiaryListRecyclerAdapter.ViewHolder>{

    private Context context;
    private List<ViewItem> item;
    private int itemLayout;

    public DiaryListRecyclerAdapter(DiaryList diaryListActivity, List<ViewItem> item, int itemLayout) {
        this.context = diaryListActivity;
        this.item = item;
        this.itemLayout = itemLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.dateText.setText(item.get(position).dateText);
        holder.diaryText.setText(item.get(position).diaryText);
        Log.d("tag", item.get(position).diaryText);

        //tagText 배열을 받아다가 보여주는 코드 START
        String tagText = "";
        if(item.get(position).tags != null) {
            ArrayList<String> tags = item.get(position).tags;
            for (int i = 0; i < tags.size(); i++) {
                tagText += "#" + tags.get(i) + " ";
            }
        }
        holder.tags.setText(tagText);
        //tagText 배열을 받아다가 보여주는 코드 END


        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                //여기에 invisible 값을 변경해줄 것
                Toast.makeText(context, "클릭 클릭 동작 확인"+position, Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView dateText;   //일기 쓴 시간
        public TextView diaryText;  //일기 내용
        public TextView tags;       //태그들(여러개 있을 예정)

        public ViewHolder(View itemView) {
            super(itemView);

            dateText = (TextView)itemView.findViewById(R.id.dateText);
            diaryText = (TextView)itemView.findViewById(R.id.diaryText);
            tags = (TextView)itemView.findViewById(R.id.tagsText);

        }
    }


}
