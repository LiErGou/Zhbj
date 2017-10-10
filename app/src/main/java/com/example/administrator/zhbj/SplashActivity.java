package com.example.administrator.zhbj;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import com.example.administrator.zhbj.Utils.PrefUtils;

public class SplashActivity extends Activity {
    RelativeLayout relativeLayout;
    boolean isFirstStart;
    PrefUtils pu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        pu=new PrefUtils();
        showPage();
    }

    private void showPage(){
        relativeLayout=(RelativeLayout)findViewById(R.id.splash);
        RotateAnimation rotateAnimation=new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(1000);

        ScaleAnimation scaleAnimation=new ScaleAnimation(0,1,0,1,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setDuration(1000);

        AnimationSet set =new AnimationSet(true);
        set.addAnimation(rotateAnimation);
        set.addAnimation(scaleAnimation);

        relativeLayout.startAnimation(set);
        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                isFirstStart=pu.getBoolean(SplashActivity.this,"is_first_start",true);
                Intent intent;
                if(isFirstStart){
                    pu.setBoolean(SplashActivity.this,"is_first_start",true);
                    intent=new Intent(SplashActivity.this,GuideActivity.class);
                }else{
                    intent=new Intent(SplashActivity.this,MainActivity.class);
                }
                startActivity(intent);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }



}
