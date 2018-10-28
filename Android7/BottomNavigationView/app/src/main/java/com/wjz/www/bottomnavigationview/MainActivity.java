package com.wjz.www.bottomnavigationview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        mTextMessage.setText("1");
                        return true;
                    case R.id.navigation_dashboard:
                        mTextMessage.setText("2");
                        return true;
                    case R.id.navigation_notifications:
                        mTextMessage.setText("3");
                        return true;
                }
                return false;
            }

        });

        Menu menu = navigation.getMenu();

        MenuItem item = menu.findItem(R.id.navigation_home);
        item.setIcon(R.mipmap.ic_launcher);
    }

}
