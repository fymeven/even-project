package com.even.common.design.observer.diy;

/**
 * Created by fymeven on 2017/9/14.
 */
public class MyObserver2 implements IMyObserver {
    @Override
    public void update(MySubject subject) {
        System.out.println("人被吵醒了");
    }
}
