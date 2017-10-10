package com.example.administrator.zhbj.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2017/10/9.
 */
public class PrefUtils {
    public boolean getBoolean(Context context,String key,boolean defValue){
        SharedPreferences sp=context.getSharedPreferences("config",Context.MODE_PRIVATE);
        return sp.getBoolean(key,defValue);
    }
    public void setBoolean(Context context,String key,boolean value){
        SharedPreferences sp=context.getSharedPreferences("config",Context.MODE_PRIVATE);
        sp.edit().putBoolean(key,value).commit();
    }
    public String getString(Context context,String key,String defValue){
        SharedPreferences sp=context.getSharedPreferences("config",Context.MODE_PRIVATE);
        return sp.getString(key, defValue);
    }
    public void setString(Context context,String key,String value){
        SharedPreferences sp=context.getSharedPreferences("config",Context.MODE_PRIVATE);
        sp.edit().putString(key, value).commit();
    }
    public int getInt(Context context,String key,int defValue){
        SharedPreferences sp=context.getSharedPreferences("config",Context.MODE_PRIVATE);
        return sp.getInt(key, defValue);
    }
    public void setInt(Context context,String key,int value){
        SharedPreferences sp=context.getSharedPreferences("config",Context.MODE_PRIVATE);
        sp.edit().putInt(key, value).commit();
    }
}
