package com.even.common.design.observer.diy;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by fymeven on 2017/9/14.
 */

/**
 * 观察者模式-主题
 */
public class MySubject {
    private Set<IMyObserver> observers;

    public MySubject(){
        observers=new LinkedHashSet<>();
    }

    public boolean addObserver(IMyObserver obs){
        if (!observers.contains(obs)){
            observers.add(obs);
            return true;
        }else {
            return false;
        }
    }

    public boolean delObserver(IMyObserver obs){
        if (observers.contains(obs)){
            observers.remove(obs);
            return true;
        }else {
            return false;
        }
    }

    public void notifyObservers(){
        for (IMyObserver observer : observers) {
            observer.update(this);
        }
    }

    public void shout(){
        System.out.println("猫发出了叫声");
        notifyObservers();
    }
}
