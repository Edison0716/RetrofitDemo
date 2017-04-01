package com.example.mac.retrofitdemo.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mac.retrofitdemo.adapter.CollegeAdapter;
import com.example.mac.retrofitdemo.R;
import com.example.mac.retrofitdemo.model.CollegeBean;
import com.example.mac.retrofitdemo.ui.base.BaseMvpActivity;
import com.example.mac.retrofitdemo.ui.presenter.CollegePresenter;
import com.example.mac.retrofitdemo.ui.view.ICollegeView;
import com.example.mac.retrofitdemo.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class CollegeActivity extends BaseMvpActivity<ICollegeView, CollegePresenter> implements ICollegeView,BaseQuickAdapter.RequestLoadMoreListener {
    private RecyclerView mView;
    private CollegeAdapter mAdapter;
    private List<CollegeBean> list = new ArrayList<>();
    private int page = 0;
    private static final int PAGE_SIZE = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college);
        initView();
        presenter.onResume(String.valueOf(page),"ranking",false);
    }

    @Override
    public CollegePresenter initPresenter() {
        return new CollegePresenter();
    }

    @Override
    public void initView() {
        mView = (RecyclerView) findViewById(R.id.rv_list);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mView.setLayoutManager(manager);
        mAdapter = new CollegeAdapter(R.layout.item_list, list);
        mView.setAdapter(mAdapter);
        mAdapter.setOnLoadMoreListener(this);

    }

    @Override
    public void showLoading() {
        ToastUtils.showToast(getApplicationContext(), "加载中");
    }

    @Override
    public void hideLoading() {
        ToastUtils.showToast(getApplicationContext(), "加载完成");
    }

    @Override
    public void error() {
        ToastUtils.showToast(getApplicationContext(), "加载出错");
    }


    @Override
    public void getList(List<CollegeBean> list,Boolean isLoadMore) {
        if(isLoadMore){
            mAdapter.addData(list);
            mAdapter.loadMoreComplete();
        }else
        this.list.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadMoreRequested() {
        System.out.println("请求");
        presenter.onResume(String.valueOf(++page),"ranking",true);
        System.out.println(String.valueOf(page));
    }
}
