package com.jm.students.service.quartz;

import com.jm.students.model.quartz.TimerInfo;



public interface QuartzService {
    TimerInfo schedule(Class jobClass, TimerInfo info);
    void closeJob(TimerInfo info);
}
