package com.example.mode1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mode1.R;
import com.example.mode1.bean.NewsInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: My Application5
 * @Package: com.example.mode1.adapter
 * @ClassName: NewsAdapter
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/3/23 9:30
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/23 9:30
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class NewsAdapter extends BaseAdapter {
    private List<NewsInfo> list = new ArrayList<>();
    @Override
    public int getCount() {
        return list.size();
    }
    public void addAll(List<NewsInfo> data){
        list.addAll(data);
    }
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item,parent,false);
             holder = new ViewHolder();
             holder.textView = convertView.findViewById(R.id.text);
             convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        NewsInfo newsInfo = list.get(position);
        holder.textView.setText(newsInfo.desc);
        return convertView;
    }
    public void clear(){
        list.clear();
    }
    class ViewHolder{
        public TextView textView;
    }
}
