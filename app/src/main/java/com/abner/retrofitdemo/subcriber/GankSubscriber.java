package com.abner.retrofitdemo.subcriber;

import rx.Subscriber;

/**
 * Created by Abner on 16/1/15.
 * Email nimengbo@gmail.com
 * github https://github.com/nimengbo
 */
abstract public class GankSubscriber<T> extends Subscriber<T> {
    @Override
    public void onCompleted() {
    }

    @Override
    public void onError(Throwable e) {
        //TODO 处理一些错误LOG


    }

    @Override
    public void onNext(T t) {
    }
}
