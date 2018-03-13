package com.dzzchao.wandroid.ui.fragment.maintab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dzzchao.wandroid.R;
import com.dzzchao.wandroid.base.BaseFragment;
import com.dzzchao.wandroid.net.bean.HomePageBean;
import com.dzzchao.wandroid.ui.adapter.HomeRecyclerAdapter;
import com.dzzchao.wandroid.ui.fragment.maintab.presenter.HomePresenter;
import com.dzzchao.wandroid.ui.fragment.maintab.view.IHomeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author zhangchao
 * @date 2018/3/12
 */
public class HomeFragment extends BaseFragment implements IHomeView {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private Unbinder mUnbinder;
    private HomeRecyclerAdapter mRecyAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_home, container, false);

        mUnbinder = ButterKnife.bind(this, view);

        HomePresenter mPresenter = new HomePresenter(this);
        mPresenter.reqListData(0);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyAdapter = new HomeRecyclerAdapter();
        mRecyclerView.setAdapter(mRecyAdapter);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }

    @Override
    public void showList(HomePageBean homePageBean) {
        mRecyAdapter.setData(homePageBean);
    }
}