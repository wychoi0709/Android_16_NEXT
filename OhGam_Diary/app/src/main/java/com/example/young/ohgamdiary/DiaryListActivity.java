package com.example.young.ohgamdiary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.young.ohgamdiary.Adapter.DiaryListRecyclerAdapter;
import com.example.young.ohgamdiary.listener.EndlessRecyclerOnScrollListener;

import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static com.example.young.ohgamdiary.ViewItem.createItem;

/**
 * Created by young on 2016-04-17.
 */
public class DiaryListActivity extends AppCompatActivity {

    Button onlyBtn;
    Button writeDiaryBtn;
    TextView talkingText;

    public static boolean TALKING_TO_USER = true;  //이 엑티비티가 onPause() 상태가 되면 false로 바꿔준다
    public static boolean IS_WRITE_NEW_DIARY = false;


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diarylist);
        Log.d("DiaryList", "onCreate() START");

    //RecylerView 이슈 START
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.diaryListRecyclerView);
        final List<ViewItem> allDiaryList = createItem();

        //adapter 생성, 연결(context, 데이터, 레이아웃 담으면 알아서 연결해줌) START
        final DiaryListRecyclerAdapter adapter = new DiaryListRecyclerAdapter(this, allDiaryList, R.layout.diaryitem);
        recyclerView.setAdapter(adapter);//adapter 연결
        //adapter 생성, 연결(context, 데이터, 레이아웃 담으면 알아서 연결해줌) END

        //LayoutManager 생성 START
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //LayoutManager 생성 END

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener(linearLayoutManager) {

            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                List<ViewItem> moreContacts = createItem();
                int curSize = adapter.getItemCount();
                allDiaryList.addAll(moreContacts);
                adapter.notifyItemRangeInserted(curSize, allDiaryList.size() - 1);
            }
        });
        //ItemAnimation / Item Decoration 두 개도 적용해볼 것
    //RecylerView 이슈 END

        //xml 요소들 붙이기 START
        onlyBtn = (Button) findViewById(R.id.onlyBtn);
        writeDiaryBtn = (Button)findViewById(R.id.writeDiaryBtn);
        talkingText = (TextView)findViewById(R.id.talkingText);
        //xml 요소들 붙이기 END

    //talkingText를 위한 AsyncTask 실행하기 START
        //new talkingAsyncTask(talkingText).execute();
    //talkingText를 위한 AsyncTask 실행하기 END

        writeDiaryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //프레그먼트로 대체되도록 수정할 것
                //페이지가 넘어가면 상단바가 갱신되어서 보기 안좋음
                Intent intent = new Intent(DiaryListActivity.this, DiaryDetailActivity.class);
                startActivity(intent);
            }
        });

        Log.d("DiaryList", "onCreate() END");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d("DiaryList", "onPause() START");

        TALKING_TO_USER = false;    //엑티비티 종료 false로 변경

        Log.d("DiaryList", "TALKING_TO_USER: "+ TALKING_TO_USER);
        Log.d("DiaryList", "onPause() END");
    }



}
