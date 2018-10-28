# BaseRecyclerViewAdapterHelper
## 版本变化
 ### 一期
    1. BaseRecyclerViewAdapterHelper-1.0
    2. BaseRecyclerViewAdapterHelper-1.1

### 二期

    1. BaseRecyclerViewAdapterHelper-1.2
    	在1.2上迭代增加Animation
    2. BaseRecyclerViewAdapterHelper-1.3
### 三期
    1. BaseRecyclerViewAdapterHelper-1.4
    	在1.3上迭代增加Header 和 Footer 和 loadmore
### 四期
	1. BaseRecyclerViewAdapterHelper-1.5
		在1.4上增加 section
### 五期
	1. BaseRecyclerViewAdapterHelper-1.5.1
		优化 onBindViewHolder() 方法
		在 1.5 上增加 MultipleItem（后期被废掉）
	2. BaseRecyclerViewAdapterHelper-1.5.2
		性能优化
### 六期
	1. BaseRecyclerViewAdapterHelper-1.5.3
		在 1.5.1 的基础上 增加 BaseMultiItemQuickAdapter并废弃 MultipleItem
	2. BaseRecyclerViewAdapterHelper-1.5.4
### 七期
	1. BaseRecyclerViewAdapterHelper-1.5.5
		在 1.5.3 中 增加 setEmptyView methods
	2. BaseRecyclerViewAdapterHelper-1.5.6
	3. BaseRecyclerViewAdapterHelper-1.5.7
		迭代在 adapter 上添加 点击事件
	4. BaseRecyclerViewAdapterHelper-1.5.8
		修复 emptyView 上的bug
	5. BaseRecyclerViewAdapterHelper-1.5.9
### 八期
	1. BaseRecyclerViewAdapterHelper-1.6
		在 1.5.9 修改 加载更多的逻辑
	2. BaseRecyclerViewAdapterHelper-1.6.1
	3. BaseRecyclerViewAdapterHelper-1.6.2
		修复 局部刷新notifityAdapter时 position 位置不对的问题，将 onBindViewHolder 的 position  改为 holder.getLayoutPostition
### 九期
	1. BaseRecyclerViewAdapterHelper-1.6.3
		从 1.6.2 中修改 onCreateViewHolder 恢复原来的 使用viewType 判断 holder 的类型
	2. BaseRecyclerViewAdapterHelper-1.6.4
		修改 loadmore 和 增加 longclick
	3. BaseRecyclerViewAdapterHelper-1.6.5
		增加 构造方法
	4. BaseRecyclerViewAdapterHelper-1.6.6
	5. BaseRecyclerViewAdapterHelper-1.6.7
		增加 自定义 loadmore
	6. BaseRecyclerViewAdapterHelper-1.6.8
		After loading more add no data suggest
	7. BaseRecyclerViewAdapterHelper-1.6.8
	8. BaseRecyclerViewAdapterHelper-1.6.9
		rm en strings => app_name
		修改点击事件的绑定位置
	9. BaseRecyclerViewAdapterHelper-1.7.0
		修复 当用StaggeredGridLayoutManager时用使用emptyview时不能占整行
		setEmptyView 没有考虑StaggeredGridLayoutManager或者GridLayoutManager的情况可以考虑在重写onViewAttachedToWindow
	10. BaseRecyclerViewAdapterHelper-1.7.1
		修复 头 尾 和 emptyView 的填充
	11. BaseRecyclerViewAdapterHelper-1.7.2
		Add HeadViewandEmptyView Case
	12. BaseRecyclerViewAdapterHelper-1.7.3
		removeHeaderView()、removeFooterView() =》 addHeaderView(null)、addFooterView(null)
	13. BaseRecyclerViewAdapterHelper-1.7.4
		fix Multipleltem add headview bug 
		recyclerView 源码中
		```
			public int getItemViewType(int position) {
	       		return 0;
	    	}
		```
		getItemViewType 方法返回 0，貌似无效
	14. BaseRecyclerViewAdapterHelper-1.7.5
		setNewData() add resetLastPosition，影响在新数据更新后，动画播放问题
	15. BaseRecyclerViewAdapterHelper-1.7.6
		第一次加入一个空数组Alist之后，第二次 AList 数据改变通知 adapter 刷新 发现无法刷新，追踪源码发现，构造函数把数据源内存地址改变了？ 
	16. BaseRecyclerViewAdapterHelper-1.7.7
		fix load more bug、add a way to set headView and footView and EmptyView
	17. BaseRecyclerViewAdapterHelper-1.7.8
		fix setEmptyView bug , update method name "addItmeType" => "addItemType", library rm compile 'com.android.support:cardview-v7:23.3.0' .
	18. BaseRecyclerViewAdapterHelper-1.7.9
		rm methods
	    setImageUrl(int viewId, String imageUrl)
	    setImageUrl(int viewId, String imageUrl, int defResourceId)
	    setImageUrl(int viewId, String imageUrl, int defResourceId, BitmapTransformation... transformations)
	    rm library 'com.github.bumptech.glide:glide:3.7.0'
	19. BaseRecyclerViewAdapterHelper-1.8.0
		修复 emptyView 在 data.size() = 0 时的显示问题
		remove 'Context' parameter
		Add Method description
	20. BaseRecyclerViewAdapterHelper-1.8.1
		在onItemChildClick 中使用 mQuickAdapter.remove(i); 连续点击非最后一个条目 会出现数据越界问题 而onItemClick 则不存在此问题 请检查相关position 是否计算正确
