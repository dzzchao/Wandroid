package com.dzzchao.wandroid.network;


public class RequestFactory {

    public static IRequestManager getRequestManager() {
//        return VolleyRequestManager.getInstance();
        return OkHttpRequestManager.getInstance();
    }

}