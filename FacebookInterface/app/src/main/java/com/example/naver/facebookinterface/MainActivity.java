package com.example.naver.facebookinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
    }

    private List<ViewItem> createItem() {

        List<ViewItem> items = new ArrayList<>();

        String otherPerson; //언급된 사람, 좋아한 사람 등등

        int writerPicture;  //글쓴이 사진
        String writer;      //글쓴이 이름

        int time;       //글쓴 시간
        String location;   //장소
        int scopeOfText;    //공개범위

        String content;    //내용
        int link;           //링크사진

        int likeCount;      //좋아요 수
        int commentCount;   //댓글 수

        for(int i = 0; i < 5; i++){
            otherPerson = "윤석찬";

            writerPicture = R.drawable.hwangimg;
            writer = "황승만";

            time = 10;
            location = "서울";
            scopeOfText = R.drawable.scopepictogram;

            content = "웃자고 만든거라 하기엔 내용이 웃기지만은 않습니다.\n충분히 참고할 만하네요.\nfrom 윤석찬";
            link = R.drawable.linkcontent;

            likeCount = 2;
            commentCount = 1;

        items.add(new ViewItem(otherPerson, writerPicture, writer, time,
                location, scopeOfText, content, link, likeCount, commentCount));
        }
    return items;
    }
}

