package com.jm.students.service.quartz;

import com.jm.students.model.quartz.TimerInfo;
import com.jm.students.model.quartz.TimerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    private QuartzService quartzService;

    @Autowired
    public ScheduleServiceImpl(QuartzService quartzService) {
        this.quartzService = quartzService;
    }

    @Override
    public void simpleLocalDateSchedule(String nameOfWork, String message, LocalDateTime localDateTime) {
        final TimerInfo info = new TimerInfo();
        info.setTimerType(TimerType.ONE_FOR_LOCAL_DATE);
        info.setRunForever(false);
        info.setNameOfWork(nameOfWork);
        info.setCallbackData(message);
        info.setLocaldate(String.format("%s %s %s %s %s ?* %s",
                localDateTime.getSecond(),
                localDateTime.getMinute(),
                localDateTime.getHour(),
                localDateTime.getDayOfMonth(),
                localDateTime.getMonthValue(),
                localDateTime.getYear()));
        quartzService.schedule(ProjectJob.class, info);
    }

    @Override
    public void simpleEveryDaySchedule(String nameOfWork, String message, int hours, int minutes) {
        final TimerInfo info = new TimerInfo();
        info.setTimerType(TimerType.SIMPLE_EVERY_DAY);
        info.setRunForever(false);
        info.setNameOfWork(nameOfWork);
        info.setCallbackData(message);
        info.setHours(hours);
        info.setMinutes(minutes);
        quartzService.schedule(ProjectJob.class, info);
    }
}
