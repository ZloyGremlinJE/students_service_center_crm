package com.jm.students.utils;

import com.jm.students.model.quartz.TimerInfo;
import org.quartz.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public final class TimerUtils {

    public  JobDetail buildJobDetail(final Class jobClass, final TimerInfo info) {
        final JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put(jobClass.getSimpleName(), info);

        return JobBuilder
                .newJob(jobClass)
                .withIdentity(jobClass.getSimpleName())
                .setJobData(jobDataMap)
                .build();
    }

    public  Trigger buildTrigger(final Class jobClass, final TimerInfo info) {
        switch (info.getTimerType()) {
            case SIMPLE :
                SimpleScheduleBuilder builder = SimpleScheduleBuilder
                        .simpleSchedule()
                        .withIntervalInMilliseconds(info.getRepeatIntervalMs());

                if (info.isRunForever()) {
                    builder = builder.repeatForever();
                } else {
                    builder = builder.withRepeatCount(info.getTotalFireCount() - 1);
                }

                return TriggerBuilder
                        .newTrigger()
                        .withIdentity(jobClass.getSimpleName())
                        .withSchedule(builder)
                        .startAt(new Date(System.currentTimeMillis() + info.getInitialOffSetMs()))
                        .build();

            case SIMPLE_EVERY_DAY :
                return TriggerBuilder
                        .newTrigger()
                        .withIdentity(jobClass.getSimpleName())
                        .withSchedule(CronScheduleBuilder
                                .dailyAtHourAndMinute(info.getHours(), info.getMinutes()))
                        .build();
            case ONE_FOR_LOCAL_DATE:
                return TriggerBuilder
                        .newTrigger()
                        .withIdentity(jobClass.getSimpleName())
                        .withSchedule(CronScheduleBuilder.cronSchedule(info.getLocaldate()))
                        .build();
            default:
                throw new IllegalStateException("Unexpected TimerType value: " + info.getTimerType());
        }

    }
}
