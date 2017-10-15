package com.example.administrator.zhbj.page.impl.newspages;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.zhbj.MainActivity;
import com.example.administrator.zhbj.R;
import com.example.administrator.zhbj.domin.NewsMenu;
import com.example.administrator.zhbj.page.BaseDatailPage;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/10/14.
 */
public class NewsMenuDetailPager extends BaseDatailPage {

    public void setNewsDetailViewPager(ViewPager newsDetailViewPager) {
        this.newsDetailViewPager = newsDetailViewPager;
    }

    private ViewPager newsDetailViewPager;
    ArrayList<NewsMenu.NewsTabData> tabDatas;

    public NewsMenuDetailPager(MainActivity mActivity) {
        super(mActivity);
    }
    public NewsMenuDetailPager(MainActivity mActivity,ArrayList<NewsMenu.NewsTabData> children) {
        super(mActivity);
        tabDatas=children;
    }
    @Override
    public View initView() {
        View view=View.inflate(mActivity, R.layout.page_menu_detail,null);
        newsDetailViewPager=(ViewPager)view.findViewById(R.id.vp_news_menu_detail);
        MyAdapter myAdapter=new MyAdapter();
        newsDetailViewPager.setAdapter(myAdapter);
        return view;
    }

    @Override
    public void initData() {

    }
    class MyAdapter extends PagerAdapter{
        @Override
        public int getCount() {
            return tabDatas.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView tv=new TextView(mActivity);
            Log.d("NewsMenuDetail", tabDatas.get(position).title);
            tv.setText(tabDatas.get(position).title);
//            tv.setText("NewsMenuDetailPager");
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(22);
            tv.setTextColor(Color.RED);
            tv.setVisibility(View.VISIBLE);
            container.addView(tv);
            return tv;

        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
    }
}
