package com.example.administrator.zhbj.page;

import android.view.View;

import com.example.administrator.zhbj.MainActivity;

/**
 * Created by Administrator on 2017/10/14.
 */
public abstract class BaseDatailPage {
    protected MainActivity mActivity;
    private View rootView;


    public BaseDatailPage(MainActivity mActivity) {
        this.mActivity = mActivity;
    }

    public abstract View initView();

    public void initData(){

    }
}
