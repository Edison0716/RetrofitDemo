package com.example.mac.retrofitdemo.ui.presenter;

import com.example.mac.retrofitdemo.data.api.Api;
import com.example.mac.retrofitdemo.model.CollegeBean;
import com.example.mac.retrofitdemo.ui.base.BasePresenter;
import com.example.mac.retrofitdemo.ui.view.ICollegeView;
import com.example.mycomponent.retrofit.RetrofitClient;

import java.io.IOException;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by ${Junlong} on 2017/3/29.
 */

public class CollegePresenter extends BasePresenter<ICollegeView> {
    private String data;
    public CollegePresenter() {
    }

    public void onResume(String page,String request,final boolean isLoadMore) {
        Api api = RetrofitClient.getInstance().ClientHolder().create(Api.class);
        Observable<ResponseBody> ranking = api.getCollegeList(String.valueOf(page), request);
        ranking.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ResponseBody>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ResponseBody value) {
                mView.showLoading();
                try {
                    data = value.string();
                    System.out.println(data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable e) {
                mView.error();
            }

            @Override
            public void onComplete() {
                mView.hideLoading();
                List<CollegeBean> obj = new CollegeBean().getPrasedObj(data);
                mView.getList(obj,isLoadMore);
            }
        });
    }
}
