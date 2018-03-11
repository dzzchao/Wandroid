package com.dzzchao.wandroid.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dzzchao.wandroid.R;
import com.dzzchao.wandroid.base.BaseFragment;

/**
 * @author zhangchao
 * @date 2018/3/12
 */
public class HomeFragment extends BaseFragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_home,container,false);
    }
}