package com.even.common.design.observer.diy;

/**
 * Created by fymeven on 2017/9/14.
 */

/**
 * 观察者
 */
public class MyObserver implements IMyObserver{
    @Override
    public void update(MySubject subject){
        System.out.println("老鼠逃跑了");
    }
}
