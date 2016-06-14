package com.utils.angluswang.baseadapter.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

    /**
     * 通过viewId 获取控件
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int viewId) {

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

    /**
     * 为TextView控件设置文本
     * @param viewId 控件的资源id
     * @param string 需要设置的文本内容
     * @return this
     */
    public ViewHolder setText(int viewId, String string) {
        TextView tv = getView(viewId);
        tv.setText(string);
        return this;
    }

    public ViewHolder setImageResource(int viewId, int resId) {
        ImageView img = getView(viewId);
        img.setImageResource(resId);
        return this;
    }

    public ViewHolder setImageBitmap(int viewId, Bitmap bm) {
        ImageView img = getView(viewId);
        img.setImageBitmap(bm);
        return this;
    }

    public ViewHolder setImageURI(int viewId, Uri uri) {
        ImageView img = getView(viewId);
        // ImageLoader.getInstance.loadImg(img, uri);
        return this;
    }
}
