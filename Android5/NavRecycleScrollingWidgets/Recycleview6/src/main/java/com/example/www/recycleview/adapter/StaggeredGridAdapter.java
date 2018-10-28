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
 * @time 2016/4/7 21:09
 * @des ${TODO}
 * @updateAuthor $Author
 * @updateDate $Date
 * @updateDes ${TODO}
 */
public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridAdapter.ViewHolder> {

    private Context mContext;
    private List<DataBean> datas;

    public StaggeredGridAdapter (Context context, List<DataBean> datas) {
        mContext = context;
        this.datas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View view = View.inflate (mContext, R.layout.item_staggeredgrid, null);

        return new ViewHolder (view);
    }

    @Override
    public void onBindViewHolder (ViewHolder holder, int position) {

        holder.setData (datas.get (position));
    }

    @Override
    public int getItemCount () {
        if(datas!=null){
            return datas.size ();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mIv;
        private final TextView mTv;

        public ViewHolder (View itemView) {
            super (itemView);
            mIv = (ImageView) itemView.findViewById (R.id.item_straggered_iv);
            mTv = (TextView) itemView.findViewById (R.id.item_straggered_tv);
        }


        /**
         *
         * 设置itemView的数据展示
         * @param dataBean
         */
        public void setData(DataBean dataBean){
            mIv.setImageResource (dataBean.icon);
            mTv.setText (dataBean.content);
        }
    }
}
