package com.dzzchao.wandroid.retrofit;

import com.dzzchao.wandroid.utils.MyLog;
import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import timber.log.Timber;

/**
 * 拦截器
 * Created by chao.zhang on 2018/8/9 0009.
 */
public class RetrofitInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        String url = request.url().toString();
        String method = request.method();

        long t1 = System.nanoTime();
        request = request(request);

        Response response = chain.proceed(request);
        long t2 = System.nanoTime();
        response = response(response);
        return response;
    }


    private Response response(Response response) throws IOException {
        Timber.d("打印响应");
        if (response.isSuccessful()) {
            ResponseBody body = response.body();
            BufferedSource source = body.source();
            source.request(Long.MAX_VALUE);
            Buffer buffer = source.buffer();
            Charset charset = Charset.defaultCharset();
            MediaType contentType = body.contentType();
            if (contentType != null) {
                charset = contentType.charset(charset);
            }
            String bodyString = buffer.clone().readString(charset);
            MyLog.d(bodyString);
            ResponseBody responseBody = ResponseBody.create(contentType, bodyString);
            response = response.newBuilder().body(responseBody).build();
        }
        return response;
    }


    private Request request(Request request) throws IOException {
        Timber.d("打印请求");
        RequestBody requestBody = request.body();
        if (requestBody != null) {
            Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);
            Charset charset = Charset.forName("UTF-8");
            MediaType contentType = requestBody.contentType();
            if (contentType != null) {
                charset = contentType.charset(charset);
            }
            String json = buffer.readString(charset);
            MyLog.d(json);
            //加密
            RequestBody body = MultipartBody.create(contentType, json);
            request = request.newBuilder()
                    .post(body)
                    .build();
        }
        return request;
    }
}