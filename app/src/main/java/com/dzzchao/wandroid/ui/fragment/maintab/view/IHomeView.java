package com.dzzchao.wandroid.ui.fragment.maintab.view;

import com.dzzchao.wandroid.net.bean.HomeBannerBean;
import com.dzzchao.wandroid.net.bean.HomePageBean;

import java.util.List;

/**
 * Created by Administrator on 2018/3/12.
 */

public interface IHomeView {


    /**
     * 显示列表
     * @param datas
     */
    void showList(List<HomePageBean.DataBean.DatasBean> datas);

    /**
     * 显示 banner
     * @param data
     */
    void showBanner(List<HomeBannerBean.DataBean> data);
}
