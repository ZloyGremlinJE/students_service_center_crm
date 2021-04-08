package com.jm.students.service.quartz;

import com.jm.students.model.quartz.TimerInfo;
import com.jm.students.model.quartz.TimerType;
import com.jm.students.utils.TimerUtils;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;



@Service("ProtoType")
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
    public void closeJob(TimerInfo info) {
        try {
            SchedulerContext context = scheduler.getContext();
            scheduler.deleteJob(new JobKey(info.getNameOfWork()));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
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
