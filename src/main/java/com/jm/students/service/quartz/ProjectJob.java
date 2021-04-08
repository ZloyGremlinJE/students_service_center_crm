package com.jm.students.service.quartz;

import com.jm.students.model.quartz.TimerInfo;
import org.quartz.*;



public class ProjectJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String key = jobExecutionContext.getJobDetail().getKey().getName();
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        TimerInfo timerInfo = (TimerInfo) jobDataMap.get(key.toString());
        System.out.println(timerInfo.getCallbackData());
    }
}
