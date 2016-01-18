package com.abner.retrofitdemo.retrofit;

import com.abner.retrofitdemo.model.AnalyseModel;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Abner on 16/1/14.
 * Email nimengbo@gmail.com
 * github https://github.com/nimengbo
 */
public interface GankApi {

    @FormUrlEncoded
    @POST("shopping.php")
    Observable<AnalyseModel> shoppingPost(@FieldMap Map<String, String> options);


    @GET("api/data/{type}/{size}/{page}")
    Observable<AnalyseModel> getGankWelfare(@Path("type") String type, @Path("size") String size, @Path("page") String page);
}
