package com.example.newrecycleviewdemo.activity;

import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.newrecycleviewdemo.R;
import com.example.newrecycleviewdemo.adapter.AdapterFactory;
import com.example.newrecycleviewdemo.adapter.BaseAdapter;
import com.example.newrecycleviewdemo.presenter.BasePresenter;
import com.example.newrecycleviewdemo.presenter.MyPresenter;
import com.example.newrecycleviewdemo.view.BaseView;

public class MyActivity extends BaseActivity implements BaseView{

    private RecyclerView mRecyclerView;
    private BaseAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private int menuItemId;

    @Override
    protected void initView() {
        mRecyclerView = findViewById(R.id.recycler_view);
    }

    @Override
    protected BasePresenter initPresenter() {
        //mView = new MyView();
        return new MyPresenter(this);
    }

    @Override
    protected void dispatchMenuItem(int itemId) {
        menuItemId = itemId;
        //具体分配逻辑移到presenter中
        //basePresenter.dispatcherItem(itemId);
        if(itemId!=0)
            setLayoutAndAdapter();
    }

    private void setLayoutAndAdapter() {
        layoutManager = basePresenter.dispatcherItem(menuItemId);
        //这里需要通过工厂模式根据传入的 itemID 获取不同的Adapter
        mAdapter = AdapterFactory.getAdapter(menuItemId,basePresenter.getAdapterData());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected int getMenu() {
        return R.menu.menu;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onPrepare() {
        //初始化presenter，获取数据
        basePresenter.initData();
        basePresenter.setContext(this);

        //设置默认的布局管理器
        mRecyclerView.setLayoutManager(layoutManager == null ?
                basePresenter.dispatcherItem(R.id.list_view_vertical_stander) :
                layoutManager);

        //设置默认适配器
        mRecyclerView.setAdapter(mAdapter == null ?
                AdapterFactory.getAdapter(R.id.list_view_vertical_stander , basePresenter.getAdapterData()):
                mAdapter);
    }


    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void refreshAdapter() {

        //mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onEmpty() {
    }
}
