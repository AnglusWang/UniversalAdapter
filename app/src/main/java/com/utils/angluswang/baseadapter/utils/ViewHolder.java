package com.utils.angluswang.baseadapter.utils;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Jeson on 2016/6/14.
 * 自定义一个ViewHolder优化代码，采用SparseArray
 */

public class ViewHolder {

    private SparseArray<View> mViews;
    private int mPosition;
    private View mConvertView;

    public ViewHolder(Context context, ViewGroup parent,
                     int layouId, int position) {
        this.mPosition = position;
        this.mViews = new SparseArray<>();
        mConvertView = LayoutInflater.from(context).inflate(layouId, parent, false);
        mConvertView.setTag(this);
    }

    public static ViewHolder get(Context context, View convertView,
                          ViewGroup parent, int layouId, int position) {
        if (convertView == null) {
            return new ViewHolder(context, parent, layouId, position);
        } else {
            ViewHolder holder = (ViewHolder) convertView.getTag();
            holder.mPosition = position;
            return holder;
        }
    }

    public < T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);

        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getConvertView() {
        return mConvertView;
    }
}
