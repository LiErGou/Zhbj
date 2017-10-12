package com.example.administrator.zhbj;

import android.app.Activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.administrator.zhbj.fragments.LeftFragment;
import com.example.administrator.zhbj.fragments.MainFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;


public class MainActivity extends SlidingFragmentActivity {
    public static final String LEFT_FRAGMENT="left";
    public static final String MAIN_FRAGMENT="main";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSlidingMenu();
        initFragment();
    }

    private void initSlidingMenu(){
        setBehindContentView(R.layout.layout);
        SlidingMenu slidingMenu = getSlidingMenu();
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);//全屏触摸
        slidingMenu.setBehindOffset(200);//屏幕预留200像素宽度
    }

    private void initFragment(){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.left_layout,new LeftFragment(),LEFT_FRAGMENT);
        fragmentTransaction.replace(R.id.mf_fragment,new MainFragment(),MAIN_FRAGMENT);

        fragmentTransaction.commit();
    }
}
