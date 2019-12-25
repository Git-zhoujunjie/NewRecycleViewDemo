package com.example.newrecycleviewdemo.model;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

import com.example.newrecycleviewdemo.ViewCallBack;
import com.example.newrecycleviewdemo.beans.Datas;
import com.example.newrecycleviewdemo.beans.ItemBean;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class MyModel implements BaseModel {

    private class MyHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            for (int i = 0; i < Datas.icons.length; i++) {
                String title = "我是第 " + i + " 个条目";
                ItemBean data = new ItemBean(Datas.icons[i],title);
                listData.add(data);
            }
        }
    }

    private final List<ItemBean> listData;

    public MyModel(){
        listData = new ArrayList<>();
    }

    @Override
    public void getTestData() {
        final Handler mHandler = new MyHandler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message msg = mHandler.obtainMessage();
                mHandler.sendMessage(msg);
            }
        }).start();
//        for (int i = 0; i < Datas.icons.length; i++) {
//            String title = "我是第 " + i + " 个条目";
//            ItemBean data = new ItemBean(Datas.icons[i],title);
//            listData.add(data);
//        }
    }



    @Override
    public List<ItemBean> getAdapterData() {
        return listData;
    }
}
