package com.example.mac.retrofitdemo.ui.view;

import com.example.mac.retrofitdemo.model.CollegeBean;
import com.example.mac.retrofitdemo.ui.base.BaseView;

import java.util.List;

/**
 * Created by ${Junlong} on 2017/3/29.
 */

public interface ICollegeView extends BaseView {
    void getList(List<CollegeBean> list,Boolean isLoadMore);
}
