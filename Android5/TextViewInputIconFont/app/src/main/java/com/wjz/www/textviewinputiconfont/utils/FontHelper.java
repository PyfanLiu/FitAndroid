package com.wjz.www.textviewinputiconfont.utils;

import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 项目名称：TextViewInputIconFont
 * 包名：com.wjz.www.textviewinputiconfont.utils
 * 创建人：Wjz
 * 创建时间：2016/9/19
 * 类描述：
 */
public class FontHelper {

    public static final String FONTS_DIR = "fonts/";
    //public static final String DEF_FONT  = FONTS_DIR + "fontawesome-webfont.ttf";
    public static final String DEF_FONT  = FONTS_DIR + "iconfont.ttf";

    public static final void injectFont(View rootView) {
        injectFont(rootView, Typeface.createFromAsset(
                rootView.getContext().getAssets(), DEF_FONT
        ));
    }

    public static final void injectFont(View rootView,
                                        Typeface tf) {
        if (rootView instanceof ViewGroup) {
            ViewGroup group      = (ViewGroup) rootView;
            int       childCount = group.getChildCount();
            for (int i = 0; i < childCount; i++) {
                injectFont(group.getChildAt(i), tf);
            }
        } else if (rootView instanceof TextView) {
            ((TextView) rootView).setTypeface(tf);
        }
    }
}
