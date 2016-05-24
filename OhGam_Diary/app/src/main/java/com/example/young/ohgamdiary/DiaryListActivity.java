package com.example.young.ohgamdiary;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.young.ohgamdiary.adapter.DiaryListRecyclerAdapter;
import com.example.young.ohgamdiary.adapter.ViewItem;
import com.example.young.ohgamdiary.asynctask.talkingAsyncTask;
import com.example.young.ohgamdiary.dao.DatabaseHandler;
import com.example.young.ohgamdiary.listener.EndlessRecyclerOnScrollListener;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


/**
 * Created by young on 2016-04-17.
 */
public class DiaryListActivity extends AppCompatActivity {

    Context context;
    TextView talkingText;
    List<ViewItem> allDiaryList = null;
    public static boolean TALKING_TO_USER = true;  //이 엑티비티가 onPause() 상태가 되면 false로 바꿔준다
    public static boolean IS_WRITE_NEW_DIARY = false;
    DiaryListRecyclerAdapter adapter;
    RecyclerView recyclerView;
    int listCount = 0;

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
        recyclerView = (RecyclerView)findViewById(R.id.diaryListRecyclerView);
        allDiaryList = receiveItems();

        //adapter 생성, 연결(context, 데이터, 레이아웃 담으면 알아서 연결해줌) START
        adapter = new DiaryListRecyclerAdapter(this, allDiaryList, R.layout.diaryitem);
        recyclerView.setAdapter(adapter);//adapter 연결
        //adapter 생성, 연결(context, 데이터, 레이아웃 담으면 알아서 연결해줌) END

        //LayoutManager 생성 START
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //LayoutManager 생성 END

        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener(linearLayoutManager) {
//
//            @Override
//            public void onLoadMore(int page, int totalItemsCount) {
//                List<ViewItem> moreContacts = receiveItems();
//                int curSize = adapter.getItemCount();
//                allDiaryList.addAll(moreContacts);
//                adapter.notifyItemRangeInserted(curSize, allDiaryList.size() - 1);
//            }
//        });
        //ItemAnimation / Item Decoration 두 개도 적용해볼 것
    //RecylerView 이슈 END

        //xml 요소들 붙이기 START
        Button onlyBtn = (Button) findViewById(R.id.onlyBtn);
        Button writeDiaryBtn = (Button)findViewById(R.id.writeDiaryBtn);
        talkingText = (TextView)findViewById(R.id.talkingText);
        //xml 요소들 붙이기 END

    //talkingText를 위한 AsyncTask 실행하기 START
        new talkingAsyncTask(talkingText).execute();
    //talkingText를 위한 AsyncTask 실행하기 END

        onlyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DiaryListActivity.this, "서비스 준비중입니다", Toast.LENGTH_SHORT).show();
            }
        });

        writeDiaryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DiaryListActivity.this, DiaryWritingActivity.class);
                startActivity(intent);
            }
        });

        Log.d("DiaryList", "onCreate() END");
    }


    @Override
    protected void onResume() {
        super.onResume();

        Log.d("DiaryList", "onResume() START");

        allDiaryList = receiveItems();    //일기 리스트 갱신
        adapter = new DiaryListRecyclerAdapter(this, allDiaryList, R.layout.diaryitem);
        recyclerView.setAdapter(adapter);//adapter 다시 만들어서 연결

        TALKING_TO_USER = true;
        new talkingAsyncTask(talkingText).execute();
        Log.d("DiaryList", "TALKING_TO_USER: "+ TALKING_TO_USER);
        Log.d("DiaryList", "onResume() END");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("DiaryList", "onPause() START");
        TALKING_TO_USER = false;    //엑티비티 종료 false로 변경
        Log.d("DiaryList", "TALKING_TO_USER: "+ TALKING_TO_USER);
        Log.d("DiaryList", "onPause() END");
    }

    public List<ViewItem> receiveItems() {
        Log.d("DiaryList", "createItem() START");

        List<ViewItem> items = new ArrayList<>();
        listCount += 10;

        //테스트용 for문 START
        ViewItem viewItem = null;

        DatabaseHandler databaseHandler = DatabaseHandler.open(this);

        Cursor cursor = databaseHandler.selectDiaryList(listCount);

        Log.d("cursorDDDDDD", String.valueOf(cursor.getCount()));

        if(cursor.getCount() == 0){

        }else{
            do{
                viewItem = new ViewItem();
                //ArrayList<String> tagContents = new ArrayList<>();

                viewItem.dateText = cursor.getString(cursor.getColumnIndex("writeDate"))
                        + " "
                        + cursor.getString(cursor.getColumnIndex("writeTime"));
                viewItem.diaryText = cursor.getString(cursor.getColumnIndex("contents"));
//                viewItem.tags = tagContents;

                items.add(viewItem);
            }while(cursor.moveToNext());
        }


        //테스트용 for문 END

        databaseHandler.close();

        Log.d("DiaryList", "items: "+ items);
        Log.d("DiaryList", "createItem() END");
        return items;
    }

}
