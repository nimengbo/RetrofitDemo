package com.abner.retrofitdemo.retrofit;

import com.abner.retrofitdemo.Interceptor.HeadInterceptor;
import com.abner.retrofitdemo.model.AnalyseModel;
import com.abner.retrofitdemo.utils.GmtDateTypeAdapter;
import com.abner.retrofitdemo.utils.HttpUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Abner on 16/1/14.
 * Email nimengbo@gmail.com
 * github https://github.com/nimengbo
 */
public class GankApiUtils {

    private static int SUCCESS_CODE = 0;

    private GankApi mGankApi;

    private Gson gson;


    public GankApiUtils() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://gank.avosapps.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient())
                .build();

        mGankApi = retrofit.create(GankApi.class);
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").serializeNulls().registerTypeAdapter(Date.class,new GmtDateTypeAdapter()).create();
    }


    public GankApi getGankApi() {
        return mGankApi;
    }

    /**
     * 创建OKHttpClient
     *
     * @return
     */
    private OkHttpClient okHttpClient() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);

        /*List<Interceptor> interceptors = new ArrayList<>();
        interceptors.add(logging);
        interceptors.add(headerInterceptor);

        client.interceptors().addAll(interceptors);*/


        return new OkHttpClient.Builder().addInterceptor(logging).addInterceptor(new HeadInterceptor()).build();
    }

    public <T> Observable<List<T>> getList(Map<String, String> params,final Class<T> tClass) {
        return mGankApi.getGankWelfare(params.get("type"),params.get("size"),params.get("page"))
                .subscribeOn(Schedulers.io())
                .flatMap(new Func1<AnalyseModel, Observable<List<T>>>() {
                    @Override
                    public Observable<List<T>> call(AnalyseModel model) {
                        if (!model.error) {
                            Type listType = new TypeToken<List<T>>() {}.getType();
                            String json = model.results.toString();
                            List<T> data = gson.fromJson(json, listType);
                            return Observable.just(data);
                        } else {
                            //TODO 根据一些服务器信息或者本地session判断

                            return Observable.error(new Exception("hehe"));
                        }
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .doOnError(new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        //TODO 做一些错误的事
                    }
                });


    }

}
