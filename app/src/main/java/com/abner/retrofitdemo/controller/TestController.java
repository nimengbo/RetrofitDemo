package com.abner.retrofitdemo.controller;

import com.abner.retrofitdemo.model.WelfareModel;
import com.abner.retrofitdemo.retrofit.GankApiUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Observable;

/**
 * Created by Abner on 16/1/15.
 * Email nimengbo@gmail.com
 * github https://github.com/nimengbo
 */
public class TestController extends GankApiUtils {

    private static TestController mInstance;

    public static TestController getInstance() {
        if (mInstance == null) {
            synchronized (GankApiUtils.class) {
                if (mInstance == null) {
                    mInstance = new TestController();
                }
            }
        }
        return mInstance;
    }

    public TestController() {
        super();
    }

    public Observable<List<WelfareModel>> getTestApi(String type,String size,String page) {
        Map<String, String> params = new HashMap<>();
        params.put("type", type);
        params.put("size", size);
        params.put("page", page);
        return getList(params, WelfareModel.class);
    }

}
