package com.even.common.design.single;

/**
 * Created by fymeven on 2017/9/14.
 */

/**
 * 单列模式
 */
public class Single {
    private Single(){};
    /**
     * 饿汉模式
     */
//    private static Single single=new Single();
//
//    public static Single getInstance(){
//        return single;
//    }
    /**
     * 懒汉模式
     */
    private static Single single;

    public static Single getInstance(){
        if (single==null)
            single=new Single();
        return single;
    }
}
