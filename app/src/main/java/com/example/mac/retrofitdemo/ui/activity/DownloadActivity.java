package com.example.mac.retrofitdemo.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.mac.retrofitdemo.R;
import com.example.mac.retrofitdemo.ui.base.BaseMvpActivity;
import com.example.mac.retrofitdemo.ui.presenter.DownloadPresenter;
import com.example.mac.retrofitdemo.ui.view.IDownloadView;
import com.example.mac.retrofitdemo.utils.ToastUtils;


public class DownloadActivity extends BaseMvpActivity<IDownloadView, DownloadPresenter> implements IDownloadView, View.OnClickListener {
    ProgressBar progressBar;
    private Button mBtStart;
    private Button mBtPause;
    private Button mBtCancel;
    private Button mBtContinue;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        initView();
    }

    @Override
    public DownloadPresenter initPresenter() {
        return new DownloadPresenter();
    }

    public void initView() {
        mBtStart = (Button) findViewById(R.id.bt_download);
        mBtPause = (Button) findViewById(R.id.bt_pause);
        mBtCancel = (Button) findViewById(R.id.bt_cancel);
        mBtContinue = (Button) findViewById(R.id.bt_continue);
        progressBar = (ProgressBar) findViewById(R.id.np_bar);
        mBtStart.setOnClickListener(this);
        mBtCancel.setOnClickListener(this);
        mBtPause.setOnClickListener(this);
        mBtContinue.setOnClickListener(this);

    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {
        ToastUtils.showToast(getApplicationContext(), "完成");
    }

    @Override
    public void error() {
        ToastUtils.showToast(getApplicationContext(), "下载失败！");
    }

    @Override
    public void setProgressBar(int MaxProgress, int CurrentProgress) {
        progressBar.setMax(MaxProgress);
        progressBar.setProgress(CurrentProgress);
    }

    @Override
    public void startDownload() {
        ToastUtils.showToast(getApplicationContext(), "开始下载");
    }

    @Override
    public void pauseDownload() {
        ToastUtils.showToast(getApplicationContext(), "暂停下载");
    }

    @Override
    public void cancelDownload() {
        ToastUtils.showToast(getApplicationContext(), "下载已取消");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_download:
                //启动下载
                presenter.onStartDownload();
                mBtContinue.setClickable(false);
                mBtPause.setClickable(true);
                mBtCancel.setClickable(true);
                mBtStart.setClickable(false);
                break;
            case R.id.bt_pause:
                //暂停下载
                presenter.onPauseDownload();
                mBtContinue.setClickable(true);
                mBtPause.setClickable(false);
                mBtCancel.setClickable(true);
                mBtStart.setClickable(false);
                break;
            case R.id.bt_continue:
                //继续下载
                presenter.onContinueDownload();
                mBtContinue.setClickable(false);
                mBtPause.setClickable(true);
                mBtCancel.setClickable(true);
                mBtStart.setClickable(false);
                break;
            case R.id.bt_cancel:
                //取消下载
                mBtStart.setClickable(true);
                mBtContinue.setClickable(false);
                mBtPause.setClickable(false);
                mBtCancel.setClickable(false);
                presenter.onCancelDownload();
                progressBar.setProgress(0);
                break;
        }
    }
}