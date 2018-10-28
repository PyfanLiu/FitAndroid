package com.wjz.www.textviewinputiconfont;

import android.os.Bundle;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AppCompatActivity;

import com.wjz.www.textviewinputiconfont.utils.IconFontLayoutFactroy;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /*
        字库
        https://github.com/FortAwesome/Font-Awesome/
        对照表
        http://fortawesome.github.io/Font-Awesome/cheatsheet/
        http://www.iconfont.cn/
        https://icomoon.io/app/#/select
        https://github.com/mikepenz/Android-Iconics
        * */

        LayoutInflaterCompat.setFactory(
                getLayoutInflater(),
                new IconFontLayoutFactroy(this,getDelegate())
        );

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*FontHelper.injectFont(findViewById(
                android.R.id.content
                //R.id.ll
        ));*/
    }
}
