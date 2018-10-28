package com.wjz.www.actionbarandsearchable.barActivity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.wjz.www.actionbarandsearchable.R;

/**
 * 项目名称：ActionBarAndSearchable
 * 包名：com.wjz.www.actionbarandsearchable.barActivity
 * 创建人：Wjz
 * 创建时间：2016/8/20
 * 类描述：
 */
public class ActionModeActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionmode);
    }
    public void startActionMode(View v) {
        startSupportActionMode(new Callback() {

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                // TODO
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // TODO

            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                getMenuInflater().inflate(R.menu.menu_actionmode, menu);
                return true;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                // TODO
                return false;
            }
        });
    }
}
