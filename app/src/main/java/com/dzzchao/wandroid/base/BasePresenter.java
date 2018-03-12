package com.dzzchao.wandroid.base;

import com.dzzchao.wandroid.utils.MyExecutor;
import com.dzzchao.wandroid.utils.MyLog;

/**
 * Created by Administrator on 2018/3/12.
 */

public class BasePresenter {


    public final MyExecutor executor;

    public BasePresenter() {
        MyLog.getIns().d("调用了BasePresenter构造方法");
        executor = MyExecutor.getIns();
    }
}