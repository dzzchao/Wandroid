package com.dzzchao.wandroid.ui.fragment.maintab;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dzzchao.wandroid.R;
import com.dzzchao.wandroid.base.BaseFragment;
import com.dzzchao.wandroid.network.bean.HomeBannerBean;
import com.dzzchao.wandroid.network.bean.HomePageBean;
import com.dzzchao.wandroid.ui.adapter.HomeRecyclerAdapterByBRVAH;
import com.dzzchao.wandroid.ui.fragment.maintab.presenter.HomePresenter;
import com.dzzchao.wandroid.ui.fragment.maintab.view.IHomeView;
import com.dzzchao.wandroid.ui.widget.TitleBar;
import com.dzzchao.wandroid.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author zhangchao
 * @date 2018/3/12
 */
public class HomeFragment extends BaseFragment implements IHomeView {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private HomeRecyclerAdapterByBRVAH mRecyAdapter;
    /**
     * 页数
     */
    private int mPage;
    private HomePresenter mPresenter;
    private Banner mBanner;


    @Override
    public void initView(View rootView) {
        mPresenter = new HomePresenter(this);

        new TitleBar(rootView).setTitleText("首页").setBackgroundResource(R.color.white);

        mPage = 0;
        mPresenter.reqListData(mPage);
        mPresenter.reqBannerData();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyAdapter = new HomeRecyclerAdapterByBRVAH(R.layout.home_recycler_item, null);
        mRecyAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mRecyAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.reqListData(mPage);
            }
        }, mRecyclerView);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.home_recycler_header, null);
        mBanner = view.findViewById(R.id.recycler_banner);
        mBanner.setImageLoader(new GlideImageLoader());

        mRecyAdapter.addHeaderView(view);
        mRecyclerView.setAdapter(mRecyAdapter);
    }


    @Override
    protected int provideContentViewId() {
        return R.layout.home_fragment;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void showList(List<HomePageBean.DataBean.DatasBean> datas) {
        mPage++;
        mRecyAdapter.loadMoreComplete();
        mRecyAdapter.addData(datas);
    }

    @Override
    public void showBanner(final List<HomeBannerBean.DataBean> data) {
        List<String> images = new ArrayList<>();
        for (HomeBannerBean.DataBean dataBean : data) {
            images.add(dataBean.getImagePath());
        }
        mBanner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                String url = data.get(position).getUrl();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        mBanner.setImages(images);
        mBanner.start();
    }
}