package com.example.newrecycleviewdemo.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newrecycleviewdemo.R;
import com.example.newrecycleviewdemo.beans.ItemBean;

import java.util.List;

public abstract class BaseAdapter extends RecyclerView.Adapter<BaseAdapter.InnerHolder> {

    private final List<ItemBean> mData;

    public BaseAdapter(List<ItemBean> data) {
        mData = data;
    }


    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = getSubView(parent, viewType);
        return new InnerHolder(view);
    }
    protected abstract View getSubView(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        holder.setData(mData.get(position), position);
    }
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        if(mData != null){
            return mData.size();
        }
        return 0;
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        private ImageView mIcon;
        private TextView mTitle;
        private int mPosition;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);

            switch (itemView.getId()) {
                case R.id.list_parent:
                    mIcon = itemView.findViewById(R.id.list_view_icon);
                    mTitle = itemView.findViewById(R.id.list_view_title);
                    break;
                case R.id.grid_parent:
                    mIcon = itemView.findViewById(R.id.grid_view_icon);
                    mTitle = itemView.findViewById(R.id.grid_view_title);
                    break;
                case R.id.stagger_parent:
                    mIcon = itemView.findViewById(R.id.stagger_view_icon);
                    mTitle = itemView.findViewById(R.id.stagger_view_title);
                default:
                    break;
            }
        }

        public void setData(ItemBean itemBean,int position) {

            this.mPosition = position;
            mIcon.setImageResource(itemBean.getIcon());
            mTitle.setText(itemBean.getTitle());
        }

    }
}
