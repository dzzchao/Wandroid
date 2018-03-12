package com.dzzchao.wandroid.ui.fragment.maintab;

import com.dzzchao.wandroid.base.BasePresenter;
import com.dzzchao.wandroid.net.IRequestCallback;
import com.dzzchao.wandroid.net.IRequestManager;
import com.dzzchao.wandroid.net.RequestFactory;
import com.dzzchao.wandroid.net.bean.HomePageBean;
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
                        mView.showList(homePageBean);
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