package www.wjz.com.lunbotu;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zhy.http.okhttp.OkHttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import okhttp3.Response;
import www.wjz.com.lunbotu.adapter.BannerAdapter;
import www.wjz.com.lunbotu.utils.PicUtil;

public class CyclePic extends AppCompatActivity {

    private DisplayImageOptions      options;
    private ScheduledExecutorService mScheduledExecutorService;
    private ViewPager                mViewPager;
    private List<String>             mImageList;
    // 广告栏小点
    private List<View>               mDotsList;
    private BannerAdapter            mBannerAdapter;
    private       AtomicInteger atomicInteger = new AtomicInteger(0);//初始值 0
    /**
     * 切换当前显示的图片
     */
    private final Handler       viewHandler   = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            mViewPager.setCurrentItem(msg.what);

            System.out.println("msg.what:    " + msg.what);

            super.handleMessage(msg);
        }

    };
    private LinearLayout mDotsGroupLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //getSupportFragmentManager();

        mDotsGroupLayout = (LinearLayout) findViewById(R.id.viewGroup);


        //配置图片加载的参数
        options = new DisplayImageOptions.Builder()
                //设置图片在下载期间显示的图片
                .showImageOnLoading(R.mipmap.banner_default)
                //设置图片Uri为空或是错误的时候显示的图片
                .showImageForEmptyUri(R.mipmap.banner_default)
                //设置图片加载/解码过程中错误时候显示的图片
                .showImageOnFail(R.mipmap.banner_default)
                //设置下载的图片是否缓存在内存中
                .cacheInMemory(true)
                //设置下载的图片是否缓存在SD卡中
                .cacheOnDisk(true)
                //设置图片以如何的编码方式显示
                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
                //设置图片的解码类型//
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
        //System.out.println("-2");
        initViewPager();

        initEvent();
    }

    private void initEvent() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            private int oldPosition = 0;

            /**
             * 页面滚动的时候触发
             */
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            /**
             * 页面选中的时候触发
             */
            @Override
            public void onPageSelected(int position) {

                System.out.println("onPageSelected:   " + position);

                // 获取当前显示的页面是哪个页面
                atomicInteger.getAndSet(position);
                mDotsList.get(oldPosition).setBackgroundResource(
                        R.mipmap.home_banner_next_dot);
                mDotsList.get(position).setBackgroundResource(
                        R.mipmap.home_banner_current_dot);
                oldPosition = position;
            }

            /**
             * 页面滚动状态发生改变的时候触发
             */
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 初始化点
     */
    private void initCirclePoint() {

        mDotsList = new ArrayList<View>();

        try {
            mDotsGroupLayout.removeAllViews();
        } catch (Exception ex) {

        }

        LinearLayout.LayoutParams pl = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        pl.setMargins(5, 0, 5, 0);


        // 广告栏的小圆点图标
        for (int i = 0; i < mImageList.size(); i++) {
            LinearLayout lay = new LinearLayout(CyclePic.this);
            lay.setLayoutParams(pl);
            // 初始值, 默认第0个选中
            if (i == 0) {
                lay.setBackgroundResource(R.mipmap.home_banner_current_dot);
            } else {
                lay.setBackgroundResource(R.mipmap.home_banner_next_dot);
            }

            // 将小圆点放入到布局中
            mDotsGroupLayout.addView(lay);
            mDotsList.add(lay);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        //初始6s， 6s切换
        mScheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        mScheduledExecutorService.scheduleAtFixedRate(
                new CycleTask(), 3, 3, TimeUnit.SECONDS);
        System.gc();
    }

    @Override
    protected void onStop() {
        //当Activity不可见的时候停止切换
        mScheduledExecutorService.shutdown();
        super.onStop();
    }

    /**
     * 初始化轮播图
     */
    private void initViewPager() {
        // System.out.println("-1");
        RelativeLayout cyclePicContainer = (RelativeLayout) findViewById(R.id.rl_main);

        mViewPager = new ViewPager(getApplicationContext());
        //获取调整后的适应屏幕的宽度
        int adjustImageHeight = PicUtil.getAdjustImageHeight(getResources(), R.mipmap.banner_default, getApplicationContext());

        //根据宽高比设置广告栏的高度
        int width  = PicUtil.getDevScreenWidth(getApplicationContext());
        int height = adjustImageHeight;

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, height);
        mViewPager.setLayoutParams(layoutParams);
        mViewPager.setBackgroundColor(Color.BLACK);
        cyclePicContainer.addView(mViewPager);

        // System.out.println("0");
        //初始化轮播图的PagerAdapter
        initPagerAdapter();

    }

    /**
     * 初始化轮播图的Apdater
     */
    private void initPagerAdapter() {
        // System.out.println("1");
        mImageList = new ArrayList<>();
        mImageList.add("http://app.bac365.com:10080/bac/app/picture.action?id=138");
        mImageList.add("http://app.bac365.com:10080/bac/app/picture.action?id=139");
        mImageList.add("http://app.bac365.com:10080/bac/app/picture.action?id=140");
        mImageList.add("http://app.bac365.com:10080/bac/app/picture.action?id=141");
        mImageList.add("http://pay.bac365.com:10080/app.pay/images/recharge.jpg");
        initCirclePoint();
        mBannerAdapter = new BannerAdapter(getApplicationContext(), mImageList, options);
        mViewPager.setAdapter(mBannerAdapter);
    }

    /**
     * 轮播图切换的任务
     */
    private class CycleTask implements Runnable {
        public void run() {
            synchronized (mViewPager) {
                atomicOption();
                viewHandler.sendEmptyMessage(atomicInteger.get());
            }
        }
    }

    private void atomicOption() {
        atomicInteger.incrementAndGet();// 以原子方式将当前值加 1。
        if (atomicInteger.get()//获取当前值。
                > mImageList.size() - 1) {
            atomicInteger.getAndAdd(//以原子方式将给定值与当前值相加。
                    -mImageList.size());
        }
    }


    public void btn1(View view) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = OkHttpUtils
                            .post()
                            .url("http://app.bac365.com:10080/bac/app/mobile_security_check")
                            .addParams("username", "13641536078")
                            .addParams("password", "wjz123")
                            .addParams("gesture", "false")

                            .build()
                            .execute();

                    System.out.println("response：   " + response);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("e：   " + e.getMessage());
                }
            }
        }).start();
    }
}
