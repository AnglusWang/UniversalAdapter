package com.utils.angluswang.baseadapter.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.utils.angluswang.baseadapter.R;
import com.utils.angluswang.baseadapter.adapter.CommonAdapter;
import com.utils.angluswang.baseadapter.adapter.MyAdapter;
import com.utils.angluswang.baseadapter.adapter.MyAdapterWithCommonViewHolder;
import com.utils.angluswang.baseadapter.entity.Bean;
import com.utils.angluswang.baseadapter.utils.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private ListView mListView;
    private List<Bean> mDatas;
    private MyAdapter myAdapter;
    private MyAdapterWithCommonViewHolder mAdapterWithCommonViewHolder;
    private CommonAdapter<Bean> commonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatas();
        initView();

        mListView.setAdapter(commonAdapter);
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.id_listview);
    }

    private void initDatas() {

        mDatas = new ArrayList<>();

        Bean bean = new Bean("Android新技能 Get1", "Android打造万能的ListView和GridView适配器",
                "2016-06-14", "10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能 Get2", "Android打造万能的ListView和GridView适配器",
                "2016-06-14", "10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能 Get3", "Android打造万能的ListView和GridView适配器",
                "2016-06-14", "10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能 Get4", "Android打造万能的ListView和GridView适配器",
                "2016-06-14", "10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能 Get5", "Android打造万能的ListView和GridView适配器",
                "2016-06-14", "10086");
        mDatas.add(bean);
        bean = new Bean("Android新技能 Get6", "Android打造万能的ListView和GridView适配器",
                "2016-06-14", "10086");
        mDatas.add(bean);

//        myAdapter = new MyAdapter(this, mDatas);
//        mAdapterWithCommonViewHolder = new MyAdapterWithCommonViewHolder(this, mDatas);
        commonAdapter = new CommonAdapter<Bean>(MainActivity.this, mDatas) {
            @Override
            public void convert(ViewHolder holder, Bean bean) {
                holder.setText(R.id.tv_title, bean.getTitle())
                        .setText(R.id.tv_desc, bean.getDesc())
                        .setText(R.id.tv_time, bean.getTime())
                        .setText(R.id.tv_phone, bean.getPhone());
            }
        };
    }
}
