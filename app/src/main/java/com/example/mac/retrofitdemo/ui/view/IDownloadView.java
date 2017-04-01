package com.example.mac.retrofitdemo.ui.view;

import com.example.mac.retrofitdemo.ui.base.BaseView;

/**
 * Created by ${巴黎没有摩天轮Li} on 2017/4/1.
 */

public interface IDownloadView extends BaseView{
        void setProgressBar(int MaxProgress,int CurrentProgress);
        void startDownload();
        void pauseDownload();
        void cancelDownload();
}
