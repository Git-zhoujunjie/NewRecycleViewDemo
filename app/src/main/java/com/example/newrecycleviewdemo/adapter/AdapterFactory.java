package com.example.newrecycleviewdemo.adapter;

import com.example.newrecycleviewdemo.R;
import com.example.newrecycleviewdemo.beans.ItemBean;

import java.util.List;

public class AdapterFactory {

    public static BaseAdapter getAdapter(int menuId, List<ItemBean> list) {
        BaseAdapter adapter = null;
        if(menuId!=0) {
            switch (menuId) {
                //listview部分
                case R.id.list_view_vertical_stander:
                case R.id.list_view_vertical_reverse:
                case R.id.list_view_horizontal_stander:
                case R.id.list_view_horizontal_reverse:
                    adapter = new ListViewAdapter(list);
                    break;
                    //gridview部分
                case R.id.grid_view_vertical_stander:
                case R.id.grid_view_vertical_reverse:
                case R.id.grid_view_horizontal_stander:
                case R.id.grid_view_horizontal_reverse:
                    adapter = new GridViewAdapter(list);
                    break;
                    //staggerview部分
                case R.id.stagger_view_vertical_stander:
                case R.id.stagger_view_vertical_reverse:
                case R.id.stagger_view_horizontal_stander:
                case R.id.stagger_view_horizontal_reverse:
                    adapter = new StaggerViewAdapter(list);
                    break;
            }
        }
        return adapter;
    }

}
