package com.example.mode1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mode1.adapter.NewsAdapter;
import com.example.mode1.bean.NewsInfo;
import com.example.mode1.bean.Resilt;
import com.example.mode1.core.BaseActivity;
import com.example.mode1.core.DataCall;
import com.example.mode1.presenter.NewsPresenter;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;


public class MainActivity extends BaseActivity implements DataCall<NewsInfo> {


    private com.handmark.pulltorefresh.library.PullToRefreshListView list;
    NewsPresenter newsPresenter;
    NewsAdapter newsAdapter;
    int page = 1;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        newsPresenter = new NewsPresenter(this);
        list = (PullToRefreshListView) findViewById(R.id.list);
        newsAdapter = new NewsAdapter();
        list.setMode(PullToRefreshBase.Mode.BOTH);
        list.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                page = 1;
                newsPresenter.request(page);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                page++;
                newsPresenter.request(page);
            }
        });
        newsPresenter.request(page);
    }

    @Override
    public void success(Resilt<NewsInfo> resilt) {
        list.onRefreshComplete();
        if (resilt.code==200){
            if (page==1){
                newsAdapter.clear();
            }
            newsAdapter.addAll(resilt.resilt);
            newsAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void fail() {
        list.onRefreshComplete();
        Toast.makeText(this, "加载失败", Toast.LENGTH_SHORT).show();
    }
}
