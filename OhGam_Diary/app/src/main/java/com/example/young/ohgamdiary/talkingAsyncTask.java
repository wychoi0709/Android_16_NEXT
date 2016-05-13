package com.example.young.ohgamdiary;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by WonYoung on 2016. 5. 10..
 */
public class talkingAsyncTask extends AsyncTask<String, Void, Void> {

    TextView talkingText;
    ArrayList<conversationList> talkingQueue = new ArrayList<>();
    int count;


    //생성자로 talkingText 받아오기 START
    public talkingAsyncTask(TextView talkingText){

        this.talkingText = talkingText;

    }
    //생성자로 talkingText 받아오기 END


    @Override
    protected Void doInBackground(String... strings) {
        Log.d("talkingAsyncTask", "(MMMMMM)doInBackground() START");

        Log.d("talkingAsyncTask", "(VVVVVV)DiaryList.TALKING_TO_USER: " + DiaryList.TALKING_TO_USER);
        while(DiaryList.TALKING_TO_USER){   //DiaryList Activity가 종료되면, 루프를 멈춤

            //if(큐가 비어있으면) than DAO에 요청해서 큐를 받아옴 START
            Log.d("talkingAsyncTask", "(MMMMMM)while() count: " + count++);     //얼마나 돌았니?
            Log.d("talkingAsyncTask", "(VVVVVV)talkingQueue: " + talkingQueue); //큐에 뭐가 들었니?
            if(talkingQueue.isEmpty()){

            }
            //if(큐가 비어있으면) than DAO에 요청해서 큐를 받아옴 END

            //if(새로운 글을 썼다면) than DAO에 지금까지 썼던 큐를 보내고, 다시 받아옴 START
            Log.d("talkingAsyncTask", "(VVVVVV)DiaryList.IS_WRITE_NEW_DIARY: " + DiaryList.IS_WRITE_NEW_DIARY);
            if(DiaryList.IS_WRITE_NEW_DIARY){

            }
            //if(새로운 글을 썼다면) than DAO에 지금까지 썼던 큐를 보내고, 다시 받아옴 END


            //1. Queue의 내용 중 첫 번째 내용을 꺼내서 텍스트를 publishProgress()로 보내고,
            //2. 해당 Conversation의 출력 카운트를 1올려서 DAO에 보내서 DB를 갱신한다.
            //3. 해당 Conversation을 큐의 마지막에 넣는다.


            //6~8초 대기(Thread.sleep(7000);) 후 무한 반복시킬 것 START
            SystemClock.sleep(8000);
            //6~8초 대기(Thread.sleep(7000);) 후 무한 반복시킬 것 END
        }

        Log.d("talkingAsyncTask", "(MMMMMM)doInBackground() END");
        return null;
    }


    //UI 지속적으로 업데이트 START
    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);

    }
    //UI 지속적으로 업데이트 END


    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Log.e("talkingAsyncTask","talkingAsyncTask end..!!");
    }

}
