package com.example.www.recycleview;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.www.recycleview.Beans.DataBean;
import com.example.www.recycleview.adapter.MyAdapter;
import com.example.www.recycleview.adapter.StaggeredGridAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecycleView;

    private List<DataBean> mListDatas     = new ArrayList<DataBean> ();
    private List<DataBean> mStraggerDatas = new ArrayList<DataBean> ();

    private int[] mListIcons = new int[] { R.mipmap.g1, R.mipmap.g2, R.mipmap.g3, R.mipmap.g4, R.mipmap.g5, R.mipmap.g6, R.mipmap.g7, R.mipmap.g8, R.mipmap.g9, R.mipmap.g10, R.mipmap.g11, R.mipmap.g12, R.mipmap.g13, R.mipmap.g14, R.mipmap.g15, R.mipmap.g16, R.mipmap.g17, R.mipmap.g18, R.mipmap.g19, R.mipmap.g20, R.mipmap.g21, R.mipmap.g22, R.mipmap.g23, R.mipmap.g24, R.mipmap.g25, R.mipmap.g26, R.mipmap.g27, R.mipmap.g28, R.mipmap.g29 };

    private int[] mStraggeredIcons = new int[] { R.mipmap.p1, R.mipmap.p2, R.mipmap.p3, R.mipmap.p4, R.mipmap.p5, R.mipmap.p6, R.mipmap.p7, R.mipmap.p8, R.mipmap.p9, R.mipmap.p10, R.mipmap.p11, R.mipmap.p12, R.mipmap.p13, R.mipmap.p14, R.mipmap.p15, R.mipmap.p16, R.mipmap.p17, R.mipmap.p18, R.mipmap.p19, R.mipmap.p20, R.mipmap.p21, R.mipmap.p22, R.mipmap.p23, R.mipmap.p24, R.mipmap.p25, R.mipmap.p26, R.mipmap.p27, R.mipmap.p28, R.mipmap.p29, R.mipmap.p30, R.mipmap.p31, R.mipmap.p32, R.mipmap.p33, R.mipmap.p34, R.mipmap.p35, R.mipmap.p36, R.mipmap.p37, R.mipmap.p38, R.mipmap.p39, R.mipmap.p40, R.mipmap.p41, R.mipmap.p42, R.mipmap.p43, R.mipmap.p44 };
    private SwipeRefreshLayout mSwipeRefreshLayout;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById (R.id.toolbar);
        setSupportActionBar (toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById (R.id.fab);
        fab.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                Snackbar.make (view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction ("Action", null).show ();
            }
        });

        mRecycleView = (RecyclerView) findViewById (R.id.recycleView);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById (R.id.swipeRefreshLayout);

        initData ();
        initAdapter ();
        initEvent();
    }

    private void initEvent () {
        mSwipeRefreshLayout.setOnRefreshListener (new SwipeRefreshLayout.OnRefreshListener () {
            @Override
            public void onRefresh () {
                //模拟加载数据
                new Thread (new Runnable () {
                    @Override
                    public void run () {
                        SystemClock.sleep (4000);
                        runOnUiThread (new Runnable () {
                            @Override
                            public void run () {
                                //停止刷新操作
                                mSwipeRefreshLayout.setRefreshing (false);
                                //得到adapter，然后刷新
                                mRecycleView.getAdapter ().notifyDataSetChanged ();
                            }
                        });
                    }
                }).start ();
            }
        });
    }

    /**
     * listView垂直显示,默认显示
     */
    private void initAdapter () {

        //实现listView的效果
        //可以垂直滑动，也可以水平滑动，数据反向加载

        //初始化布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager (this, LinearLayoutManager.VERTICAL, false);

        //设置布局管理器
        mRecycleView.setLayoutManager (linearLayoutManager);

        //设置adapter
        mRecycleView.setAdapter (new MyAdapter (this, mListDatas));
    }

    /**
     * listView水平显示
     */
    private void initAdapterH () {

        //实现listView的效果
        //可以垂直滑动，也可以水平滑动，数据反向加载

        //初始化布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager (this, LinearLayoutManager.HORIZONTAL, false);

        //设置布局管理器
        mRecycleView.setLayoutManager (linearLayoutManager);

        //设置adapter
        mRecycleView.setAdapter (new MyAdapter (this, mListDatas));
    }


    /**
     * GridView垂直显示
     */
    private void initGridAdapterV () {

        //实现listView的效果
        //可以垂直滑动，也可以水平滑动，数据反向加载

        //初始化布局管理器
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager (this, LinearLayoutManager.HORIZONTAL, false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager (this, 2);
        //设置布局管理器
        mRecycleView.setLayoutManager (gridLayoutManager);

        //设置adapter
        mRecycleView.setAdapter (new MyAdapter (this, mListDatas));
    }


    /**
     * GridView水平显示
     */
    private void initGridAdapterH () {

        //实现listView的效果
        //可以垂直滑动，也可以水平滑动，数据反向加载

        //初始化布局管理器
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager (this, LinearLayoutManager.HORIZONTAL, false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager (this, 2, LinearLayoutManager.HORIZONTAL, false);
        //设置布局管理器
        mRecycleView.setLayoutManager (gridLayoutManager);

        //设置adapter
        mRecycleView.setAdapter (new MyAdapter (this, mListDatas));
    }

    /**
     * StaggeredGrid垂直显示
     */
    private void initStaggeredGridAdapterV () {
        //设置layoutMager
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager (2, StaggeredGridLayoutManager.VERTICAL);
        mRecycleView.setLayoutManager (staggeredGridLayoutManager);

        //设置adapter
        StaggeredGridAdapter adapter = new StaggeredGridAdapter (this, mStraggerDatas);
        mRecycleView.setAdapter (adapter);
    }

    /**
     * StaggeredGrid水平显示
     */
    private void initStaggeredGridAdapterH () {
        //设置layoutMager
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager (2, StaggeredGridLayoutManager.HORIZONTAL);
        mRecycleView.setLayoutManager (staggeredGridLayoutManager);

        //设置adapter
        StaggeredGridAdapter adapter = new StaggeredGridAdapter (this, mStraggerDatas);
        mRecycleView.setAdapter (adapter);
    }

    /**
     * 初始化数据
     */
    private void initData () {

        //模拟加载数据
        for (int i = 0; i < mListIcons.length; i++) {

            DataBean bean = new DataBean ();
            bean.icon = mListIcons[ i ];
            bean.content = "内容-" + i;
            mListDatas.add (bean);
        }

        for (int i = 0; i < mStraggeredIcons.length; i++) {
            int iconId = mStraggeredIcons[ i ];
            DataBean dataBean = new DataBean ();
            dataBean.icon = iconId;
            dataBean.content = "我是item" + i;
            mStraggerDatas.add (dataBean);
        }

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater ().inflate (R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId ();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        switch (id) {
            case R.id.action_list_v:
                initAdapter ();
                break;
            case R.id.action_list_h:
                initAdapterH ();
                break;
            case R.id.action_grid_v:
                initGridAdapterV ();
                break;
            case R.id.action_grid_h:
                initGridAdapterH ();
                break;
            case R.id.action_stragger_v:
                initStaggeredGridAdapterV ();
                break;
            case R.id.action_stragger_h:
                initStaggeredGridAdapterH ();
                break;

            default:
                break;
        }


        return super.onOptionsItemSelected (item);
    }
}
