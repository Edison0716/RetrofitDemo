package com.example.mac.retrofitdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.mac.retrofitdemo.ui.activity.CollegeActivity;
import com.example.mac.retrofitdemo.ui.activity.DownloadActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBtCollege;
    private Button mBtDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtCollege = (Button) findViewById(R.id.bt_college);
        mBtCollege.setOnClickListener(this);
        mBtDownload = (Button) findViewById(R.id.bt_download);
        mBtDownload.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_college:
                startActivity(new Intent(MainActivity.this, CollegeActivity.class));
                break;
            case R.id.bt_download:
                startActivity(new Intent(MainActivity.this, DownloadActivity.class));
                break;

        }
    }
}
