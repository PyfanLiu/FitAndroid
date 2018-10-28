package com.wjz.www.searchviewdemo;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView             lv;
    private ArrayAdapter<String> adapter;
    private ArrayList<String>    mDataList;
    private SearchView           searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        initActionBar();
        lv = (ListView) findViewById(R.id.lv_main_infolist);
        initAdapter();

        lv.setTextFilterEnabled(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String newText) {

                if (TextUtils.isEmpty(newText)) {
                    lv.clearTextFilter();
                } else {
                    lv.setFilterText(newText);
                }

                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public boolean onQueryTextSubmit(String query) {
                // TODO Auto-generated method stub
                return false;
            }
        });
    }

    private void initAdapter() {
        mDataList = new ArrayList<String>();
        mDataList.add("aa");
        mDataList.add("ab");
        mDataList.add("bb");
        mDataList.add("bc");
        mDataList.add("fd");
        mDataList.add("afd");
        mDataList.add("cvdf");
        mDataList.add("fdidfa");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mDataList);
        lv.setAdapter(adapter);

    }

    private void initActionBar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        View                                          view         = getLayoutInflater().inflate(R.layout.custom_searchview, null);
        android.support.v7.app.ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        //actionBar设置自定义的searchView
        getSupportActionBar().setCustomView(view, layoutParams);
        searchView = (SearchView) view.findViewById(R.id.sv_searchview);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }


}
