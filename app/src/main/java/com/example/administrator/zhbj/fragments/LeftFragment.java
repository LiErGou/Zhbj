package com.example.administrator.zhbj.fragments;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.zhbj.R;
import com.example.administrator.zhbj.domin.NewsMenu;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/10/10.
 */
public class LeftFragment extends BaseFragment {

    private int currentPage;
    private ArrayList<NewsMenu.NewsMenuData> mNewsMenuData;
    private ListView lv;

    @Override
    public View initView() {
        View view=View.inflate(mActivity, R.layout.left_layout,null);
        lv=(ListView)view.findViewById(R.id.lf_lv);
        return view;
    }

    @Override
    public void initData() {

    }

    public void setmNewsMenuData(ArrayList<NewsMenu.NewsMenuData> mNewsMenuData) {
        this.mNewsMenuData = mNewsMenuData;
        final BaseAdapter myAdapter=new MyLVAdapter();
        lv.setAdapter(myAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                currentPage=i;
                myAdapter.notifyDataSetChanged();
            }
        });
    }

    class MyLVAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return mNewsMenuData.size();
        }

        @Override
        public NewsMenu.NewsMenuData getItem(int i) {
            return mNewsMenuData.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View v=View.inflate(mActivity,R.layout.lv_item,null);
            TextView textView=(TextView)v.findViewById(R.id.menu_id);
            textView.setText(mNewsMenuData.get(i).title);
            if(i==currentPage){
                textView.setEnabled(true);
            } else{
                textView.setEnabled(false);
            }
            return v;
        }
    }
}
