package com.jm.students.service.quartz;

import com.jm.students.model.quartz.TimerInfo;
import com.jm.students.model.quartz.TimerType;
import com.jm.students.utils.TimerUtils;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.LocalDateTime;


@Service
public class QuartzServiceImpl implements QuartzService{

    private final Scheduler scheduler;
    private TimerUtils timerUtils;

    @Autowired
    public QuartzServiceImpl(Scheduler scheduler, TimerUtils timerUtils) {
        this.scheduler = scheduler;
        this.timerUtils = timerUtils;
    }

    @Override
    public TimerInfo schedule( final Class jobClass, final TimerInfo info) {
        final JobDetail jobDetail = timerUtils.buildJobDetail(jobClass, info);
        final Trigger trigger = timerUtils.buildTrigger(jobClass, info);
        try {
            scheduler.scheduleJob(jobDetail, trigger);
            return info;
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TimerInfo simpleEveryDaySchedule(final Class jobClass, LocalDateTime localDateTime) {
        final TimerInfo info = new TimerInfo();
        info.setTimerType(TimerType.ONE_FOR_LOCAL_DATE);
        info.setRunForever(false);
        info.setLocaldate(String.format("%s %s %s %s %s ?* %s",
                localDateTime.getSecond(),
                localDateTime.getMinute(),
                localDateTime.getHour(),
                localDateTime.getDayOfMonth(),
                localDateTime.getMonthValue(),
                localDateTime.getYear()));
        final JobDetail jobDetail = timerUtils.buildJobDetail(jobClass, info);
        final Trigger trigger = timerUtils.buildTrigger(jobClass, info);
        try {
            scheduler.scheduleJob(jobDetail, trigger);
            return info;
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostConstruct
    public void init() {
        try {
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public  void preDestroy() {
        try {
            scheduler.shutdown();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
