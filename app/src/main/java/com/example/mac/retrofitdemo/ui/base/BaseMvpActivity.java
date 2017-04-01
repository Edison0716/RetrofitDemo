package com.example.mac.retrofitdemo.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ${Junlong} on 2017/3/29.
 */

public abstract class BaseMvpActivity<V, T extends BasePresenter<V>> extends AppCompatActivity {

    public T presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initPresenter();

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attach((V) this);
    }

    @Override
    protected void onDestroy() {
        presenter.dettach();
        super.onDestroy();
    }

    public abstract T initPresenter();

    public abstract void initView();

}
