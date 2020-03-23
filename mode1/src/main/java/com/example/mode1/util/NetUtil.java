package com.example.mode1.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @ProjectName: My Application5
 * @Package: com.example.mode1.util
 * @ClassName: NetUtil
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/3/21 11:45
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/21 11:45
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class NetUtil {
    private static final String TAG = "NetUtil";
    //单例模式
    private NetUtil() {

    }

    private static NetUtil netUtil = new NetUtil();

    public static NetUtil getNetUtil() {
        return netUtil;
    }

    //判断是否有网
    public boolean hasNet(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            return true;
        } else {
            return false;
        }
    }
    //ioToString
    private String ioToSstring(InputStream inputStream) throws IOException{
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int len = -1;
        byte[] bytes = new byte[1024];
        while ((len = inputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,-1);
        }
        byte[] bytes1 = outputStream.toByteArray();
        String json = new String(bytes);
        return json;
    }
    //doGet
    public String doGet(String urlStr){

        try {
            URL url = new URL(urlStr);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode==200){
                InputStream inputStream = httpURLConnection.getInputStream();
                String json = ioToSstring(inputStream);
                Log.i(TAG, "doGet: "+json);
                return json;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}