package com.example.young.ohgamdiary.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.young.ohgamdiary.model.DiaryContent;

/**
 * Created by WonYoung on 16. 5. 22..
 */
public class DatabaseHandler {

    private DatabaseManager databaseManager;
    private SQLiteDatabase db;

    private DatabaseHandler(Context ctx){
        this.databaseManager = new DatabaseManager(ctx);
        this.db = databaseManager.getWritableDatabase();
    }

    public static DatabaseHandler open(Context ctx) throws SQLException{
        DatabaseHandler databaseHandler = new DatabaseHandler(ctx);
        return databaseHandler;
    }

    public void close(){
        databaseManager.close();
    }

    public long insertDiaryContent(DiaryContent diaryContent){
        ContentValues values = new ContentValues();

        values.put("iddiary", (byte[]) null);
        values.put("contents", diaryContent.content);
        values.put("writeDate", diaryContent.year + "-" + diaryContent.month + "-" + diaryContent.date);
        values.put("writeTime", diaryContent.hour+ ":" + diaryContent.minute + ":" + diaryContent.second);
        values.put("user_iduser", 0);

        return db.insert("diary", null, values);
    }

    public Cursor selectDiaryList(int listCount) throws SQLException{

        Cursor cursor = db.rawQuery("SELECT * FROM diary ORDER BY iddiary DESC LIMIT 10 OFFSET" + listCount, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        return cursor;
    }

}
