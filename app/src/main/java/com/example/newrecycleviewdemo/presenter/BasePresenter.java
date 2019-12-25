package com.example.newrecycleviewdemo.presenter;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.example.newrecycleviewdemo.adapter.BaseAdapter;

import java.util.List;

public interface BasePresenter<T> {

    void initData();

    List<T> getAdapterData();

    RecyclerView.LayoutManager dispatcherItem(int itemId);

    void setContext(Context context);

    void defaultView();


    //void setLayoutAndAdapter(RecyclerView.LayoutManager layoutManager, BaseAdapter mAdapter);
}
