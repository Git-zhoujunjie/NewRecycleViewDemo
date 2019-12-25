package com.example.newrecycleviewdemo.view;

/**
 * View层
 * 主要实现与UI有关的操作
 */
public interface BaseView {

    void showToast(String msg);

    void refreshAdapter();

    void onEmpty();
}
