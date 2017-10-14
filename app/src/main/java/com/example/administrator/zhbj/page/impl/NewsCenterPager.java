package com.example.administrator.zhbj.page.impl;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.zhbj.MainActivity;
import com.example.administrator.zhbj.domin.NewsMenu;
import com.example.administrator.zhbj.fragments.LeftFragment;
import com.example.administrator.zhbj.page.BasePager;
import com.google.gson.Gson;


import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class NewsCenterPager extends BasePager {
    OkHttpClient client;
    LeftFragment leftFragment;
    public NewsCenterPager(Activity activity) {
        super(activity);
    }

    public void initData(){
        Log.d("NewsCenterPager", "respose excuting");
        TextView tv=new TextView(mActivity);
        tv.setText("NewsCenterPage");
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(22);
        tv.setTextColor(Color.RED);
        menuButton.setVisibility(View.VISIBLE);
        flContent.addView(tv);
        Gson gson=new Gson();
        NewsMenu newsMenu= gson.fromJson("{\"retcode\": 200,\"data\":[{\"id\": 10000,\"title\": \"新闻\",\"type\": 1,\"children\": [{\"id\": 10007,\"title\": \"北京\",\"type\": 1,\"url\": \"/10007/list_1.json\"},{\"id\": 10006,\"title\": \"中国\",\"type\": 1,\"url\": \"/10006/list_1.json\"},{\"id\": 10008,\"title\": \"国际\",\"type\": 1,\"url\": \"/10008/list_1.json\"},{\"id\": 10010,\"title\": \"体育\",\"type\": 1,\"url\": \"/10010/list_1.json\"},{\"id\": 10091,\"title\": \"生活\",\"type\": 1,\"url\": \"/10091/list_1.json\"},{\"id\": 10012,\"title\": \"旅游\",\"type\": 1,\"url\": \"/10012/list_1.json\"},{\"id\": 10095,\"title\": \"科技\",\"type\": 1,\"url\": \"/10095/list_1.json\"},{\"id\": 10009,\"title\": \"军事\",\"type\": 1,\"url\": \"/10009/list_1.json\"},{\"id\": 10093,\"title\": \"时尚\",\"type\": 1,\"url\": \"/10093/list_1.json\"},{\"id\": 10011,\"title\": \"财经\",\"type\": 1,\"url\": \"/10011/list_1.json\"},{\"id\": 10094,\"title\": \"育儿\",\"type\": 1,\"url\": \"/10094/list_1.json\"},{\"id\": 10105,\"title\": \"汽车\",\"type\": 1,\"url\": \"/10105/list_1.json\"}]},{\"id\": 10002,\"title\": \"专题\",\"type\": 10,\"url\": \"/10006/list_1.json\",\"url1\": \"/10007/list1_1.json\"},{\"id\": 10003,\"title\": \"组图\",\"type\": 2,\"url\": \"/10008/list_1.json\"},{\"id\": 10004,\"title\": \"互动\",\"type\": 3,\"excurl\": \"\",\"dayurl\": \"\",\"weekurl\": \"\"}],\"extend\": [10007,10006,10008,10014,10012,10091,10009,10010,10095]}",NewsMenu.class);
        Log.d("NewsCenterPager",newsMenu.toString());
        leftFragment=getLeftFramgment();
        leftFragment.setmNewsMenuData(newsMenu.data);
//        client = new OkHttpClient();
//        String url="http://192.168.163.1:8080/zhbj/categories.json";
//
//            sendOkHttpRequest(url, new Callback() {
//                @Override
//                public void onFailure(Call call, IOException e) {
//                    Log.d("NewsCenterPager","failed");
//                }
//
//                @Override
//                public void onResponse(Call call, Response response) throws IOException {
//                    String ans=response.body().string();
//                    Log.d("NewsCenterPager","respose"+ans);
//                }
//            });

    }

    private LeftFragment getLeftFramgment(){
        MainActivity mainActivity=(MainActivity)mActivity;
        return mainActivity.getLeftMenuFragment();
    }

    void sendOkHttpRequest(String address,okhttp3.Callback callback){
        Request request = new Request.Builder()
                .url(address)
                .build();
        client.newCall(request).enqueue(callback);
    }

}
