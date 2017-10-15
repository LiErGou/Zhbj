package com.example.administrator.zhbj.page.impl.newspages;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.zhbj.MainActivity;
import com.example.administrator.zhbj.page.BaseDatailPage;

/**
 * Created by Administrator on 2017/10/14.
 */
public class TopicMenuDetailPager extends BaseDatailPage {

    public TopicMenuDetailPager(MainActivity mActivity) {
        super(mActivity);
    }

    @Override
    public View initView() {
        TextView tv=new TextView(mActivity);
        tv.setText("TopicMenuDetailPager");
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(22);
        tv.setTextColor(Color.RED);
        tv.setVisibility(View.VISIBLE);
        return tv;
    }
}
