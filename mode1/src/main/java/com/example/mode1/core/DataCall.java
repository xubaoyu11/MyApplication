package com.example.mode1.core;


import com.example.mode1.bean.Resilt;

/**
 * @ProjectName: My Application5
 * @Package: com.example.mode1.core
 * @ClassName: DataCall
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/3/21 11:19
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/21 11:19
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface DataCall<T> {
    void success(Resilt<T> resilt);
    void fail();
}
