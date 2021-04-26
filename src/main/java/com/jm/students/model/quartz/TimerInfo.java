package com.jm.students.model.quartz;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TimerInfo {
    private String nameOfWork;
    private int totalFireCount;
    private boolean runForever;
    private long repeatIntervalMs;
    private long initialOffSetMs;
    private String callbackData;
    private TimerType timerType;
    private int hours;
    private int minutes;
    private String localdate;
}
