package com.zhy.adapter.abslistview.base;

import android.support.v4.util.SparseArrayCompat;

import com.zhy.adapter.abslistview.ViewHolder;


/**
 *
 * 具体的item的类型管理器
 * Created by zhy on 16/6/22.
 */
public class ItemViewDelegateManager<T>
{
    SparseArrayCompat<ItemViewDelegate<T>> delegates = new SparseArrayCompat();



    /**
     * 向SparseArrayCompat集合中添加类型
     * @param delegate
     * @return
     */
    public ItemViewDelegateManager<T> addDelegate(ItemViewDelegate<T> delegate)
    {
        int viewType = delegates.size();
        if (delegate != null)
        {
            delegates.put(viewType, delegate);//SparseArrayCompat集合最后一个位置，添加新的item类型
            viewType++;
        }
        return this;
    }

    public ItemViewDelegateManager<T> addDelegate(int viewType, ItemViewDelegate<T> delegate)
    {
        if (delegates.get(viewType) != null)
        {
            throw new IllegalArgumentException(
                    "An ItemViewDelegate is already registered for the viewType = "
                            + viewType
                            + ". Already registered ItemViewDelegate is "
                            + delegates.get(viewType));
        }
        delegates.put(viewType, delegate);
        return this;
    }

    /**
     * 根据value移除具体位置的种类
     * @param delegate
     * @return
     */
    public ItemViewDelegateManager<T> removeDelegate(ItemViewDelegate<T> delegate)
    {
        if (delegate == null)
        {
            throw new NullPointerException("ItemViewDelegate is null");
        }
        int indexToRemove = delegates.indexOfValue(delegate);

        if (indexToRemove >= 0)
        {
            delegates.removeAt(indexToRemove);

         /*   SparseArray<String> stringSparseArray = new SparseArray<>();
            stringSparseArray.removeAt();*/

        }
        return this;
    }

    /**
     * 根据key移除具体位置的种类
     * @param itemType
     * @return
     */
    public ItemViewDelegateManager<T> removeDelegate(int itemType)
    {
        int indexToRemove = delegates.indexOfKey(itemType);

        if (indexToRemove >= 0)
        {
            delegates.removeAt(indexToRemove);
        }
        return this;
    }


    public void convert(ViewHolder holder, T item, int position)
    {
        int delegatesCount = delegates.size();
        for (int i = 0; i < delegatesCount; i++)
        {
            ItemViewDelegate<T> delegate = delegates.valueAt(i);

            if (delegate.isForViewType(item, position))
            {
                delegate.convert(holder, item, position);
                return;
            }
        }
        throw new IllegalArgumentException(
                "No ItemViewDelegateManager added that matches position=" + position + " in data source");
    }

    /**
     * 返回SparseArrayCompat集合中存储的item类型个数
     * @return
     */
    public int getItemViewDelegateCount()
    {
        return delegates.size();
    }


    public int getItemViewLayoutId(int viewType)
    {
        return delegates.get(viewType).getItemViewLayoutId();
    }

    public int getItemViewLayoutId(T item, int position)
    {
        return getItemViewDelegate(item,position).getItemViewLayoutId();
    }

    public int getItemViewType(ItemViewDelegate itemViewDelegate)
    {
        return delegates.indexOfValue(itemViewDelegate);
    }



    public ItemViewDelegate getItemViewDelegate(T item, int position)
    {
        int delegatesCount = delegates.size();
        for (int i = delegatesCount - 1; i >= 0; i--)
        {
            ItemViewDelegate<T> delegate = delegates.valueAt(i);
            if (delegate.isForViewType(item, position))
            {
                return delegate;
            }
        }
        throw new IllegalArgumentException(
                "No ItemViewDelegate added that matches position=" + position + " in data source");
    }


    public int getItemViewType(T item, int position)
    {
        int delegatesCount = delegates.size();
        for (int i = delegatesCount - 1; i >= 0; i--)
        {
            ItemViewDelegate<T> delegate = delegates.valueAt(i);
            if (delegate.isForViewType(item, position))
            {
                return delegates.keyAt(i);
            }
        }
        throw new IllegalArgumentException(
                "No ItemViewDelegate added that matches position=" + position + " in data source");
    }

}
