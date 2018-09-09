package com.dzzchao.wandroid.ui.fragment.maintab;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.PhoneUtils;
import com.dzzchao.wandroid.R;
import com.dzzchao.wandroid.base.BaseFragment;
import com.dzzchao.wandroid.constants.AppConstants;
import com.dzzchao.wandroid.retrofit.RetrofitInterceptor;
import com.dzzchao.wandroid.retrofit.User;
import com.dzzchao.wandroid.retrofit.req.LoginReqBean;
import com.dzzchao.wandroid.retrofit.req.RegisterReqBean;
import com.dzzchao.wandroid.retrofit.resp.AllResp;
import com.dzzchao.wandroid.ui.activity.LoginActivity;
import com.dzzchao.wandroid.utils.MyLog;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * Created by zhangchao on 2018/3/12.
 */

public class MyFragment extends BaseFragment {

    private Retrofit mRetrofit;

    @BindView(R.id.tv_state)
    TextView tvState;
    private Retrofit retrofit;

    @OnClick(R.id.btn_login)
    void login() {
        if(getActivity() == null) {
            return;
        }
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            Timber.e("无 READ_PHONE_STATE 权限");
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        login("test", "123456");
    }

    @OnClick(R.id.btn_register)
    void
    register() {
        register("dzzchao", "123456");
    }

    @OnClick(R.id.btn_quit)
    void quit() {


//        Observable.interval(2, TimeUnit.SECONDS)
//                .doOnNext(new Customer)

    }

    @Override
    protected int provideContentViewId() {
        return R.layout.my_fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new RetrofitInterceptor());
        OkHttpClient okHttpClient = builder.build();
        mRetrofit = new Retrofit.Builder().baseUrl(AppConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }


    /**
     * 登录方法
     */
    void login(String username,String password) {

        User user = mRetrofit.create(User.class);
        LoginReqBean loginReqBean = new LoginReqBean();
        loginReqBean.setUsername(username);
        loginReqBean.setPassword(password);
        Observable<AllResp> observable = user.login(username,password);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AllResp>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        //初始化工作
                        Timber.d("onSubscribe");
                    }

                    @Override
                    public void onNext(AllResp allResp) {
                        Timber.d("onNext");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e("onError %s",e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Timber.d("onComplete");
                    }
                });

    }

    /**
     * 注册
     */
    void register(String username,String password) {
        Timber.d("register");
        User user = mRetrofit.create(User.class);
        RegisterReqBean registerBean = new RegisterReqBean();
        registerBean.setUsername(username);
        registerBean.setPassword(password);
        registerBean.setRepassword(password);
        Observable<AllResp> observable  = user.register(username,password,password);
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AllResp>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        //初始化工作
                        Timber.d("onSubscribe");
                    }

                    @Override
                    public void onNext(AllResp allResp) {
                        Timber.d("onNext");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e("onError %s",e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Timber.d("onComplete");
                    }
                });

    }
}
