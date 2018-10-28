package com.wjz.www.actionbarandsearchable.barActivity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

import com.wjz.www.actionbarandsearchable.R;

/**
 * 项目名称：ActionBarAndSearchable
 * 包名：com.wjz.www.actionbarandsearchable
 * 创建人：Wjz
 * 创建时间：2016/8/20
 * 类描述：
 */
public class TitleActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActionBar();
    }

    private void initActionBar() {
        // 1.得到actionBar对象
        ActionBar actionBar = getSupportActionBar();

        // 设置标题
        actionBar.setTitle("主标题");
        // 设置副标题
        actionBar.setSubtitle("副标题");

        // 修改图标
        actionBar.setIcon(R.mipmap.ic_launcher);
        actionBar.setLogo(R.drawable.ic_action_call);// 默认是logo优先

        // 修改logo/icon的优先级
        actionBar.setDisplayUseLogoEnabled(false);// 默认是true,默认显示logo

        // 显示/隐藏回退部分
        actionBar.setDisplayHomeAsUpEnabled(true);// 默认是false,默认隐藏回退部分

        // 显示/隐藏图标
        actionBar.setDisplayShowHomeEnabled(false);

        // 显示/隐藏标题
        actionBar.setDisplayShowTitleEnabled(true);

        // 图标,标题都隐藏,回退部分就自动隐藏了吧
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
