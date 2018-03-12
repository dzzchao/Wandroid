package com.dzzchao.wandroid;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;


/**
 * @author zhangchao
 * @date 2018/3/11
 */
public class App extends Application {

    public static RequestQueue mQueue;

    @Override
    public void onCreate() {
        super.onCreate();

        Logger.addLogAdapter(new AndroidLogAdapter());

        mQueue = Volley.newRequestQueue(this);
    }
}