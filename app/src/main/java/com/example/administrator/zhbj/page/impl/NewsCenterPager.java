package com.example.administrator.zhbj.page.impl;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.zhbj.page.BasePager;

/**
 * Created by Administrator on 2017/10/11.
 */
public class NewsCenterPager extends BasePager {

    public NewsCenterPager(Activity activity) {
        super(activity);
    }

    public void initData(){
        TextView tv=new TextView(mActivity);
        tv.setText("NewsCenterPage");
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(22);
        tv.setTextColor(Color.RED);
        menuButton.setVisibility(View.VISIBLE);
        flContent.addView(tv);
    }
}
