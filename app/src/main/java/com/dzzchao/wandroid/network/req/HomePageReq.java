package com.dzzchao.wandroid.network.req;

import com.dzzchao.wandroid.network.IRequestCallback;
import com.dzzchao.wandroid.network.IRequestManager;
import com.dzzchao.wandroid.network.RequestFactory;
import com.dzzchao.wandroid.network.bean.HomePageBean;
import com.dzzchao.wandroid.utils.MyLog;
import com.google.gson.Gson;

/**
 * 首页文章列表 http://www.wanandroid.com/article/list/0/json
 * Created by Administrator on 2018/3/12.
 */

public class HomePageReq {

    public void req(int page) {
        IRequestManager requestManager = RequestFactory.getRequestManager();
        String mUrl = "http://www.wanandroid.com/article/list/" + page + "/json";
        requestManager.get(mUrl, new IRequestCallback() {
            @Override
            public void onSuccess(String response) {
                MyLog.json(response);
                Gson gson = new Gson();
                HomePageBean homePageBean = gson.fromJson(response, HomePageBean.class);
            }

            @Override
            public void onFailure(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }
}