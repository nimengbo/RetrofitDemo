package com.abner.retrofitdemo.subcriber;

/**
 * Created by Abner on 16/1/15.
 * Email nimengbo@gmail.com
 * github https://github.com/nimengbo
 */
public class TestSubscriber<T> extends GankSubscriber<T> {

    @Override
    public void onCompleted() {
        super.onCompleted();
    }

    @Override
    public void onError(Throwable e) {
        super.onError(e);
    }

    @Override
    public void onNext(T t) {
        super.onNext(t);
    }
}
