package com.example.naver.recyclerviewdemoa1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.LinearLayoutManager.HORIZONTAL;
import static android.support.v7.widget.LinearLayoutManager.VERTICAL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        MyRecyclerAdapter adapter = new MyRecyclerAdapter(this, createItem(), R.layout.item);
        recyclerView.setAdapter(adapter);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(HORIZONTAL);

//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,4);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
//
//    private List<ViewItem> createItem() {
//        List<ViewItem> items = new ArrayList<ViewItem>();
//        for(int i = 0; i< 20; i++){
//            items.add(new ViewItem("아이템"+i, R.mipmap.ic_launcher));
//        }
//        return items;
//    }


    //staggered를 위한 createItem 시작
    private List<ViewItem> createItem() {
        int imgRes;
        List<ViewItem> items = new ArrayList<>();
        for(int i = 0; i< 20; i++){
            if(i % 2 == 0){
                imgRes = R.drawable.noun_248850_cc;
            }else{
                imgRes = R.drawable.noun_25152_cc;
            }
            items.add(new ViewItem("아이템"+i, imgRes));
        }
        return items;
    }
    //staggered를 위한 createItem 종료

}