package com.example.newrecycleviewdemo.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.newrecycleviewdemo.presenter.BasePresenter;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    //用于链接view和model
    protected T basePresenter;
    private int itemId;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initView();
        //关联presenter
        basePresenter = initPresenter();
        //具体显示UI逻辑实现
        onPrepare();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //获取menu
        getMenuInflater().inflate(getMenu(),menu);

        return super.onCreateOptionsMenu(menu);
    }

    /**
     * 实现菜单的显示
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        itemId = item.getItemId();

        dispatchMenuItem(itemId);

        return super.onOptionsItemSelected(item);
    }

    protected abstract T initPresenter();

    protected abstract void dispatchMenuItem(int itemId);


    protected abstract int getMenu();

    protected abstract void onPrepare();

    protected abstract void initView();

    protected abstract int getLayout();
}
