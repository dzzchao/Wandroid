package com.dzzchao.wandroid.retrofit;

import com.dzzchao.wandroid.retrofit.req.RegisterReqBean;
import com.dzzchao.wandroid.retrofit.req.UserReqBean;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface User {

    @POST("user/login")
    Call<ResponseBody> login(@Body UserReqBean user);

    @POST("user/register")
    Call<ResponseBody> register(@Body RegisterReqBean registerBean);

}


