package www.wjz.com.lunbotu.app;

import android.app.Application;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.utils.StorageUtils;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * 项目名称：lunbotu
 * 包名：www.wjz.com.lunbotu.app
 * 创建人：Wjz
 * 创建时间：2016/8/8
 * 类描述：
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // 创建配置ImageLoader(所有的选项都是可选的,只使用那些你真的想定制)，
        // 这个可以设定在APPLACATION里面，设置为全局的配置参数
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                getApplicationContext())
                // .memoryCacheExtraOptions(480, 800) // max width, max
                // height，即保存的每个缓存文件的最大长宽
                // .discCacheExtraOptions(480, 800, CompressFormat.JPEG, 75,
                // null) // Can slow ImageLoader, use it carefully (Better don't
                // use it)设置缓存的详细信息，最好不要设置这个
                .threadPoolSize(5)
                // 线程池内加载的数量
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                // .memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 *
                // 1024)) // You can pass your own memory cache
                // implementation你可以通过自己的内存缓存实现
                // .memoryCacheSize(2 * 1024 * 1024)
                // /.discCacheSize(50 * 1024 * 1024)
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())// 将保存的时候的URI名称用MD5
                // 加密
                // .discCacheFileNameGenerator(new
                // HashCodeFileNameGenerator())//将保存的时候的URI名称用HASHCODE加密
                .tasksProcessingOrder(QueueProcessingType.FIFO)
                // .discCacheFileCount(100) //缓存的File数量
                .diskCache(
                        new UnlimitedDiskCache(StorageUtils.getOwnCacheDirectory(getApplicationContext(), "imageloader/Cache")))//自定义缓存路径

                // .defaultDisplayImageOptions(DisplayImageOptions.createSimple())
                // .imageDownloader(new BaseImageDownloader(context, 5 * 1000,
                // 30 * 1000)) // connectTimeout (5 s), readTimeout (30 s)超时时间
                .writeDebugLogs() // Remove for release app
                .build();
        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config);// 全局初始化此配置

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)

                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);


    }
}
