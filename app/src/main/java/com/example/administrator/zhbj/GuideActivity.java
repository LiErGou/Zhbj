package com.example.administrator.zhbj;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends Activity {
    ViewPager flashViewPager;
    int[] guidePic;
    View v;
    List<View> l;
    LinearLayout pointsContainer;
    ImageView point;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        initData();
        initView();
    }
    private void initData(){
        flashViewPager=(ViewPager)findViewById(R.id.viewPager);
        guidePic=new int[]{R.drawable.guide_1,R.drawable.guide_2,R.drawable.guide_3};
        pointsContainer=(LinearLayout)findViewById(R.id.points);


    }
    private void initView(){
        l=new ArrayList<>();
        LinearLayout.LayoutParams llp=new LinearLayout.LayoutParams(10, 10);
        for(int i=0;i<guidePic.length;i++){
            v=new View(this);
            v.setBackgroundResource(guidePic[i]);
            l.add(v);
            if(i!=0)
                llp.setMargins(0, 0, 10, 0);
            point=new ImageView(this);
            point.setImageResource(R.drawable.shape_point_gray);
            pointsContainer.addView(point,llp);
        }
        flashViewPager.setAdapter(new GuideAdapter());
    }
    class GuideAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return l.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View v=l.get(position);
            container.addView(v);
            return v;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view==o;
        }


    }
}
