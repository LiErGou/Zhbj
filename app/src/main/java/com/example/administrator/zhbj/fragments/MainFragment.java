package com.example.administrator.zhbj.fragments;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.administrator.zhbj.MainActivity;
import com.example.administrator.zhbj.NoScrollViewPager;
import com.example.administrator.zhbj.R;
import com.example.administrator.zhbj.page.BasePager;
import com.example.administrator.zhbj.page.impl.GovAffairPager;
import com.example.administrator.zhbj.page.impl.HomePager;
import com.example.administrator.zhbj.page.impl.NewsCenterPager;
import com.example.administrator.zhbj.page.impl.SettingPager;
import com.example.administrator.zhbj.page.impl.SmartServicePager;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/10.
 */
public class MainFragment extends BaseFragment{
    ViewPager viewPager;
    List<BasePager> pagers;
    RadioGroup radioGroup;
    @Override
    public View initView() {

        View view=View.inflate(mActivity, R.layout.main_layout,null);
        viewPager=(NoScrollViewPager)view.findViewById(R.id.viewPager2);
        radioGroup=(RadioGroup)view.findViewById(R.id.radio_group);
        return view;
    }



    @Override
    public void initData() {
        pagers=new ArrayList<>();
        pagers.add(new HomePager(mActivity));
        pagers.add(new NewsCenterPager(mActivity));
        pagers.add(new SmartServicePager(mActivity));
        pagers.add(new GovAffairPager(mActivity));
        pagers.add(new SettingPager(mActivity));

        viewPager.setAdapter(new MyPagerAdapter());
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                MainActivity m = (MainActivity) mActivity;
                switch (i) {
                    case R.id.home:
                        viewPager.setCurrentItem(0, false);

                        m.getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
                        break;
                    case R.id.news_center:
                        viewPager.setCurrentItem(1, false);
                        m.getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
                        break;
                    case R.id.smart:
                        viewPager.setCurrentItem(2, false);
                        m.getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
                        break;
                    case R.id.govaffair:
                        viewPager.setCurrentItem(3, false);
                        m.getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
                        break;
                    case R.id.setting:
                        viewPager.setCurrentItem(4, false);
                        m.getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
                        break;
                }
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pagers.get(position).initData();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        pagers.get(0).initData();
    }
    public NewsCenterPager getNewsCenterpager(){
        return (NewsCenterPager)pagers.get(1);
    }

    private class MyPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return pagers.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BasePager bp=pagers.get(position);
//            bp.initData();
            if(position==0){
                MainActivity m=(MainActivity)mActivity;
                m.getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
            }

            container.addView(bp.mView);
            return bp.mView;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }
    }
}
