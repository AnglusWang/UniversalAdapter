package com.utils.angluswang.baseadapter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.utils.angluswang.baseadapter.entity.Bean;

import java.util.List;

/**
 * Created by Jeson on 2016/6/14.
 *  通用的适配器抽象类
 */

public abstract class CommonAdapter<T> extends BaseAdapter {

    private Context mContext;
    private List<Bean> mDatas;
    private LayoutInflater mInflater;

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
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public abstract View getView(int position, View convertView, ViewGroup parent);
}
