package com.example.administrator.zhbj.page;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.administrator.zhbj.R;

/**
 * Created by Administrator on 2017/10/11.
 */
public class BasePager {
    public Activity mActivity;
    public ImageButton menuButton;
    public TextView tvTitle;
    public FrameLayout flContent;
    public View mView;
    public BasePager(Activity activity){
        mActivity=activity;
        mView=initView();
    }
    public View initView(){
        View view=View.inflate(mActivity, R.layout.basepager,null);
        menuButton =(ImageButton)view.findViewById(R.id.btn_menu);
        tvTitle=(TextView)view.findViewById(R.id.tv_title);
        flContent=(FrameLayout)view.findViewById(R.id.fl_content);

        return view;
    }
    public void initData(){}
}
