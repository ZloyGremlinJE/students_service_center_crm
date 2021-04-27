package com.jm.students.service.quartz;


import java.time.LocalDateTime;

public interface ScheduleService {
    void simpleLocalDateSchedule(String nameOfWork, String message, LocalDateTime localDateTime);
    void simpleEveryDaySchedule(String nameOfWork, String message, int hours, int minutes);
}

