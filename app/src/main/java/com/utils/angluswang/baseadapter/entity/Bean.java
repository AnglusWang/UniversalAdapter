package com.utils.angluswang.baseadapter.entity;

/**
 * Created by Jeson on 2016/6/14.
 * 一个实体类
 */

public class Bean {
    private String title;
    private String desc;
    private String time;
    private String phone;

    public Bean() {

    }

    public Bean(String title, String desc, String time, String phone) {
        this.title = title;
        this.desc = desc;
        this.time = time;
        this.phone = phone;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
