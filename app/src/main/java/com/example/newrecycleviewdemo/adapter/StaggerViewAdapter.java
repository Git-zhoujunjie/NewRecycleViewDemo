package com.example.newrecycleviewdemo.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.example.newrecycleviewdemo.R;
import com.example.newrecycleviewdemo.beans.ItemBean;

import java.util.List;

public class StaggerViewAdapter extends BaseAdapter {

    public StaggerViewAdapter(List<ItemBean> data) {
        super(data);
    }

    @Override
    protected View getSubView(ViewGroup parent, int viewType) {
        return View.inflate(parent.getContext(), R.layout.item_stagger_view,null);
        //return null;
    }
}
