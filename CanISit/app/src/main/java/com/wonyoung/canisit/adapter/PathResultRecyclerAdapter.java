package com.wonyoung.canisit.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.wonyoung.canisit.ResultActivity;
import com.wonyoung.canisit.vo.PathResultItem;

import java.util.List;

/**
 * Created by WonYoung on 16. 8. 18..
 */
public class PathResultRecyclerAdapter extends RecyclerView.Adapter {
    public PathResultRecyclerAdapter(ResultActivity resultActivity, List<PathResultItem> pathResultItemList, int item_result) {
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
