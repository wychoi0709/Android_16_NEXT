package com.example.young.ohgamdiary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by young on 2016-04-17.
 */
public class DiaryList extends AppCompatActivity {

    Button onlyBtn;
    Button writeDiaryBtn;
    TextView talkingText;

    private Timer timer;
    private TimerTask timerTaskShow;
    private TimerTask timerTaskHide;

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

        //adapter 생성, 연결(context, 데이터, 레이아웃 담으면 알아서 연결해줌) START
        DiaryListRecyclerAdapter adapter = new DiaryListRecyclerAdapter(this, createItem(), R.layout.diaryitem);
        recyclerView.setAdapter(adapter);//adapter 연결
        //adapter 생성, 연결(context, 데이터, 레이아웃 담으면 알아서 연결해줌) END

        //LayoutManager 생성 START
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //LayoutManager 생성 END

        recyclerView.setLayoutManager(linearLayoutManager);
        //ItemAnimation / Item Decoration 두 개도 적용해볼 것
    //RecylerView 이슈 END


        //xml 요소들 붙이기 START
        onlyBtn = (Button) findViewById(R.id.onlyBtn);
        writeDiaryBtn = (Button)findViewById(R.id.writeDiaryBtn);
        talkingText = (TextView)findViewById(R.id.talkingText);
        //xml 요소들 붙이기 END



    //talkingText를 위한 AsyncTask 실행하기 START

        new talkingAsyncTask(talkingText).execute();

    //talkingText를 위한 AsyncTask 실행하기 END



    //talkingText에 시간에 따라 갱신되는 애니메이션 붙이기 START(이거 버릴 듯)
//
//        timerTaskShow = new TimerTask() {
//            @Override
//            public void run() {
//                //나타나는 애니메이션 START
//                YoYo.with(Techniques.FadeInDown)
//                        .duration(2000)
//                        .playOn(findViewById(R.id.talkingText));
//                //나타나는 애니메이션 END
//            }
//        };
//
//        timerTaskHide = new TimerTask() {
//            @Override
//            public void run() {
//                //사라지는 애니메이션 START
//                YoYo.with(Techniques.FadeOutDown)
//                        .duration(1000)
//                        .playOn(findViewById(R.id.talkingText));
//                //사라지는 애니메이션 END
//            }
//        };
//
//
//        timer = new Timer();

    //talkingText에 시간에 따라 갱신되는 애니메이션 붙이기 END___쓰레드로 따로 작업하기 무한반복이고 UI가 변경되도록 함




        writeDiaryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //프레그먼트로 대체되도록 수정할 것
                //페이지가 넘어가면 상단바가 갱신되어서 보기 안좋음
                Intent intent = new Intent(DiaryList.this, DiaryDetail.class);
                startActivity(intent);
            }
        });



        Log.d("DiaryList", "onCreate() END");
    }

    private List<ViewItem> createItem() {
        Log.d("DiaryList", "createItem() START");
        List<ViewItem> items = new ArrayList<>();

        //테스트용 for문 START
        ViewItem testViewItem = null;
        ArrayList<String> tagContents = new ArrayList<>();

        for(int i = 0; i < 11; i++){
            testViewItem = new ViewItem();

            tagContents.add("aaaa" + i);
            tagContents.add("bbbb" + i);
            tagContents.add("cccc" + i);
            tagContents.add("dddd" + i);

            testViewItem.dateText = "2016년 5월 " + (i+1) + "일 오후 14:23";
            testViewItem.diaryText = (i+1) + "야호야호야ㅑ야야야야호야양야야야야야ㅜㅜ\n야야야호야양야야야야야ㅜㅜ\n야야야호야양야야야야야ㅜㅜ\n야야야호야양야야야야야ㅜㅜ\n야야야호야양야야야야야ㅜㅜ\n야야야호야양야야야야야ㅜㅜ\n야야야호야양야야야야야ㅜㅜ\n야야야호야양야야야야야ㅜㅜ\n야야야호야양야야야야야ㅜㅜ\n야야야호야양야야야야야ㅜㅜ\n야야야호야양야야야야야ㅜㅜ\n야야야호야양야야야야야ㅜㅜ\n야야야호야양야야야야야ㅜㅜ\n야야야호야양야야야야야ㅜㅜ\n야야야호야양야야야야야ㅜㅜ\n야야야호야양야야야야야ㅜㅜ\nddd";
            testViewItem.tags = tagContents;

            items.add(testViewItem);
        }
        //테스트용 for문 END

        Log.d("DiaryList", "items: "+ items);
        Log.d("DiaryList", "createItem() END");
        return items;
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
