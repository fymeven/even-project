package com.qccr.gotone.common.util;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * Created by even on 2017/11/10.
 */
public class QuartzUtil {
    private static SchedulerFactory schedulerFactory = new StdSchedulerFactory(); //创建一个SchedulerFactory工厂实例
    private static String DEFAULT_JOB_NAME = "DEFAULT_JOB_NAME"; //任务组
    private static String DEFAULT_GROUP_NAME = "DEFAULT_GROUP_NAME"; //触发器组


    public static void addJob(String jobName,String jobGroup,Date startTime,Class<? extends Job> jobClass,int interval,int repeatCount) throws Exception {
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            JobDetail job = JobBuilder.newJob(jobClass)
                    .withIdentity(jobName, jobGroup)
                    .build();

            Trigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName, jobGroup)
//                        .startNow()//一旦加入scheduler，立即生效
                    .startAt(startTime)
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(interval).withRepeatCount(repeatCount))
                    .build();

            //加入这个调度
            scheduler.scheduleJob(job, trigger);

            if (!scheduler.isShutdown()) {
                scheduler.start();        // 启动
            }
        }catch (Exception ex){
            throw  new Exception("创建任务失败");
        }
    }


//    public static void updateJobTime(String jobName, String jobGroup,Date newStartTime) {
//        try {
//            Scheduler scheduler = schedulerFactory.getScheduler();
//            TriggerKey triggerKey = TriggerKey.triggerKey(jobName,jobGroup);      //通过触发器名和组名获取TriggerKey
//            Trigger trigger = scheduler.getTrigger(triggerKey);//通过TriggerKey获取CronTrigger
//            if (trigger == null) {
//                return;
//            }
//            Date oldStartTime = trigger.getStartTime();
//                JobKey jobKey = JobKey.jobKey(jobName, jobGroup);                     //通过任务名和组名获取JobKey
//                JobDetail jobDetail = scheduler.getJobDetail(jobKey);
//                Class<? extends Job> jobClass = jobDetail.getJobClass();
//                removeJob(jobName);
//                addJob(jobName,jobGroup,newStartTime,jobClass);
//        } catch (Exception e) {
//            throw  new Exception("创建修改失败");
//        }
//    }


    public static void removeJob(String jobName,String jobGroup) {
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey(jobName,jobGroup);    //通过触发器名和组名获取TriggerKey
            JobKey jobKey = JobKey.jobKey(jobName, jobGroup);                           //通过任务名和组名获取JobKey
            scheduler.pauseTrigger(triggerKey); // 停止触发器
            scheduler.unscheduleJob(triggerKey);// 移除触发器
            scheduler.deleteJob(jobKey);        // 删除任务
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 启动所有定时任务
     */
    public static void startJobs() {
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 关闭所有定时任务
     */
    public static void shutdownJobs() {
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            if (!scheduler.isShutdown()) {
                scheduler.shutdown();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
