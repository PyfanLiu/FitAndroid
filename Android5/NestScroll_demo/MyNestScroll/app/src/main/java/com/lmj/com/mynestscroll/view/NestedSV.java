package com.lmj.com.mynestscroll.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;

/**
 * Created by Wjz on 2017/5/6.
 */

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
public class NestedSV extends NestedScrollView {
    public NestedSV(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
    }
}
