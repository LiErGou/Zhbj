package com.example.administrator.zhbj.domin;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/10/12.
 */
public class NewsMenu {
    public String retcode;
    public ArrayList<Integer> extend;
    public ArrayList<NewsMenuData> data;
    public class NewsMenuData{
        public String id;
        public String title;
        public String type;
        public ArrayList<NewsTabData> children;
        public String toString() {
            return "NewsMenuData [title=" + title + ", children=" + children
                    + "]";
        }
    }

    public class NewsTabData{
        public String id;
        public String title;
        public String type;
        public String url;
        public String toString() {
            return "NewsTabData [title=" + title + "]";
        }
    }
    public String toString() {
        return "NewsMenu [data=" + data + "]";
    }
}
