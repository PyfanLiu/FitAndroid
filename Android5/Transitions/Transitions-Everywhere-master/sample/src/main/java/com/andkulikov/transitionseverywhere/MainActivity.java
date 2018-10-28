/*
 * Copyright (C) 2016 Andrey Kulikov (andkulikov@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.andkulikov.transitionseverywhere;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListFragment listFragment = new ListFragment();
        listFragment.setSampleListListener(new ListFragment.SampleListProvider() {
            @Override
            public void onSampleSelected(int index) {

                getSupportFragmentManager()
                        .beginTransaction()
                        // fragment 转场动画
                        .setCustomAnimations(
                                R.anim.fade_in,
                                R.anim.fade_out,
                                R.anim.fade_in,
                                R.anim.fade_out)
                        .replace(R.id.container, createFragmentForPosition(index))
                        /*
                        将此事务添加到后退堆栈。
                        这意味着事务在被执行后将被记住，
                        并且在稍后弹出堆栈时将会颠倒其操作。

                        @param name 此返回堆栈状态的可选名称，或者为null。
                         */
                        .addToBackStack(String.valueOf(index))// 0，1，2，3 ....
                        .commit();
            }

            @Override
            public String getTitleForPosition(int index) {
                switch (index) {
                    case 0:
                        return "Simple animations with AutoTransition\n使用AutoTransition进行简单的动画";
                    case 1:
                        return "Interpolator, duration, start delay\n内插器，持续时间，启动延迟";
                    case 2:
                        return "Path motion\n路径的议案";
                    case 3:
                        return "Slide transition\n幻灯片转换";
                    case 4:
                        return "Scale transition\n缩放转换";
                    case 5:
                        return "Explode transition and epicenter\n爆炸过渡和震中";
                    case 6:
                        return "Transition names\n过渡名称";
                    case 7:
                        return "Change Image Transform transition\n更改图像变换过渡";
                    case 8:
                        return "Recolor transition\n重新着色过渡";
                    case 9:
                        return "Rotate transition\n旋转过渡";
                    case 10:
                        return "Change text transition\n更改文字转换";
                    case 11:
                        return "Custom transition\n自定义转换";
                    case 12:
                        return "Scene to scene transitions\n场景到场景转换";
                }
                return null;
            }

            @Override
            public int getSampleCount() {
                return 13;
            }
        });

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, listFragment)
                .commit();
    }

    private Fragment createFragmentForPosition(int index) {
        switch (index) {
            case 0:
                return new AutoTransitionSample();
            case 1:
                return new InterpolatorDurationStartDelaySample();
            case 2:
                return new PathMotionSample();
            case 3:
                return new SlideSample();
            case 4:
                return new ScaleSample();
            case 5:
                return new ExplodeAndEpicenterExample();
            case 6:
                return new TransitionNameSample();
            case 7:
                return new ImageTransformSample();
            case 8:
                return new RecolorSample();
            case 9:
                return new RotateSample();
            case 10:
                return new ChangeTextSample();
            case 11:
                return new CustomTransitionSample();
            case 12:
                return new ScenesSample();
        }
        return null;
    }

}
