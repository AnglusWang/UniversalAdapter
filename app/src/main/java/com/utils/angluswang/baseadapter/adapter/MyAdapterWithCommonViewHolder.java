package com.utils.angluswang.baseadapter.adapter;

import android.content.Context;
import android.widget.TextView;

import com.utils.angluswang.baseadapter.R;
import com.utils.angluswang.baseadapter.entity.Bean;
import com.utils.angluswang.baseadapter.utils.ViewHolder;

import java.util.List;

/**
 * Created by Jeson on 2016/6/14.
 * 加强型适配器
 */

public class MyAdapterWithCommonViewHolder extends CommonAdapter<Bean> {

    public MyAdapterWithCommonViewHolder(Context context, List<Bean> datas) {
        super(context, datas);
    }

    @Override
    public void convert(ViewHolder holder, Bean bean) {

        ((TextView) holder.getView(R.id.tv_title)).setText(bean.getTitle());
        ((TextView) holder.getView(R.id.tv_desc)).setText(bean.getDesc());
        ((TextView) holder.getView(R.id.tv_time)).setText(bean.getTime());
        ((TextView) holder.getView(R.id.tv_phone)).setText(bean.getPhone());
    }
}
