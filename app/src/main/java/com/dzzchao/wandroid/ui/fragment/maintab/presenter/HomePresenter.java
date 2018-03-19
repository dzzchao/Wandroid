package com.dzzchao.wandroid.ui.fragment.maintab.presenter;

import com.dzzchao.wandroid.base.BasePresenter;
import com.dzzchao.wandroid.net.IRequestCallback;
import com.dzzchao.wandroid.net.IRequestManager;
import com.dzzchao.wandroid.net.RequestFactory;
import com.dzzchao.wandroid.net.bean.HomeBannerBean;
import com.dzzchao.wandroid.net.bean.HomePageBean;
import com.dzzchao.wandroid.ui.fragment.maintab.view.IHomeView;
import com.dzzchao.wandroid.utils.MyLog;
import com.google.gson.Gson;

/**
 * Created by Administrator on 2018/3/12.
 */

public class HomePresenter extends BasePresenter {

    private IHomeView mView;

    public HomePresenter(IHomeView homeView) {
        mView = homeView;
    }

    /**
     * 获取首页数据
     */
    public void reqListData(final int page) {
        MyLog.getIns().d("reqListData" + page);
        executor.submit(new Runnable() {
            @Override
            public void run() {
                IRequestManager requestManager = RequestFactory.getRequestManager();
                String mUrl = "http://www.wanandroid.com/article/list/" + page + "/json";
                requestManager.get(mUrl, new IRequestCallback() {
                    @Override
                    public void onSuccess(String response) {
                        MyLog.getIns().json(response);
                        Gson gson = new Gson();
                        HomePageBean homePageBean = gson.fromJson(response, HomePageBean.class);
                        mView.showList(homePageBean.getData().getDatas());
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
            }
        });
    }

    /**
     * 请求Banner数据
     */
    public void reqBannerData() {
        executor.submit(new Runnable() {
            @Override
            public void run() {
                IRequestManager requestManager = RequestFactory.getRequestManager();
                String mUrl = "http://www.wanandroid.com/banner/json";
                requestManager.get(mUrl, new IRequestCallback() {
                    @Override
                    public void onSuccess(String response) {
                        MyLog.getIns().json(response);
                        Gson gson = new Gson();
                        HomeBannerBean bannerBean = gson.fromJson(response, HomeBannerBean.class);
                        mView.showBanner(bannerBean.getData());
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
            }
        });
    }
}