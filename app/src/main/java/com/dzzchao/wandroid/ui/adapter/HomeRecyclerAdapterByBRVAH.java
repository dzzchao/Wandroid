package com.dzzchao.wandroid.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dzzchao.wandroid.R;
import com.dzzchao.wandroid.net.bean.HomePageBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/12.
 */

public class HomeRecyclerAdapterByBRVAH extends BaseQuickAdapter<HomePageBean.DataBean.DatasBean, BaseViewHolder> {

    public HomeRecyclerAdapterByBRVAH(int layoutResId, @Nullable List<HomePageBean.DataBean.DatasBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomePageBean.DataBean.DatasBean item) {
        helper.setText(R.id.item_home_tv_title, item.getTitle());
        helper.setText(R.id.item_home_tv_author, item.getAuthor());
        helper.setText(R.id.item_home_tv_classification, item.getChapterName());
        helper.setText(R.id.item_home_tv_time, item.getNiceDate());
    }
}