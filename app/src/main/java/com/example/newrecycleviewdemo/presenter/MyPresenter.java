package com.example.newrecycleviewdemo.presenter;

import android.content.Context;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.newrecycleviewdemo.R;
import com.example.newrecycleviewdemo.ViewCallBack;
import com.example.newrecycleviewdemo.adapter.BaseAdapter;
import com.example.newrecycleviewdemo.beans.ItemBean;
import com.example.newrecycleviewdemo.model.BaseModel;
import com.example.newrecycleviewdemo.model.MyModel;
import com.example.newrecycleviewdemo.view.BaseView;

import java.util.List;

public class MyPresenter implements BasePresenter {

    private BaseView mView;
    private BaseModel mModel;

    private Context mContext;


    public MyPresenter(BaseView baseView) {
        this.mView = baseView;
        mModel = new MyModel();
    }

    @Override
    public void initData() {
        mModel.getTestData();
    }

    @Override
    public List getAdapterData() {
        return mModel.getAdapterData();
    }

    @Override
    public RecyclerView.LayoutManager dispatcherItem(int itemId) {
        RecyclerView.LayoutManager layoutManager = null;
        switch (itemId) {
            case 0:
                break;
            //listview部分
            case R.id.list_view_vertical_stander:
                //Toast.makeText(this,"list view 的垂直标准",Toast.LENGTH_SHORT).show();
                layoutManager = getListLayout(true, false);
                break;
            case R.id.list_view_vertical_reverse:
                layoutManager = getListLayout(true, true);
                break;
            case R.id.list_view_horizontal_stander:
                layoutManager = getListLayout(false, false);
                break;
            case R.id.list_view_horizontal_reverse:
                layoutManager = getListLayout(false, true);
                break;
            //gridview部分
            case R.id.grid_view_vertical_stander:
                //Toast.makeText(this,"list view 的垂直标准",Toast.LENGTH_SHORT).show();
                layoutManager = getGridLayout(true, false);
                break;
            case R.id.grid_view_vertical_reverse:
                layoutManager = getGridLayout(true, true);
                break;
            case R.id.grid_view_horizontal_stander:
                layoutManager = getGridLayout(false, false);
                break;
            case R.id.grid_view_horizontal_reverse:
                layoutManager = getGridLayout(false, true);
                break;
            //stagger部分
            case R.id.stagger_view_vertical_stander:
                //Toast.makeText(this,"list view 的垂直标准",Toast.LENGTH_SHORT).show();
                layoutManager = getStaggerLayoutManager(true, false);
                break;
            case R.id.stagger_view_vertical_reverse:
                layoutManager = getStaggerLayoutManager(true, true);
                break;
            case R.id.stagger_view_horizontal_stander:
                layoutManager = getStaggerLayoutManager(false, false);
                break;
            case R.id.stagger_view_horizontal_reverse:
                layoutManager = getStaggerLayoutManager(false, true);
                break;
        }

        return layoutManager;
    }

    @Override
    public void setContext(Context context) {
        this.mContext = context;
    }

    @Override
    public void defaultView() {
        RecyclerView.LayoutManager layoutManager = getListLayout(true, false);
    }


    private RecyclerView.LayoutManager getListLayout(boolean isVertical, boolean isReverse) {
        //设置Recycle View样式
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        //设置布局
        //设置水平还是垂直
        layoutManager.setOrientation(isVertical ? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL);
        //设置正向还是方向
        layoutManager.setReverseLayout(isReverse);

        return layoutManager;
    }

    private RecyclerView.LayoutManager getGridLayout(boolean isVertical, boolean isReverse) {
        //设置Recycle View样式
        GridLayoutManager layoutManager = new GridLayoutManager(mContext,3);
        //设置布局
        //设置水平还是垂直
        layoutManager.setOrientation(isVertical ? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL);
        //设置正向还是方向
        layoutManager.setReverseLayout(isReverse);

        return layoutManager;
    }

    private RecyclerView.LayoutManager getStaggerLayoutManager(boolean isVertical, boolean isReverse) {
        //创建布局管理器
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, isVertical ?
                StaggeredGridLayoutManager.VERTICAL : StaggeredGridLayoutManager.HORIZONTAL);

        //设置正向还是方向
        layoutManager.setReverseLayout(isReverse);

        return layoutManager;

    }



}
