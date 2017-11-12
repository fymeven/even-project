package com.even.controller;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;

/**
 * Created by fymeven on 2017/11/9.
 */
public class HelloJob implements Job{
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("hello job!" + sdf.format(System.currentTimeMillis()));
        System.out.println("jobClass:"+jobExecutionContext.getJobDetail().getJobClass());
        System.out.println("name:"+jobExecutionContext.getJobDetail().getJobDataMap().get("name"));
    }
}
