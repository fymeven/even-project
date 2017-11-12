package com.even.controller;

import com.even.common.util.ResponseResult;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by even on 2017/11/1.
 */
@Controller
@RequestMapping("/task")
public class TaskController {
    @ResponseBody
    @RequestMapping("/start")
    public ResponseResult send(){
        try {
//            String time="2017-11-11 00:23:13";
            JobDetail job = JobBuilder.newJob(HelloJob.class)
                    .withIdentity("myJob233", "group233").withDescription("is just a job..")
                    .build();
            job.getJobDataMap().put("name","even");
            Trigger trigger= TriggerBuilder.newTrigger()
                        .withIdentity("myTrigger233", "group233")
//                        .startAt(DateUtil.parse(time))
                        .startNow()
//                                .withSchedule(CalendarIntervalScheduleBuilder.calendarIntervalSchedule().withIntervalInSeconds(5))
                        .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(4).withRepeatCount(3))
                        .build();
            SchedulerFactory sf = new StdSchedulerFactory();
            Scheduler scheduler = sf.getScheduler();
            scheduler.scheduleJob(job, trigger);
            scheduler.start();

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return ResponseResult.SUCCESS("开始任务");
    }

}
