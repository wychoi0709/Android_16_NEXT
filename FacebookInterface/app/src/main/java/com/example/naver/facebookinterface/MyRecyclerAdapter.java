package com.example.naver.facebookinterface;

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
 * Created by Naver on 2016-04-10.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder>{

    private Context context;
    private List<ViewItem> item;
    private int itemLayout;

    public MyRecyclerAdapter(MainActivity mainActivity, List<ViewItem> item, int itemLayout) {
        this.context = mainActivity;
        this.item = item;
        this.itemLayout = itemLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout,parent,false);//inflater에 대해서 잘 안들어옴.. 다시 공부할 것
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.otherPerson.setText(item.get(position).getOtherPerson());

        holder.writerPicture.setImageResource(item.get(position).getWriterPicture());
        holder.writer.setText(item.get(position).getWriter());

        holder.time.setText(String.valueOf(item.get(position).getTime()));
        holder.location.setText(item.get(position).getLocation());
        holder.scopeOfText.setImageResource(item.get(position).getScopeOfText());

        holder.content.setText(item.get(position).getContent());
        holder.link.setImageResource(item.get(position).getLink());

        holder.likeCount.setText(String.valueOf(item.get(position).getLikeCount()));
        holder.commentCount.setText(String.valueOf(item.get(position).getCommentCount()));

        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(context, "어딜 클릭한 걸까?"+position, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView otherPerson; //언급된 사람, 좋아한 사람 등등

        public ImageView writerPicture;  //글쓴이 사진
        public TextView writer;      //글쓴이 이름

        public TextView time;       //글쓴 시간
        public TextView location;   //장소
        public ImageView scopeOfText;    //공개범위

        public TextView content;    //내용
        public ImageView link;           //링크사진

        public TextView likeCount;      //좋아요 수
        public TextView commentCount;   //댓글 수

        public ViewHolder(View itemView) {
            super(itemView);
            otherPerson = (TextView)itemView.findViewById(R.id.additionalName);

            writerPicture = (ImageView)itemView.findViewById(R.id.picOfWriter);
            writer = (TextView)itemView.findViewById(R.id.nameOfWriter);

            time = (TextView)itemView.findViewById(R.id.timeOfWrite);
            location = (TextView)itemView.findViewById(R.id.locationOfWrite);
            scopeOfText = (ImageView)itemView.findViewById(R.id.scopeOfText);

            content = (TextView)itemView.findViewById(R.id.mainContent);
            link = (ImageView)itemView.findViewById(R.id.linkContent);

            likeCount = (TextView)itemView.findViewById(R.id.likeNumber);
            commentCount = (TextView)itemView.findViewById(R.id.commentNumber);
        }
    }
}

