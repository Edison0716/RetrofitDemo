package com.example.mac.retrofitdemo.ui.base;

/**
 * Created by ${Junlong} on 2017/3/29.
 */

public abstract class BasePresenter<T> {
    public T mView;

    public void attach(T mView){
        this.mView = mView;
    }

    public void dettach(){
        mView = null;
    }
}