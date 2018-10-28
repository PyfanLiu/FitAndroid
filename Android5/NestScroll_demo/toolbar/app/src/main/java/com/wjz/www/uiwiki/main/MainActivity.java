package com.wjz.www.uiwiki.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.wjz.www.uiwiki.R;
import com.wjz.www.uiwiki.coordinator.CoordinatorActivity;
import com.wjz.www.uiwiki.coordinator.DefineCoordinatorActivity;
import com.wjz.www.uiwiki.toolbar.ToolBarActivity;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        RecyclerView mRv = (RecyclerView) findViewById(R.id.rv_main);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        List<String> list = Arrays.asList(getResources().getStringArray(R.array.main_data));
        MainAdapter  adapter = new MainAdapter(R.layout.main_item, list);
        mRv.setAdapter(adapter);
        mRv.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {

                switch (i){
                    case 0:
                        Intent ToolBar = new Intent(MainActivity.this, ToolBarActivity.class);
                        startActivity(ToolBar);
                        break;
                    case 1:
                        Intent Coordinator = new Intent(MainActivity.this, CoordinatorActivity.class);
                        startActivity(Coordinator);
                        break;
                    case 2:
                        Intent DefCoordinator = new Intent(MainActivity.this, DefineCoordinatorActivity.class);
                        startActivity(DefCoordinator);
                        break;
                }
            }
        });
    }

}
