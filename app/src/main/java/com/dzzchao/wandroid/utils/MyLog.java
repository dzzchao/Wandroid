package com.dzzchao.wandroid.utils;

import com.orhanobut.logger.Logger;

/**
 * 打印日志工具类
 * Created by zhangchao on 2018/3/11.
 */

public class MyLog {

    private MyLog() {
    }

    private static class MyLogFactory {
        private static MyLog instance = new MyLog();
    }

    public static MyLog getIns() {
        return MyLogFactory.instance;
    }

    public void d(String msg) {
        Logger.d(msg);
    }

    public void i(String msg) {
        Logger.i(msg);
    }

    public void e(String msg) {
        Logger.e(msg);
    }

    public void json(String json) {
        Logger.json(json);
    }

}