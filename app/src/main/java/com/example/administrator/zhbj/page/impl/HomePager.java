package com.example.administrator.zhbj.page.impl;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.zhbj.page.BasePager;

/**
 * Created by Administrator on 2017/10/11.
 */
public class HomePager extends BasePager {

    public HomePager(Activity activity) {
        super(activity);
    }

    public void initData(){
        TextView tv=new TextView(mActivity);
        tv.setText("HomePage");
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(22);
        tv.setTextColor(Color.RED);
        tv.setVisibility(View.VISIBLE);
        Log.d("...","initDate");
        menuButton.setVisibility(View.INVISIBLE);
        flContent.addView(tv);
    }
}
