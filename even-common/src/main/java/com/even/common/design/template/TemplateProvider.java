package com.even.common.design.template;

/**
 * Created by fymeven on 2017/9/14.
 */

/**
 * 模板模式-基类
 */
public abstract class TemplateProvider {

    public final void useTemplate(){
        start();
        doSomething();//子类实现
        stop();
    }

    private  void start(){
        System.out.println("做一些准备工作");
    }

    protected abstract void doSomething();

    private void stop() {
        System.out.println("工作结束,开溜");
    }

}
