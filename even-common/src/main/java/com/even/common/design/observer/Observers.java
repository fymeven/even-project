package com.even.common.design.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by fymeven on 2017/9/14.
 */
public class Observers implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        Subject obs=(Subject)o;
        System.out.println("数据已更改:"+obs.getDate());
    }
}
