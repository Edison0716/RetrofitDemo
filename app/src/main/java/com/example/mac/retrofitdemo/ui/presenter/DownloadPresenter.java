package com.example.mac.retrofitdemo.ui.presenter;

import android.os.Environment;

import com.example.mac.retrofitdemo.ui.activity.DownloadActivity;
import com.example.mac.retrofitdemo.ui.base.BasePresenter;
import com.example.mac.retrofitdemo.ui.view.IDownloadView;
import com.example.mac.retrofitdemo.utils.ToastUtils;
import com.example.mycomponent.retrofit.ProgressDownloader;
import com.example.mycomponent.retrofit.ProgressResponseBody;

import java.io.File;
import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;

/**
 * Created by ${巴黎没有摩天轮Li} on 2017/4/1.
 */

public class DownloadPresenter extends BasePresenter<IDownloadView> implements ProgressResponseBody.ProgressListener {

    public static final String PACKAGE_URL = "http://gdown.baidu.com/data/wisegame/df65a597122796a4/weixin_821.apk";
    private long breakPoints;
    private ProgressDownloader downloader;
    private File file;
    private long totalBytes;
    private long contentLength;
    private int maxProgress;

    /*开始下载*/
    public void onStartDownload() {
        breakPoints = 0L;
        file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "weixin.apk");
        downloader = new ProgressDownloader(PACKAGE_URL, file, this);
        downloader.download(0L);
    }

    /*暂停下载*/
    public void onPauseDownload() {
        downloader.pause();
        // 存储此时的totalBytes，即断点位置。
        breakPoints = totalBytes;
    }

    /*继续下载*/
    public void onContinueDownload() {
        downloader.download(breakPoints);
    }

    public void onCancelDownload(){
        downloader.pause();
    }

    @Override
    public void onPreExecute(long contentLength) {
        // 文件总长只需记录一次，要注意断点续传后的contentLength只是剩余部分的长度
        if (this.contentLength == 0L) {
            this.contentLength = contentLength;
            maxProgress = (int) (contentLength / 1024);
            mView.setProgressBar(maxProgress, 0);
        }
    }

    @Override
    public void update(long totalBytes, boolean done) {
        // 注意加上断点的长度
        this.totalBytes = totalBytes + breakPoints;
        mView.setProgressBar(maxProgress, (int) (totalBytes + breakPoints) / 1024);
        if (done) {
            // 切换到主线程
            Observable
                    .empty()
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnComplete(new Action() {
                        @Override
                        public void run() throws Exception {
                            mView.hideLoading();
                        }
                    })
                    .subscribe();
        }
    }

    @Override
    public void error(IOException e) {
        mView.error();
    }
}
