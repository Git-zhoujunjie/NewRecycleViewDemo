package com.example.newrecycleviewdemo;

public interface ViewCallBack<T> {

    void Success(T t);

    void onFail(String code);
}
