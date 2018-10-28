package com.wjz.www.actionbarandsearchable.barActivity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.wjz.www.actionbarandsearchable.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：ActionBarAndSearchable
 * 包名：com.wjz.www.actionbarandsearchable.barActivity
 * 创建人：Wjz
 * 创建时间：2016/8/20
 * 类描述：
 */
public class NavigationActivity extends ActionBarActivity {

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
        actionBar.setDisplayUseLogoEnabled(true);// 默认是true,默认显示logo

        // 显示/隐藏回退部分
        actionBar.setDisplayHomeAsUpEnabled(true);// 默认是false,默认隐藏回退部分

        // 显示/隐藏图标
        actionBar.setDisplayShowHomeEnabled(true);

        // 显示/隐藏标题
        actionBar.setDisplayShowTitleEnabled(true);

        // 图标,标题都隐藏,回退部分就自动隐藏了吧

		/*--------------- list模式 ---------------*/
        /**
         NAVIGATION_MODE_STANDARD 默认
         NAVIGATION_MODE_LIST 列表
         NAVIGATION_MODE_TABS tabs页签
         */
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        // 初始化数据
        final List<String> objects = new ArrayList<String>();
        objects.add("主页");
        objects.add("新闻");
        objects.add("娱乐");

        // 创建adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, objects);
        actionBar.setListNavigationCallbacks(adapter, new ActionBar.OnNavigationListener() {
            @Override
            public boolean onNavigationItemSelected(int itemPosition, long itemId) {
                Toast.makeText(getApplicationContext(), objects.get(itemPosition), Toast.LENGTH_LONG).show();
                return false;
            }
        });
		/*--------------- tabs模式 ---------------*/

        /*actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        for (int i = 0; i < 10; i++) {
            ActionBar.Tab tab = actionBar.newTab();
            tab.setText("item-" + i);
            tab.setIcon(R.drawable.ic_action_delete);
            tab.setTabListener(new ActionBar.TabListener() {

                @Override
                public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
                    // TODO

                }

                @Override
                public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                    Toast.makeText(getApplicationContext(), tab.getText(), Toast.LENGTH_LONG).show();
                }

                @Override
                public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
                    // TODO

                }
            });
            actionBar.addTab(tab);
        }*/

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
