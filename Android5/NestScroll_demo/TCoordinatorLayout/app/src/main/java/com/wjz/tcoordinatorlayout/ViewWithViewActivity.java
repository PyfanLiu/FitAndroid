package com.wjz.tcoordinatorlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Wjz on 2017/5/6.
 */

public class ViewWithViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_with_view_behavior);

        TextView dependency = (TextView) findViewById(R.id.dependency);
        TextView child = (TextView) findViewById(R.id.child);

        dependency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                * 每点击一次 向下移动50px
                * dependency 移动 child 移动
                * */
                ViewCompat.offsetTopAndBottom(v, 50);
            }
        });
    }
}
