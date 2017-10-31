package com.even.common.design.observer;

import java.util.Observable;

/**
 * Created by fymeven on 2017/9/14.
 */
public class Subject extends Observable {
    private String date="1";

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
        setChanged();
        notifyObservers();//通知所有观察者
    }
}
