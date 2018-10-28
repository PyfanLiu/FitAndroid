package com.wjz.androidtransitionanimation.indicate;

import android.view.View;
import android.view.animation.TranslateAnimation;

/**
 * Copyright (c) 2018 SHARP CORPORATION
 *
 * @author wujiazhen
 * @file com.wjz.androidtransitionanimation.indicate.AnimateUtils
 * <p>
 * [DESCRIPTION]
 * @change [DATE] [EDITOR] [MODEL] [TYPE] [COMMENT]
 */

public class AnimateUtils {


    public static void slideOut(View view, int direction) {


    }

    public static void slideOutLeft(View view) {
        int width = view.getWidth();
        TranslateAnimation translateAnimation = new TranslateAnimation(0, -width, 0, 0);
        translateAnimation.setDuration(500);
        view.startAnimation(translateAnimation);

        view.setVisibility(View.GONE);
    }

    public static void slideInRight(View view) {
        view.setVisibility(View.VISIBLE);

        view.post(() -> {
            int width1 = view.getWidth();
            TranslateAnimation translateAnimation = new TranslateAnimation(width1, 0, 0, 0);
            translateAnimation.setDuration(500);
            view.startAnimation(translateAnimation);
        });


    }
}
