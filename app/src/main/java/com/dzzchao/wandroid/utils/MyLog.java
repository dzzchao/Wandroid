package com.dzzchao.wandroid.utils;

import com.orhanobut.logger.Logger;

import timber.log.Timber;

/**
 * 打印日志工具类
 * Created by zhangchao on 2018/3/11.
 */

public class MyLog {


    public static void d(String msg) {
        Timber.d(msg);
    }

    public static void i(String msg) {
        Timber.i(msg);
    }

    public static void e(String msg) {
        Timber.e(msg);
    }

    public static void json(String json) {
        Logger.json(json);
    }

}