package com.utils.angluswang.baseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jeson on 2016/6/14.
 *  适配器类
 */

public class MyAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<Bean> mDatas;

    public MyAdapter(Context context, List<Bean> datas) {
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
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_listview, parent,false);
            holder = new ViewHolder();

            holder.mTitle = (TextView) convertView.findViewById(R.id.tv_title);
            holder.mDesc = (TextView) convertView.findViewById(R.id.tv_desc);
            holder.mTime = (TextView) convertView.findViewById(R.id.tv_time);
            holder.mPhone = (TextView) convertView.findViewById(R.id.tv_phone);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        Bean bean = mDatas.get(position);
        holder.mTitle.setText(bean.getTitle());
        holder.mDesc.setText(bean.getDesc());
        holder.mTime.setText(bean.getTime());
        holder.mPhone.setText(bean.getPhone());

        return convertView;
    }

    private class ViewHolder {
        TextView mTitle;
        TextView mDesc;
        TextView mTime;
        TextView mPhone;
    }
}
