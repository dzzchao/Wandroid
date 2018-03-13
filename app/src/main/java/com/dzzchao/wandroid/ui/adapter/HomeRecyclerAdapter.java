package com.dzzchao.wandroid.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dzzchao.wandroid.R;
import com.dzzchao.wandroid.net.bean.HomePageBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/12.
 */

public class HomeRecyclerAdapter extends RecyclerView.Adapter {


    private List<HomePageBean.DataBean.DatasBean> mdatas = new ArrayList<>();

    public void setData(HomePageBean data) {
        mdatas.addAll(data.getData().getDatas());
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_recycler, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        HomePageBean.DataBean.DatasBean datasBean = mdatas.get(position);
        viewHolder.tvTitle.setText(datasBean.getTitle());
        viewHolder.tvAuthor.setText(datasBean.getAuthor());
        viewHolder.tvClassification.setText(datasBean.getChapterName());
        viewHolder.tvTime.setText(datasBean.getNiceDate());
    }


    class MyViewHolder extends RecyclerView.ViewHolder {


        private TextView tvTitle;
        private TextView tvAuthor;
        private TextView tvClassification;
        private TextView tvTime;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.item_home_tv_title);
            tvAuthor = itemView.findViewById(R.id.item_home_tv_author);
            tvClassification = itemView.findViewById(R.id.item_home_tv_classification);
            tvTime = itemView.findViewById(R.id.item_home_tv_time);
        }
    }

    @Override
    public int getItemCount() {
        return mdatas.size();
    }


}
