package www.wjz.com.lunbotu.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.List;

/**
 * Created by Wjz on 2016/7/1.
 */
public class BannerAdapter extends PagerAdapter {

    private List<String>        list;
    private Context             context;
    private DisplayImageOptions options;

    public BannerAdapter(Context context, List<String> list, DisplayImageOptions options) {
        this.context = context;
        this.list = list;
        this.options = options;
    }

    @Override
    public int getCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //  System.out.println("2");
        System.out.println("position:    " + position);
        ImageView imageView = new ImageView(context);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        imageView.setLayoutParams(params);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);

        //图片加载
        ImageLoader imageLoader = ImageLoader.getInstance();
        System.out.println("list.get(position):   " + list.get(position));
        imageLoader.displayImage(list.get(position), imageView, options, new SimpleImageLoadingListener());

        container.addView(imageView);

        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        //super.destroyItem(container, position, object);
    }

}
