package com.wjz.www.textviewinputiconfont.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.app.AppCompatDelegate;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * 项目名称：TextViewInputIconFont
 * 包名：com.wjz.www.textviewinputiconfont.utils
 * 创建人：Wjz
 * 创建时间：2016/9/19
 * 类描述：
 */
public class IconFontLayoutFactroy implements LayoutInflaterFactory {
    private static Typeface          mTypeFace;
    private        AppCompatDelegate mAppCompatDelegate;

    public IconFontLayoutFactroy(Context context,
                                 AppCompatDelegate appCompatDelegate) {
        if (mTypeFace == null) {
            mTypeFace = Typeface.createFromAsset(context.getAssets(),
                    "iconfont.ttf");
            mAppCompatDelegate = appCompatDelegate;
        }
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        View view = mAppCompatDelegate.createView(parent, name, context, attrs);
        if (view instanceof TextView) {
            ((TextView) view).setTypeface(mTypeFace);
        }
        return view;
    }
}
