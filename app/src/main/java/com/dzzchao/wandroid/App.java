package com.dzzchao.wandroid;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;


/**
 * @author zhangchao
 * @date 2018/3/11
 */
public class App extends Application {

    public static RequestQueue mQueue;
    private static App ins;

    public static App getIns() {
        return ins;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ins = this;

        Logger.addLogAdapter(new AndroidLogAdapter());

        mQueue = Volley.newRequestQueue(this);

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        // Normal app init code...s
    }
}