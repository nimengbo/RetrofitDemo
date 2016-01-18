package com.abner.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.abner.retrofitdemo.controller.TestController;
import com.abner.retrofitdemo.model.WelfareModel;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TestController.getInstance().getTestApi("福利","10","1")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<WelfareModel>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("onError",e.getMessage());
                    }

                    @Override
                    public void onNext(List<WelfareModel> welfareModels) {

                    }
                });

    }


}
