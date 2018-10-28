package www.wjz.com.lunbotu.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by Wjz on 2016/7/1.
 */
public class PicUtil {

    /**
     * 获取设备宽度 px
     *
     * @param context
     * @return 设备高度
     */
    public static int getDevScreenWidth(Context context) {

        WindowManager  windowManager  = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;

    }


    /**
     * 获取设备高度 px
     *
     * @param context
     * @return 设备高度
     */
    public static int getDevScreenHeight(Context context) {
        WindowManager  windowManager  = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    /**
     * 获取设备屏幕密度
     *
     * @param context
     * @return 屏幕密度
     */
    public static float getDevScreenDensity(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.density;
    }

    /**
     * 获取调整后的图片的宽度
     *
     * @param res
     * @param resId
     * @param context
     * @return 图片适配的高度
     */
    public static int getAdjustImageWidth(Resources res, int resId, Context context) {

        //1.不加载图片，仅获取图片尺寸
        BitmapFactory.Options options = new BitmapFactory.Options();

        //2.inJustDecodeBounds设为true时,不会加载图片仅获取图片尺寸信息
        options.inJustDecodeBounds = true;

        //3.将图片信息会保存至options对象内,decode方法不会返回bitmap对象
        BitmapFactory.decodeResource(res, resId, options);
        float resWidth  = options.outWidth;
        float resHeight = options.outHeight;
        //宽高比
        float wRatioH = resWidth / resHeight;

        //设备屏幕的宽度
        int devScreenHeight = getDevScreenHeight(context);

        return (int) (devScreenHeight * wRatioH);
    }


    /**
     * 获取调整后的图片的高度
     *
     * @param res
     * @param resId
     * @param context
     * @return 图片适配的高度
     */
    public static int getAdjustImageHeight(Resources res, int resId, Context context) {

        //1.不加载图片，仅获取图片尺寸
        BitmapFactory.Options options = new BitmapFactory.Options();

        //2.inJustDecodeBounds设为true时,不会加载图片仅获取图片尺寸信息
        options.inJustDecodeBounds = true;

        //3.将图片信息会保存至options对象内,decode方法不会返回bitmap对象
        BitmapFactory.decodeResource(res, resId, options);
        float resWidth  = options.outWidth;
        float resHeight = options.outHeight;
        //宽高比
        float hRatioW = resHeight / resWidth;

        //设备屏幕的宽度
        int devScreenWidth = getDevScreenWidth(context);

        return (int) (devScreenWidth * hRatioW);
    }


}
