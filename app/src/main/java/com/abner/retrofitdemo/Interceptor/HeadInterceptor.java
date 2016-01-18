package com.abner.retrofitdemo.Interceptor;

import android.support.annotation.NonNull;
import android.util.Log;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Abner on 16/1/15.
 * Email nimengbo@gmail.com
 * github https://github.com/nimengbo
 */
public class HeadInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        Request request = original.newBuilder()
//                    .addHeader("User-Agent", "Test")
//                    .addHeader("Accept", "application/vnd.github.v3+json")
//                    .addHeader("Authorization", "")
                .method(original.method(), original.body())
                .build();

        long startTime = System.nanoTime();
        Log.d("retrofit",String.format("Sending request %s on %s%n%s", request.url(), chain.connection(), request.headers()));

        Response response = chain.proceed(request);

        long endTime = System.nanoTime();
        Log.d("retrofit",String.format("Received response for %s in %.1fms%n%s", response.request().url(), (endTime - startTime) / 1e6d, response.headers()));

        return response;
    }

    @NonNull
    private String toGetUrl(Request request){

        StringBuilder url = new StringBuilder(request.url().toString());

        StringBuilder bodyStr = new StringBuilder("?");
        FormBody body = (FormBody) request.body();
        Log.d("body",String.valueOf(body.size()));
        for(int i = 0 ; i < body.size() ; i ++){
            if(i > 0){
                bodyStr.append("&");
            }
            bodyStr.append(body.encodedName(i));
            bodyStr.append("=");
            bodyStr.append(body.encodedValue(i));
        }

        return url.append(bodyStr).toString();
    }
}
