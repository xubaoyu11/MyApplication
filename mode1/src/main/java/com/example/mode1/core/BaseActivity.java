package com.example.mode1.core;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @ProjectName: My Application5
 * @Package: com.example.mode1.core
 * @ClassName: BaseActivity
 * @Description: Activity基类
 * @Author: deshuai
 * @CreateDate: 2020/3/21 11:14
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/21 11:14
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView(savedInstanceState);
    }
    protected abstract int getLayoutId();
    protected abstract void initView(Bundle savedInstanceState);
}
