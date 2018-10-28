package com.wjz.www.propertyanimation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 *
 */
public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private static final String TAG = "MainActivity";
    private ImageView iv;
    private float mScreenHeight;

    private ViewGroup viewGroup;
    private GridLayout mGridLayout;
    private int mVal;
    private LayoutTransition mTransition;

    private CheckBox mAppear, mChangeAppear, mDisAppear, mChangeDisAppear;
    private LinearLayout mLl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);

        mLl = (LinearLayout) findViewById(R.id.ll);

        // 获取屏幕宽高
        DisplayMetrics outMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        mScreenHeight = outMetrics.heightPixels;


        //选择容器
        viewGroup = (ViewGroup) findViewById(R.id.id_container);
        mAppear = (CheckBox) findViewById(R.id.id_appear);
        mChangeAppear = (CheckBox) findViewById(R.id.id_change_appear);
        mDisAppear = (CheckBox) findViewById(R.id.id_disappear);
        mChangeDisAppear = (CheckBox) findViewById(R.id.id_change_disappear);


        //设置check监听
        mAppear.setOnCheckedChangeListener(this);
        mChangeAppear.setOnCheckedChangeListener(this);
        mDisAppear.setOnCheckedChangeListener(this);
        mChangeDisAppear.setOnCheckedChangeListener(this);


        // GridLayout 按钮添加动画
        // 创建一个GridLayout
        mGridLayout = new GridLayout(this);
        // 设置每列5个按钮
        mGridLayout.setColumnCount(5);
        // 添加到布局中

        viewGroup.addView(mGridLayout);

        //默认动画全部开启
        mTransition = new LayoutTransition();
        mGridLayout.setLayoutTransition(mTransition);

    }

    /**
     * ViewAnimationUtils.createCircularReveal()
     * 快速实现圆形缩放动画的api
     * <p>
     * 属性动画模仿-->兼容低版本
     *
     * @param v
     */
    public void circularReveal(View v) {
        ObjectAnimator horizontal = ObjectAnimator.ofFloat( //缩放X 轴的
                mLl, "scaleX", 0, 200);
        ObjectAnimator vertical = ObjectAnimator.ofFloat(//缩放Y 轴的
                mLl, "scaleY", 0, 200);
        // 动画合集
        AnimatorSet set = new AnimatorSet();

        set.setDuration(500);//设置播放时间

        set.setInterpolator(new LinearInterpolator());//设置播放模式，这里是平常模式

        set.playTogether(horizontal, vertical);//设置一起播放
        set.start();
    }

    /**
     * PathInterpolator动画插入器
     * 这个插入器指定了一个1x1正方形运动曲线，它使用(0,0)为锚点，(1,1)为控制点，作为构造函数的参数。
     *
     * @param v
     */
    public void a(View v) {

        // 路径 path
        Path path = new Path();
        // 移动到 坐标 (100,100)
        path.moveTo(100, 100);
        // 四方 x1,y1,x2,y2
        // x轴: 100 -> 1000 -> 300
        // y轴: 100 -> 300  -> 0
        path.quadTo(1000, 300, 300, 0);
        ObjectAnimator mAnimator = ObjectAnimator.ofFloat(iv, View.X, View.Y, path);

        // 路径插入起
        Path p = new Path();
        // 必须从 (0.0) -> (1,1)
        p.lineTo(0.6f, 0.9f);
        p.lineTo(0.75f, 0.2f);
        p.lineTo(1f, 1f);
        mAnimator.setInterpolator(new PathInterpolator(p));
        mAnimator.setDuration(3000);
        mAnimator.start();
    }

    /**
     * 透明度
     *
     * @param view
     */
    public void alpha(View view) {
        //      iv.setAlpha(alpha);
        //      iv.getAlpha()

        ObjectAnimator oa = ObjectAnimator.ofFloat(iv,
                "alpha", 0.0f, 0.2f, 0.4f, 0.6f, 0.8f, 1.0f);
        oa.setDuration(4000);
        oa.setRepeatMode(ObjectAnimator.REVERSE);
        oa.setRepeatCount(ObjectAnimator.INFINITE);
        oa.start();

    }

    /**
     * 旋转动画
     *
     * @param view
     */
    public void rotate(View view) {
        //iv.setRotationY(rotationY)
        ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "rotationX",
                0.0f, 30f, 60.0f, 90f);
        oa.setDuration(2000);
        oa.setRepeatMode(ObjectAnimator.REVERSE);
        oa.setRepeatCount(ObjectAnimator.INFINITE);
        oa.start();
    }

    /**
     * 缩放
     *
     * @param view
     */
    public void scale(View view) {
        //iv.setScaleX()
        ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "scaleY", 0.0f, 0.2f, 0.5f, 2.0f);
        oa.setDuration(2000);
        oa.setRepeatMode(ObjectAnimator.REVERSE);
        oa.setRepeatCount(ObjectAnimator.INFINITE);
        oa.start();
    }

    /**
     * 位移
     * 动画播放完毕，将其删除
     *
     * @param view
     */
    public void trans(View view) {
        //iv.setScaleX()
        //iv.setTranslationX()
        ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "translationX", 0.0f, 30f, 60f, 200f);
        oa.setDuration(2000);
        oa.setRepeatMode(ObjectAnimator.REVERSE);
        oa.setRepeatCount(2);
        oa.start();

        //重写全部方法
        oa.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

                ViewGroup parent = (ViewGroup) iv.getParent();
                if (parent != null) {
                    parent.removeView(iv);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        //重写部分方法
        oa.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }
        });
    }

    public void set(View view) {


        PropertyValuesHolder pvhX = PropertyValuesHolder
                .ofFloat("alpha", 1f, 0f, 1f);
        PropertyValuesHolder pvhY = PropertyValuesHolder
                .ofFloat("scaleX", 1f, 0, 1f);
        PropertyValuesHolder pvhZ = PropertyValuesHolder
                .ofFloat("scaleY", 1f, 0, 1f);
//        ObjectAnimator
//                .ofPropertyValuesHolder(iv, pvhX, pvhY, pvhZ)
//                .setDuration(3000)
//                .start();


        System.out.println("---");

        //动画的集合
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "rotation", 0.0f, 30f, 60.0f, 90f);
        oa.setDuration(4000);
        ObjectAnimator oa2 = ObjectAnimator.ofFloat(iv, "translationX", 0.0f, 10f, 20, 40f, 60f, 100f, 200f, 600f);
        oa2.setDuration(2000);
        //有序
        //set.playSequentially(oa, oa2);
        //一起
        //set.playTogether(oa,oa2);

       /*
        让
            scaleYAnimator、
            scaleXAnimator、
            rotationXAnimator
        同时执行执行完之后执行alphaAnimator
        set.play(scaleXAnimator).with(scaleYAnimator);
        set.play(scaleYAnimator).with(rotationXAnimator);
        set.play(alphaAnimator).after(rotationXAnimator);
        */
        set.start();
    }


    /**
     * ValueAnimator设置属性动画
     *
     * @param view
     */
    public void value(View view) {

        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 600);
        valueAnimator.setDuration(3000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (Float) animation.getAnimatedValue();

                iv.setTranslationX(value);
                iv.setTranslationY(value);
            }
        });
        valueAnimator.start();
    }


    /**
     * xml配置属性动画
     *
     * @param view
     */
    public void xml(View view) {

        Animator animator = AnimatorInflater.loadAnimator(MainActivity.this,
                R.animator.animator_set);
        animator.setTarget(iv);
        animator.start();
    }

    /**
     * 抛物线
     * 重写估值器
     * 使用线性插值器
     *
     * @param view
     */
    public void paowuxian(View view) {
        ValueAnimator valueAnimator = new ValueAnimator();
        // 执行时间
        valueAnimator.setDuration(3000);
        // (0,0) 起始点
        valueAnimator.setObjectValues(new PointF(0, 0));
        // 线性插值器
        valueAnimator.setInterpolator(new LinearInterpolator());
        // 自定义估值器
        valueAnimator.setEvaluator(new TypeEvaluator<PointF>() {
            // fraction = t / duration
            @Override
            public PointF evaluate(float fraction, PointF startValue,
                                   PointF endValue) {
                // x方向200px/s ，则y方向0.5 * 10 * t
                PointF point = new PointF();
                point.x = 200 * fraction * 3;
                point.y = 0.5f * 200 * (fraction * 3) * (fraction * 3);
                return point;
            }
        });
        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                PointF point = (PointF) animation.getAnimatedValue();
                iv.setX(point.x);
                iv.setY(point.y);
            }
        });
    }

    /**
     * 简单的实现动画
     * 需要高版本 api
     *
     * @param view
     */
    public void easyT(View view) {
        // need API12
        iv.animate()
                .alpha(0)
                .y(mScreenHeight / 2)
                .setDuration(1000)
                // need API 12
                .withStartAction(new Runnable() {
                    @Override
                    public void run() {
                        // 主线程
                    }
                    // need API 16
                })
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        // 主线程
                        iv.setY(0);
                        iv.setAlpha(1.0f);
                    }
                }).start();
    }

    /**
     * 添加按钮
     *
     * @param view
     */
    public void addBtn(View view) {
        final Button button = new Button(this);
        button.setText((++mVal) + "");
        int min = Math.min(1, mGridLayout.getChildCount());
        mGridLayout.addView(button, min);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGridLayout.removeView(button);
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        mTransition = new LayoutTransition();
        mTransition.setAnimator(
                //当一个View在ViewGroup中出现时，对此View设置的动画
                LayoutTransition.APPEARING,
                (mAppear.isChecked() ?
                        //自定义动画
                        //ObjectAnimator.ofFloat(this, "scaleX", 0, 1)
                        mTransition.getAnimator(LayoutTransition.APPEARING)
                        : null));
        mTransition.setAnimator(
                //当一个View在ViewGroup中出现时，对此View对其他View位置造成影响，对其他View设置的动画
                LayoutTransition.CHANGE_APPEARING,
                (mChangeAppear.isChecked() ?
                        mTransition.getAnimator(LayoutTransition.CHANGE_APPEARING)
                        : null));
        mTransition.setAnimator(
                //当一个View在ViewGroup中消失时，对此View设置的动画
                LayoutTransition.DISAPPEARING,
                (mDisAppear.isChecked() ?
                        mTransition.getAnimator(LayoutTransition.DISAPPEARING)
                        : null));
        mTransition.setAnimator(
                //当一个View在ViewGroup中消失时，对此View对其他View位置造成影响，对其他View设置的动画
                LayoutTransition.CHANGE_DISAPPEARING,
                (mChangeDisAppear.isChecked() ?
                        mTransition.getAnimator(LayoutTransition.CHANGE_DISAPPEARING)
                        : null));
        // 为容器设置动画
        mGridLayout.setLayoutTransition(mTransition);
    }
}
