package com.example.mode1.model;

import android.service.media.MediaBrowserService;

import com.example.mode1.bean.NewsInfo;
import com.example.mode1.bean.Resilt;
import com.example.mode1.util.NetUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;



/**
 * @ProjectName: My Application5
 * @Package: com.example.mode1.model
 * @ClassName: NewsModel
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/3/21 11:43
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/21 11:43
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class NewsModel {
    public static Resilt<NewsInfo> getNews(int page){
        String netUtil = NetUtil.getNetUtil().doGet("http://47.94.132.125/baweiapi/gank_android?page=1&pageSize=5");
        Gson gson = new Gson();
        Type type = new TypeToken<Resilt<NewsInfo>>(){}.getType();
        Resilt<NewsInfo> data = gson.fromJson(netUtil, type);
        return data;
    }
}
