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
        System.out.println("onBindViewHolder");
        MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.tvTitle.setText(mdatas.get(position).getTitle());
    }


    class MyViewHolder extends RecyclerView.ViewHolder {


        private TextView tvTitle;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.item_home_tv_title);
        }
    }

    @Override
    public int getItemCount() {
        return mdatas.size();
    }


}
