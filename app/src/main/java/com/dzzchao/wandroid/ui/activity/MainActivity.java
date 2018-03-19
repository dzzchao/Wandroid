package com.dzzchao.wandroid.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import com.dzzchao.wandroid.R;
import com.dzzchao.wandroid.base.BaseActivity;
import com.dzzchao.wandroid.ui.fragment.maintab.HomeFragment;
import com.dzzchao.wandroid.ui.fragment.maintab.MyFragment;
import com.dzzchao.wandroid.ui.fragment.maintab.SystemFragment;
import com.dzzchao.wandroid.utils.MyLog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bottom_navigation_view)
    BottomNavigationView mBottomNavigationView;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void initView() {
        initnavigationView();
        initViewPager();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main;
    }

    /**
     * 初始化 viewPager
     */
    private void initViewPager() {
        mFragments.add(new HomeFragment());
        mFragments.add(new SystemFragment());
        mFragments.add(new MyFragment());

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public android.support.v4.app.Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        });
        mViewPager.setCurrentItem(0);
    }

    /**
     * 初始化Navigation
     */
    private void initnavigationView() {
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        //第一次不会触发
                        MyLog.getIns().d("点击了首页");
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.navigation_system:
                        MyLog.getIns().d("点击了体系");
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.navigation_my:
                        MyLog.getIns().d("点击了我的");
                        mViewPager.setCurrentItem(2);
                        break;
                    default:
                }
                return true;
            }
        });
        mBottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        MyLog.getIns().d("点击了首页 again");

                        break;
                    case R.id.navigation_system:
                        MyLog.getIns().d("点击了体系 again");

                        break;
                    case R.id.navigation_my:
                        MyLog.getIns().d("点击了我的 again");

                        break;
                    default:
                }
            }
        });
    }
}