package com.example.www.recycleview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.www.recycleview.Beans.DataBean;
import com.example.www.recycleview.R;

import java.util.List;

/**
 * @author Wjz
 * @version $Rev
 * @time 2016/4/7 17:30
 * @des ${TODO}
 * @updateAuthor $Author
 * @updateDate $Date
 * @updateDes ${TODO}
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context        mContext;
    private List<DataBean> mDataBeans;

    public MyAdapter (Context context, List<DataBean> dataBeans) {
        mContext = context;
        mDataBeans = dataBeans;
    }

    @Override
    public ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        //当itemView创建时的回调
        View view = View.inflate (mContext, R.layout.item_recycleview, null);
        return new ViewHolder (view);
    }

    @Override
    public void onBindViewHolder (ViewHolder holder, int position) {
        //正在加载某个view时的回调
        holder.setData (mDataBeans.get (position));
    }

    @Override
    public int getItemCount () {
        //返回item显示的个数
        if (mDataBeans!=null){
            return mDataBeans.size ();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private  ImageView mIv;
        private  TextView mTv;

        public ViewHolder (View itemView) {
            super (itemView);
            mIv = (ImageView) itemView.findViewById (R.id.item_list_iv);
            mTv = (TextView) itemView.findViewById (R.id.item_list_tv);
        }

        public void setData(DataBean bean){
            mIv.setImageResource (bean.icon);
            mTv.setText (bean.content);
        }
    }
}
