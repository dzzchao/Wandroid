package com.dzzchao.wandroid.net;


public class RequestFactory {

    public static IRequestManager getRequestManager() {
        return VolleyRequestManager.getInstance();
    }

}