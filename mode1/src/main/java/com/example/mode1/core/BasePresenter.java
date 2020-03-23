package com.example.mode1.core;

import android.os.Handler;
import android.os.Message;

import androidx.appcompat.view.menu.BaseMenuPresenter;

import com.example.mode1.bean.Resilt;

/**
 * @ProjectName: My Application5
 * @Package: com.example.mode1.core
 * @ClassName: BasePresenter
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/3/21 11:31
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/21 11:31
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public abstract class BasePresenter {
    private DataCall dataCall;
    public BasePresenter(DataCall dataCall){
        this.dataCall = dataCall;
    }
    Handler handler = new Handler(){
        public void handleMessage(Message msg){
        if (msg.obj==null){
            dataCall.fail();
        }else {
            Resilt resilt = (Resilt) msg.obj;
            dataCall.success(resilt);
        }
    }};
   public void request(final Object...args){
       new Thread(new Runnable() {
           @Override
           public void run() {
               Resilt resilt = getModel(args);
               Message message = Message.obtain();
               message.obj = resilt;
               handler.sendMessage(message);
           }
       }).start();
   }
   protected abstract Resilt getModel(Object...args);
}
