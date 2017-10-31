package com.even.common.schedule;

import java.text.SimpleDateFormat;

/**
 * Created by fymeven on 2017/6/26.
 */
public class QuartzJob {
    public void doJob(){
        SimpleDateFormat sdf=new SimpleDateFormat();
        System.out.println("hello job!"+sdf.format(System.currentTimeMillis()));
    }
}
