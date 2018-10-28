package com.wjz.www.actionbarandsearchable.barActivity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewConfiguration;

import com.wjz.www.actionbarandsearchable.R;

import java.lang.reflect.Field;

/**
 * 项目名称：ActionBarAndSearchable
 * 包名：com.wjz.www.actionbarandsearchable.barActivity
 * 创建人：Wjz
 * 创建时间：2016/8/20
 * 类描述：
 */
public class ActionButtonActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getOverflowMenu();
    }

    private void getOverflowMenu() {

        //菜单显示是根据public boolean hasPermanentMenuKey ()这个方法来判断的
        //改变系统探测实体menu键的存在与否来改变显示
        try {
            ViewConfiguration config       = ViewConfiguration.get(this);
            Field             menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if (menuKeyField != null) {
                menuKeyField.setAccessible(true);
                menuKeyField.setBoolean(config, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO
        return super.onOptionsItemSelected(item);
    }
}
