package com.utils.angluswang.baseadapter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.utils.angluswang.baseadapter.R;
import com.utils.angluswang.baseadapter.entity.Bean;
import com.utils.angluswang.baseadapter.utils.ViewHolder;

import java.util.List;

/**
 * Created by Jeson on 2016/6/14.
 * 加强型适配器
 */

public class MyAdapterWithCommonViewHolder extends BaseAdapter{

    private LayoutInflater mInflater;
    private List<Bean> mDatas;
    private Context mContext;

    public MyAdapterWithCommonViewHolder(Context context, List<Bean> datas) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mDatas = datas;
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
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = ViewHolder.get(mContext,
                convertView, parent, R.layout.item_listview, position);

        Bean bean = mDatas.get(position);
        ((TextView) holder.getView(R.id.tv_title)).setText(bean.getTitle());
        ((TextView) holder.getView(R.id.tv_desc)).setText(bean.getDesc());
        ((TextView) holder.getView(R.id.tv_time)).setText(bean.getTime());
        ((TextView) holder.getView(R.id.tv_phone)).setText(bean.getPhone());

        return holder.getConvertView();
    }
}
