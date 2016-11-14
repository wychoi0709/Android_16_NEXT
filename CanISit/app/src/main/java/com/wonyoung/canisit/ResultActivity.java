package com.wonyoung.canisit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wonyoung.canisit.adapter.PathResultRecyclerAdapter;
import com.wonyoung.canisit.vo.PathResultItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by WonYoung on 16. 8. 15..
 */
public class ResultActivity extends AppCompatActivity{

    @BindView(R.id.resultRecyclerView)
    RecyclerView resultRecyclerView;

    LinearLayoutManager linearLayoutManager;
    int listCount = 0;
    List<PathResultItem> designerList = null;
    PathResultRecyclerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);

//RecylerView 이슈 START
    //LayoutManager 생성 START
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    //LayoutManager 생성 END
        listCount = 0;
        resultRecyclerView.setLayoutManager(linearLayoutManager);

        listCount = 0;
        designerList = receiveItems();    //디자이너 리스트 갱신
        adapter = new PathResultRecyclerAdapter(this, designerList, R.layout.item_result);
        resultRecyclerView.setAdapter(adapter);//adapter 다시 만들어서 연결
//RecylerView 이슈 END

    }

    //리스트 갱신 메소드 START
    public List<PathResultItem> receiveItems() {
        List<PathResultItem> newPathResultItemList = new ArrayList<>();

        //테스트용 for문 START(DB에서 꺼내올 것)
        PathResultItem pathResultItem = null;
        for(int i = 0; i < 10; i++){
            pathResultItem = new PathResultItem();

            newPathResultItemList.add(pathResultItem);
        }
        listCount += 10;
        //테스트용 for문 END
        return newPathResultItemList;
    }
    //리스트 갱신 메소드 END

}
