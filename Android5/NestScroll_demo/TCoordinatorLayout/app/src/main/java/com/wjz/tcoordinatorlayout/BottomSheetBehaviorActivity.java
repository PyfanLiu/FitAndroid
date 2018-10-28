package com.wjz.tcoordinatorlayout;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class BottomSheetBehaviorActivity extends AppCompatActivity {

    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_sheet_behavior_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /* 查找使用BottomSheetBehavior的ViewGroup*/
        constraintLayout = (ConstraintLayout) findViewById(R.id.constraint);
        /* FloatingActionButton的点击事件*/
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* 查找当前ViewGroup使用Behavior*/
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(constraintLayout);
                bottomSheetBehavior.setState(
                        /* 当前状态 与 BottomSheetBehavior枚举 的比对
                        * 缩放容器
                        * STATE_EXPANDED 扩展
                        * STATE_COLLAPSED 收缩
                        * */
                        bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED ?
                                BottomSheetBehavior.STATE_EXPANDED :
                                BottomSheetBehavior.STATE_COLLAPSED
                );

                /* SwipeDismissBehavior Snackbar默认使用*/
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();

            }
        });
    }

    /* Menu*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bottom_sheet_behavior, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
