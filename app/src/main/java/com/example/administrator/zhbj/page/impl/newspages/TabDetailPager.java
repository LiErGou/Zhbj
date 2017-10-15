package com.example.administrator.zhbj.page.impl.newspages;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.zhbj.MainActivity;
import com.example.administrator.zhbj.page.BaseDatailPage;

/**
 * Created by Administrator on 2017/10/15.
 */
public class TabDetailPager extends BaseDatailPage {

    public TabDetailPager(MainActivity mActivity) {
        super(mActivity);
    }

    @Override
    public View initView() {
        TextView tv=new TextView(mActivity);
        tv.setText("TabDetailPager");
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(22);
        tv.setTextColor(Color.RED);
        tv.setVisibility(View.VISIBLE);
        return tv;
    }


}
