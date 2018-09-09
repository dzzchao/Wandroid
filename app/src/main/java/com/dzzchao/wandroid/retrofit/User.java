package com.dzzchao.wandroid.retrofit;

import com.dzzchao.wandroid.retrofit.req.RegisterReqBean;
import com.dzzchao.wandroid.retrofit.req.LoginReqBean;
import com.dzzchao.wandroid.retrofit.resp.AllResp;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface User {

    @FormUrlEncoded
    @POST("user/login")
    Observable<AllResp> login(@Field("username") String username,@Field("password") String password);


    @FormUrlEncoded
    @POST("user/register")
    Observable<AllResp> register(@Field("username") String username,@Field("password") String password,
                                 @Field("repassword") String repassword);

}


