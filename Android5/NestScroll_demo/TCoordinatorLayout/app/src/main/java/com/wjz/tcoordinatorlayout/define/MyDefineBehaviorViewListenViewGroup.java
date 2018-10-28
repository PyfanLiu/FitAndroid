package com.wjz.tcoordinatorlayout.define;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Wjz on 2017/5/6.
 */

public class MyDefineBehaviorViewListenViewGroup extends CoordinatorLayout.Behavior<View> {

    public MyDefineBehaviorViewListenViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     当一个CoordinatorLayout的子view准备去开始一个嵌套滑动时调用
     *
     * @param coordinatorLayout  根布局coordinatorLayout
     * @param child 这个behavior所关联的coordinatorLayout的子view
     * @param directTargetChild 包含target 嵌套滚动操作的coordinatorLayout子view
     * @param target 开始嵌套滑动的coordinatorLayout子view。
     * @param nestedScrollAxes 嵌套滚动的轴线。See
     *                         {@link ViewCompat#SCROLL_AXIS_HORIZONTAL},
     *                         {@link ViewCompat#SCROLL_AXIS_VERTICAL}
     * @return 如果behavior希望接受这个嵌套滚动，则返回true。
     */
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child,
                                       View directTargetChild, View target, int nestedScrollAxes) {

        /*
        * SCROLL_AXIS_VERTICAL: 表示沿垂直轴滚动。
        * */
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    /**
     * 滑动事件
     * @param coordinatorLayout
     * @param child
     * @param target
     * @param dx
     * @param dy
     * @param consumed
     */
    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child,
                                  View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);

        int targetScrolled = target.getScrollY();
        child.setScrollY(targetScrolled);

    }

    /**
     * 处理滑动惯性
     *
     * @param coordinatorLayout
     * @param child
     * @param target
     * @param velocityX
     * @param velocityY
     * @return
     */
    @Override
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, View child, View target, float velocityX, float velocityY) {
        ((NestedScrollView) child).fling((int)velocityY);
        return true;
    }



    /**
     * 当嵌套滑动已经被CoordinatorLayout接受时调用。
     *
     * 参数同上。
     * @see NestedScrollingParent#onNestedScrollAccepted(View, View, int)
     */
    public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V child,
                                       View directTargetChild, View target, int nestedScrollAxes) {
        // Do nothing
    }

    /**
     * 嵌套滚动结束时调用。
     *
     * 参数同上。
     *
     * @see NestedScrollingParent#onStopNestedScroll(View)
     */
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V child, View target) {
        // Do nothing
    }

    /**
     * target滑动之后调用
     *
     * @param coordinatorLayout 同上
     * @param child 同上
     * @param target 同上
     * @param dxConsumed 水平方向target滑动的距离(消耗的距离px)，左滑大于0，右滑小于0
     * @param dyConsumed 垂直方向target滑动的距离(消耗的距离px)，上滑大于0，下滑小于0
     * @param dxUnconsumed 水平方向target未滑动的距离(但是被用户请求了)
     * @param dyUnconsumed 垂直方向target未滑动的距离(但是被用户请求了)
     *
     * @see NestedScrollingParent#onNestedScroll(View, int, int, int, int)
     */
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V child, View target,
                               int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        // Do nothing
    }

    /**
     * target准备滑动时（滑动之前）调用
     *
     * @param coordinatorLayout 同上
     * @param child 同上
     * @param target 同上
     * @param dx 水平方向target想要滑动的距离（用户请求的）
     * @param dy 垂直方向target想要滑动的距离（用户请求的）
     * @param consumed 需要我们自己传入。 consumed[0] 已经被消费的水平方向滑动的距离, consumed[1] 已经被消费的垂直方向滑动的距离
     *
     * @see NestedScrollingParent#onNestedPreScroll(View, int, int, int[])
     */
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V child, View target,
                                  int dx, int dy, int[] consumed) {
        // Do nothing
    }

    /**
     * target在fling（飞速滚动）之后调用
     *
     * @param coordinatorLayout 同上
     * @param child 同上
     * @param target 同上
     * @param velocityX 水平方向的速度
     * @param velocityY 垂直方向的速度
     * @param consumed child是否fling了
     * @return behavior是否消费了这个fling
     *
     * @see NestedScrollingParent#onNestedFling(View, float, float, boolean)
     */
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, V child, View target,
                                 float velocityX, float velocityY, boolean consumed) {
        return false;
    }

    /**
     * target在fling（飞速滚动）之前调用
     *
     * 参数同onNestedFling方法。
     *
     * @see NestedScrollingParent#onNestedPreFling(View, float, float)
     */
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V child, View target,
                                    float velocityX, float velocityY) {
        return false;
    }
}
