package com.example.naver.facebookinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.main);

        //adapter 생성, 연결(context, 데이터, 레이아웃 담으면 알아서 연결해줌) START
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(this, createItem(), R.layout.item);
        recyclerView.setAdapter(adapter);//adapter 연결
        //adapter 생성, 연결(context, 데이터, 레이아웃 담으면 알아서 연결해줌) END

        //LayoutManager 생성 START
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //LayoutManager 생성 END

        recyclerView.setLayoutManager(linearLayoutManager);
        //ItemAnimation / Item Decoration 두 개도 적용해볼 것

        ImageButton imageButton = (ImageButton)findViewById(R.id.newsfeedBtn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private List<ViewItem> createItem() {

        List<ViewItem> items = new ArrayList<>();
        ViewItem viewItem = null;

        for(int i = 0; i < 5; i++){
            viewItem = new ViewItem();
            viewItem.otherPerson = "윤석찬";

            viewItem.writerPicture = R.drawable.hwangimg;
            viewItem.writer = "황승만";

            viewItem.time = 10;
            viewItem.location = "서울";
            viewItem.scopeOfText = R.drawable.scopepictogram;

            viewItem.content = "웃자고 만든거라 하기엔 내용이 웃기지만은 않습니다.\n충분히 참고할 만하네요.\nfrom 윤석찬";
            viewItem.link = R.drawable.linkcontent;

            viewItem.likeCount = 2;
            viewItem.commentCount = 1;

        items.add(viewItem);
        }
    return items;
    }
}

