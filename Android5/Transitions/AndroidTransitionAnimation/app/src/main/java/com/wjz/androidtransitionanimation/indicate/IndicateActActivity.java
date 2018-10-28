package com.wjz.androidtransitionanimation.indicate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wjz.androidtransitionanimation.R;

/**
 * Copyright (c) 2018 SHARP CORPORATION
 *
 * @author wujiazhen
 * @file com.wjz.androidtransitionanimation.indicate.IndicateAct
 * <p>
 * [DESCRIPTION]
 * @change [DATE] [EDITOR] [MODEL] [TYPE] [COMMENT]
 */

public class IndicateActActivity extends AppCompatActivity {

    TextView mTvOne;
    TextView mTvTwo;
    TextView mTvThree;

    LinearLayout mActivityIndicate;
    StatusIndicateLayout mStatusIndicateLayout;

    private int mStep = 0;
    private boolean loading = false; //  用于让第二项加载

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicate);

        mActivityIndicate = (LinearLayout) findViewById(R.id.activity_indicate);
        mStatusIndicateLayout = (StatusIndicateLayout) findViewById(R.id.status_indicate_layout);
        mTvOne = (TextView) findViewById(R.id.tv_one);
        mTvTwo = (TextView) findViewById(R.id.tv_two);
        mTvThree = (TextView) findViewById(R.id.tv_three);

        findViewById(R.id.btn_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click();
            }
        });

        mStatusIndicateLayout.setStep(mStep, StatusIndicateView.LoadingViewStatus.SELECTED);
    }

    public void click() {

        if (mStep == 0) {

            // 步骤布局切换
            mStatusIndicateLayout.setStep(mStep, StatusIndicateView.LoadingViewStatus.SELECTED);

            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(() -> mStatusIndicateLayout.setStep(mStep++, StatusIndicateView.LoadingViewStatus.OK));
            }).start();


        } else if (mStep == 1) {
            if (loading) {
                mStatusIndicateLayout.setStep(mStep, StatusIndicateView.LoadingViewStatus.LOADING);

                new Thread(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    runOnUiThread(() -> mStatusIndicateLayout.setStep(mStep++, StatusIndicateView.LoadingViewStatus.OK));
                }).start();


            } else {
                mStatusIndicateLayout.setStep(mStep, StatusIndicateView.LoadingViewStatus.SELECTED);
                loading = true;
            }

            // 中间切换
            if (mTvOne.getVisibility() == View.VISIBLE) {
                AnimateUtils.slideOutLeft(mTvOne);
            }
            if (mTvTwo.getVisibility() == View.GONE) {
                AnimateUtils.slideInRight(mTvTwo);
            }

        } else if (mStep == 2) {
            mStatusIndicateLayout.setStep(mStep, StatusIndicateView.LoadingViewStatus.SELECTED);

            // 中间切换
            if (mTvTwo.getVisibility() == View.VISIBLE) {
                AnimateUtils.slideOutLeft(mTvTwo);
            }
            if (mTvThree.getVisibility() == View.GONE) {
                AnimateUtils.slideInRight(mTvThree);
            }

        }

    }
}
