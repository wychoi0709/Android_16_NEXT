package com.example.young.ohgamdiary;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WonYoung on 16. 5. 5..
 */
public class ViewItem {

    public int id;
    public String dateText;
    public String diaryText;
    public ArrayList<String> tags;
    public boolean isOpenDiary;

    public static List<ViewItem> createItem() {
        Log.d("DiaryList", "createItem() START");
        List<ViewItem> items = new ArrayList<>();

        //테스트용 for문 START
        ViewItem testViewItem = null;


        for(int i = 0; i < 11; i++){
            testViewItem = new ViewItem();
            ArrayList<String> tagContents = new ArrayList<>();

            tagContents.add("aaaa" + i);
            tagContents.add("bbbb" + i);
            tagContents.add("cccc" + i);
            tagContents.add("dddd" + i);

            testViewItem.dateText = "2016년 5월 " + (i+1) + "일 오후 14:23";
            testViewItem.diaryText = (i+1) + "야호야호야ㅑ야야야야호야양야야야야야ㅜㅜ\n야야야호야양야야야야야ㅜㅜ\n야야야호야양야야야야야ㅜㅜ\n야야야호야양야야야야야ㅜㅜ\n야야야호야양야야야야야ㅜㅜ\n야야야호야양야야야야야ㅜㅜ\n야야야호야양야야야야야ㅜㅜ\n야야야호야양야야야야야ㅜㅜ\n야야야호야양야야야야야ㅜㅜ\n야야야호야양야야야야야ㅜㅜ\n야야야호야양야야야야야ㅜㅜ\n야야야호야양야야야야야ㅜㅜ\n야야야호야양야야야야야ㅜㅜ\n야야야호야양야야야야야ㅜㅜ\n야야야호야양야야야야야ㅜㅜ\n야야야호야양야야야야야ㅜㅜ\nddd";
            testViewItem.tags = tagContents;
            testViewItem.id = i+1;

            items.add(testViewItem);
        }
        //테스트용 for문 END

        Log.d("DiaryList", "items: "+ items);
        Log.d("DiaryList", "createItem() END");
        return items;
    }

}
