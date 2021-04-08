package com.jm.students.service.quartz;

import com.jm.students.model.quartz.TimerInfo;
import java.time.LocalDateTime;


public interface QuartzService {
    TimerInfo schedule(Class jobClass, TimerInfo info);
    TimerInfo simpleEveryDaySchedule(Class jobClass, LocalDateTime localDateTime);
}
