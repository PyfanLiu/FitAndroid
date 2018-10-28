package com.lvable.vectorcard;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RelativeLayout layout = (RelativeLayout) findViewById(R.id.card_content);
        final TextView textView = (TextView) findViewById(R.id.tv_content);
        final Button btn = (Button) findViewById(R.id.button);

        /*
        SVG动画尺寸过大这种方法不是Android SVG推荐的用法,SVG动画尺寸应该尽可能的小,

        原因：因为每次动画都会先把这些path先计算绘成Bitmap,

        然后上传texture到GPU,如果SVG太大意味着生成更大的Bitmap,

        占更多内存,消耗更多时间.

        Google的推荐是把SVG用于图标(icon)和按钮(Button),

        只有需要的时候才修改Vector的属性(比如alpha,width,height),

        因为如果SVG不用于动画,android会把这个图生成一个Cache来节省时间,

        如果使用SVG动画这个Cache就没有用了。

        如果要用SVG动画，请确保它“短小精悍”（Short and sweet）。
        * */

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                ImageView的src改成animate_rect就行了
                Drawable drawable = play.getDrawable();
                * */
                Drawable drawable = layout.getBackground();
                if (drawable instanceof Animatable) {
                    textView.setVisibility(View.INVISIBLE);

                    //执行动画
                    ((Animatable) drawable).start();

                    btn.setVisibility(View.VISIBLE);
                    btn.animate()
                            .alpha(1)
                            .scaleX(1.1f)
                            .scaleY(1.1f)
                            .setInterpolator(new AccelerateInterpolator())
                            .setDuration(350)
                            .start();

                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, VectorIconActivity.class);
                startActivity(intent);
            }
        });

    }


}
