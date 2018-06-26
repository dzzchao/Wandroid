package com.dzzchao.wandroid.ui.fragment.maintab;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.dzzchao.wandroid.R;
import com.dzzchao.wandroid.base.BaseFragment;
import com.dzzchao.wandroid.retrofit.req.RegisterReqBean;
import com.dzzchao.wandroid.retrofit.User;
import com.dzzchao.wandroid.retrofit.req.UserReqBean;
import com.dzzchao.wandroid.ui.activity.LoginActivity;
import com.dzzchao.wandroid.constants.AppConstants;
import com.dzzchao.wandroid.utils.MyLog;

import java.io.IOException;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhangchao on 2018/3/12.
 */

public class MyFragment extends BaseFragment {

    @BindView(R.id.tv_state)
    TextView tvState;
    private Retrofit retrofit;

    @OnClick(R.id.tv_state)
    void toLogin() {
        startActivity(new Intent(getActivity(), LoginActivity.class));
    }



    @Override
    protected int provideContentViewId() {
        return R.layout.my_fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //判断登录状态


    }
}
