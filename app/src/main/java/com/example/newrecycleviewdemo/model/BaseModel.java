package com.example.newrecycleviewdemo.model;

import com.example.newrecycleviewdemo.ViewCallBack;
import com.example.newrecycleviewdemo.beans.ItemBean;

import java.util.List;

/**
 * Model层
 * 数据的获取
 */
public interface BaseModel {

    void getTestData();

    List<ItemBean> getAdapterData();
}
