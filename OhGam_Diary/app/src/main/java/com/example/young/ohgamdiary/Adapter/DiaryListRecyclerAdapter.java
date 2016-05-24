package com.example.young.ohgamdiary.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.young.ohgamdiary.DiaryListActivity;
import com.example.young.ohgamdiary.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WonYoung on 16. 5. 5..
 */
public class DiaryListRecyclerAdapter extends RecyclerView.Adapter<DiaryListRecyclerAdapter.ViewHolder>{


    private static Context context;
    private List<ViewItem> item;
    private int itemLayout;

    public DiaryListRecyclerAdapter(DiaryListActivity diaryListActivity, List<ViewItem> item, int itemLayout) {
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
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        Log.d("열고 닫기 1", position + " " + item.get(position).isOpenDiary);
        //onBindView에서 아이템 정보를 여기(ViewHolder)에서 묶어줌 START
        holder.dateText.setText(item.get(position).dateText);    //date 엮음
        holder.diaryText.setText(item.get(position).diaryText);  //diary 엮음

//            Log.d("DiaryListRecyclerAdapter",item + "'s dateText: " + item.dateText);
//            Log.d("DiaryListRecyclerAdapter",item + "'s diaryText: " + item.diaryText);


        //tagText 배열을 받아다가 보여주는 코드 START
        String tagText = "";
        if(item.get(position).tags != null) { //없지 않으면
            ArrayList<String> tags = item.get(position).tags;
            for (int i = 0; i < tags.size(); i++) {
                tagText += "#" + tags.get(i) + " ";
            }
        }
        holder.tags.setText(tagText);  //tag 엮음
        //tagText 배열을 받아다가 보여주는 코드 END


        if(item.get(position).isOpenDiary) {

            holder.afterClickVisibleLayout.setVisibility(View.VISIBLE);
            holder.diaryText.setMaxLines(99999999);    //아 이거 어떻게 없애지..?
            holder.commaText.setVisibility(View.GONE);

        } else {

            holder.afterClickVisibleLayout.setVisibility(View.GONE);
            holder.diaryText.setMaxLines(14);
            holder.commaText.setVisibility(View.VISIBLE);
        }

        holder.diaryText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item.get(position).isOpenDiary) {
                    item.get(position).isOpenDiary = false;
                } else {
                    item.get(position).isOpenDiary = true;
                }

                Log.d("열고 닫기 2", position + " " + item.get(position).isOpenDiary);
                notifyItemChanged(position);

            }
        });
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView dateText;   //일기 쓴 시간
        public TextView diaryText;  //일기 내용    클릭하면 maxLines 속성을 없앨 것
        public TextView commaText;  //...텍스트    클릭하면 visiblity:gone으로
        public TextView tags;       //태그들(여러개 있을 예정)
        public RelativeLayout afterClickVisibleLayout;  //클릭하면 visible 할 레이아웃
        public boolean isOpenDiary = false; //클릭되었는지
        public Button editDiaryBtn;

        public ViewHolder(View itemView) {
            super(itemView);

            dateText = (TextView)itemView.findViewById(R.id.dateText);
            diaryText = (TextView)itemView.findViewById(R.id.diaryText);
            commaText = (TextView)itemView.findViewById(R.id.commaText);
            tags = (TextView)itemView.findViewById(R.id.tagsText);
            afterClickVisibleLayout = (RelativeLayout)itemView.findViewById(R.id.afterClickVisibleLayout);
            editDiaryBtn = (Button)itemView.findViewById(R.id.editDiaryBtn);
        }

    }

}
