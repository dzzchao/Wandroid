package com.dzzchao.wandroid.ui.fragment.maintab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dzzchao.wandroid.R;
import com.dzzchao.wandroid.base.BaseFragment;

/**
 * Created by zhangchao on 2018/3/12.
 */

public class MyFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_my,container,false);
    }
}
