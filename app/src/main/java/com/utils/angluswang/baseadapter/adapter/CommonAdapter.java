package com.utils.angluswang.baseadapter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.utils.angluswang.baseadapter.R;
import com.utils.angluswang.baseadapter.entity.Bean;
import com.utils.angluswang.baseadapter.utils.ViewHolder;

import java.util.List;

/**
 * Created by Jeson on 2016/6/14.
 * 通用的适配器抽象类
 */

public abstract class CommonAdapter<T> extends BaseAdapter {

    protected Context mContext;
    protected List<Bean> mDatas;
    protected LayoutInflater mInflater;

    public CommonAdapter(Context context, List<Bean> datas) {
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
        this.mDatas = datas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return (T) mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder = ViewHolder.get(mContext,
                convertView, parent, R.layout.item_listview, position);

        convert(holder, getItem(position));

        return holder.getConvertView();
    }

    public abstract void convert(ViewHolder holder, T t);
}
