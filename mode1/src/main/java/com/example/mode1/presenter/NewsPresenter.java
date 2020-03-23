package com.example.mode1.presenter;

import com.example.mode1.bean.Resilt;
import com.example.mode1.core.BasePresenter;
import com.example.mode1.core.DataCall;
import com.example.mode1.model.NewsModel;

/**
 * @ProjectName: My Application5
 * @Package: com.example.mode1.presenter
 * @ClassName: NewsPresenter
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/3/21 11:42
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/21 11:42
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class NewsPresenter extends BasePresenter {


    public NewsPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Resilt getModel(Object... args) {
        //调用model请求数据,无需关心restil的泛型
        return NewsModel.getNews((int)args[0]);
    }
}
