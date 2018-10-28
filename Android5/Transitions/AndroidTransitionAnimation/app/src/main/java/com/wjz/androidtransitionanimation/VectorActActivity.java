package com.wjz.androidtransitionanimation;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Copyright (c) 2018 SHARP CORPORATION
 *
 * @author wujiazhen
 * @file com.wjz.androidtransitionanimation.VectorAct
 * <p>
 * [DESCRIPTION]
 * @change [DATE] [EDITOR] [MODEL] [TYPE] [COMMENT]
 */

public class VectorActActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vector);

        ImageView iv = (ImageView) findViewById(R.id.iv);
        Drawable drawable = iv.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
    }

    public void animate(View view) {

    }
}
