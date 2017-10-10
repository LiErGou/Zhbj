package com.example.administrator.zhbj;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends Activity {
    private ViewPager flashViewPager;
    private int[] guidePic;
    private View v;
    private List<View> l;
    private LinearLayout pointsContainer;
    private ImageView point;
    private Button startBtn;
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
        startBtn=(Button)findViewById(R.id.start_button);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(GuideActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
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
        flashViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==l.size()-1){
                    startBtn.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
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
