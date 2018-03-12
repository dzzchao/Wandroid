package com.dzzchao.wandroid.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018/3/12.
 */

public class MyExecutor {


    private final ExecutorService mExecutorService;

    private MyExecutor() {
        mExecutorService = Executors.newCachedThreadPool();
    }

    private static class MyExecutorFatory {
        private static MyExecutor instance = new MyExecutor();
    }

    public static MyExecutor getIns() {
        return MyExecutorFatory.instance;
    }

    public void submit(Runnable runnable) {
        mExecutorService.submit(runnable);
    }

}