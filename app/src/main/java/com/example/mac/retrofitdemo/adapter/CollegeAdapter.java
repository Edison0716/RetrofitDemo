package com.example.mac.retrofitdemo.adapter;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mac.retrofitdemo.R;
import com.example.mac.retrofitdemo.model.CollegeBean;

import java.util.List;

/**
 * Created by ${巴黎没有摩天轮Li} on 2017/3/26.
 */

public class CollegeAdapter extends BaseQuickAdapter<CollegeBean,BaseViewHolder> {

    public CollegeAdapter(int layoutResId, List<CollegeBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CollegeBean item) {
        helper.setText(R.id.tv_name,item.getNameCh());
    }
}
