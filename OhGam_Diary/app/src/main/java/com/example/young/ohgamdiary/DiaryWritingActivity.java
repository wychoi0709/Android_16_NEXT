package com.example.young.ohgamdiary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.young.ohgamdiary.dao.DatabaseHandler;
import com.example.young.ohgamdiary.model.DiaryContent;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by WonYoung on 16. 5. 18..
 */
public class DiaryWritingActivity extends AppCompatActivity implements View.OnClickListener{

    DiaryContent diaryContent;
    EditText year;
    EditText month;
    EditText date;
    EditText content;
    EditText tags;
    String strCurYear;
    String strCurMonth;
    String strCurDate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        Button confirmBtn = (Button) findViewById(R.id.confirmBtn);


        diaryContent = new DiaryContent();
        year = (EditText) findViewById(R.id.yearEditText);
        month = (EditText) findViewById(R.id.monthEditText);
        date = (EditText) findViewById(R.id.dateEditText);
        content = (EditText) findViewById(R.id.diaryEditText);
        tags = (EditText) findViewById(R.id.tagEditText);

        //오늘 날짜 입력해주기 START
        long now = System.currentTimeMillis();
        Date currentDate = new Date(now);

        SimpleDateFormat CurYearFormat = new SimpleDateFormat("yyyy");
        SimpleDateFormat CurMonthFormat = new SimpleDateFormat("MM");
        SimpleDateFormat CurDateFormat = new SimpleDateFormat("dd");

        strCurYear = CurYearFormat.format(currentDate);
        strCurMonth = CurMonthFormat.format(currentDate);
        strCurDate = CurDateFormat.format(currentDate);
        //오늘 날짜 입력해주기 END

        year.setHint(strCurYear);
        month.setHint(strCurMonth);
        date.setHint(strCurDate);

        confirmBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Log.d("DiaryWritingActivity", "onClick START");
        if(v.getId() == R.id.confirmBtn) {
            //현재 시간(시,분,초) 갱신 START
            long nowAgain = System.currentTimeMillis();
            Date currentDateAgain = new Date(nowAgain);

            SimpleDateFormat CurHourFormatAgain = new SimpleDateFormat("HH");
            SimpleDateFormat CurMinuteFormatAgain = new SimpleDateFormat("mm");
            SimpleDateFormat CurSecondFormatAgain = new SimpleDateFormat("ss");

            String strCurHourAgain = CurHourFormatAgain.format(currentDateAgain);
            String strCurMinuteAgain = CurMinuteFormatAgain.format(currentDateAgain);
            String strCurSecondAgain = CurSecondFormatAgain.format(currentDateAgain);
            //현재 시간 갱신 END
            if(TextUtils.isEmpty(year.getText())){
                diaryContent.year = strCurYear;
            }else {
                diaryContent.year = String.valueOf(year.getText());
            }

            if(TextUtils.isEmpty(month.getText())){
                diaryContent.month = strCurMonth;
            }else {
                diaryContent.month = String.valueOf(month.getText());
            }

            if(TextUtils.isEmpty(date.getText())){
                diaryContent.date = strCurDate;
            }else {
                diaryContent.date = String.valueOf(date.getText());
            }

            diaryContent.hour = String.valueOf(strCurHourAgain);
            diaryContent.minute = String.valueOf(strCurMinuteAgain);
            diaryContent.second = String.valueOf(strCurSecondAgain);

            diaryContent.content = String.valueOf(content.getText());
            diaryContent.tags = String.valueOf(tags.getText());


            DatabaseHandler databaseHandler = DatabaseHandler.open(DiaryWritingActivity.this);
            long cnt = databaseHandler.insertDiaryContent(diaryContent);

            if (cnt == -1) {
                Toast.makeText(DiaryWritingActivity.this,
                        "입력에 실패했습니다.",
                        Toast.LENGTH_SHORT)
                        .show();
            } else {
                Toast.makeText(DiaryWritingActivity.this,
                        "입력에 성공했습니다.",
                        Toast.LENGTH_SHORT)
                        .show();
            }

            databaseHandler.close();

            finish();
        }
        Log.d("DiaryWritingActivity", "onClick END");
    }
}
