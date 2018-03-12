package com.dzzchao.wandroid.net;

import com.dzzchao.wandroid.net.bean.HomePageBean;
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
                MyLog.getIns().json(response);
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