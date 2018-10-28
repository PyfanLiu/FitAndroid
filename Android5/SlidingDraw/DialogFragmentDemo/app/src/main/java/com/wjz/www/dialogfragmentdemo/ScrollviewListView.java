package com.wjz.www.dialogfragmentdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * ScrollView中嵌套ListView，重写ListView计算高度
 */
public class ScrollviewListView extends ListView {
    public ScrollviewListView(Context context) {
        super(context);
    }

    public ScrollviewListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollviewListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 问题一 ： 嵌套在 ScrollView的 ListVew数据显示不全，我遇到的是最多只显示两条已有的数据。
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,

                MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, expandSpec);

    }

    /*问题二 、打开套有 ListVew的 ScrollView的页面布局 默认 起始位置不是最顶部。

    解决办法有两种都挺好用：

   方法一：是把套在里面的Gridview 或者 ListVew 不让获取焦点即可。

            gridview.setFocusable(false); listview.setFocusable(false);

    注意：在xml布局里面设置android：focusable=“false”不生效

    方法二：网上还查到说可以设置myScrollView.smoothScrollTo(0,0);
    */
}