### 十期
	1. BaseRecyclerViewAdapterHelper-1.8.2
		add drag item
	2. BaseRecyclerViewAdapterHelper-1.8.3
		loadingView 点击能否开放出来,而不是放到itemclick事件中,否则点击itemclick 不做处理会数组越界
	3. BaseRecyclerViewAdapterHelper-1.8.4
		在 1.8.2 的基础上 添加 Add Swipe Item
	4. BaseRecyclerViewAdapterHelper-1.8.5
		Add GridLayoutManager HeaderView support
	5. BaseRecyclerViewAdapterHelper-1.8.6
	6. BaseRecyclerViewAdapterHelper-1.8.7
		Enable draw on the edge when swipe moving
	8. BaseRecyclerViewAdapterHelper-1.8.8
		快速连续多次滑动删除item时bug
	9. BaseRecyclerViewAdapterHelper-1.8.9
		MultiItemEntity implements Serializable
	10. BaseRecyclerViewAdapterHelper-1.9.0
		重构代码，抽取 drag
		Change item drag and swipe function to independent class 
		getData The return type List<T>
	11. BaseRecyclerViewAdapterHelper-1.9.1
		The views create by adapter can not be swiped
	12. BaseRecyclerViewAdapterHelper-1.9.2
		rm android:supportsRtl="true"
	13. BaseRecyclerViewAdapterHelper-1.9.3
		Add multiple header and footer feature
	14. BaseRecyclerViewAdapterHelper-1.9.4
		Add function for OnItemChildLongClickListener
	15. BaseRecyclerViewAdapterHelper-1.9.5
		Fixed the problem that addHeaderView does not show after removeHeaderView. fix #174
	16. BaseRecyclerViewAdapterHelper-1.9.6
	17. BaseRecyclerViewAdapterHelper-1.9.7
		BaseQuickAdapter removeAllHeaderView
	18. BaseRecyclerViewAdapterHelper-1.9.8
		v7包依赖方式
### 十一期
	1. BaseRecyclerViewAdapterHelper-2.0.0
		BaseQuickAdapter
        rm method

        setOnRecyclerViewItemClickListener
        setOnRecyclerViewItemLongClickListener
        setOnRecyclerViewItemChildClickListener
        setOnRecyclerViewItemChildLongClickListener
        openLoadMore
        update

        MultiItemEntity abstract=》interface
        add method

        ItemClickListener
        LongClickListener
        ChildClickListener
        ChildLongClickListener
        setSpanSizeLookup
        showLoadMoreFailedView
        setLoadMoewFailedView
        add Features

        Expandable Item