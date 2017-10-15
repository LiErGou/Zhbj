package com.example.administrator.zhbj.page.impl.newspages;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.zhbj.MainActivity;
import com.example.administrator.zhbj.domin.NewsMenu;
import com.example.administrator.zhbj.page.BaseDatailPage;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/10/14.
 */
public class InteractMenuDetailPager extends BaseDatailPage {

    ArrayList<NewsMenu.NewsTabData> tabDatas;

    public InteractMenuDetailPager(MainActivity mActivity) {
        super(mActivity);
    }

    @Override
    public View initView() {
        TextView tv=new TextView(mActivity);
        tv.setText("InteractMenuDetailPager");
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(22);
        tv.setTextColor(Color.RED);
        tv.setVisibility(View.VISIBLE);
        Log.d("...", "initDate");
        return tv;
    }
}
