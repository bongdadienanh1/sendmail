package com.majq.taskschedule;

import com.majq.sendmail.utils.DateUtil;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MailTaskSchedule {

    public long start;
    private ScheduledExecutorService scheduledExecutorService;
    private MailTaskSchedule instance;

    private MailTaskSchedule() {
        this.scheduledExecutorService = Executors.newScheduledThreadPool(2);
        this.start = System.currentTimeMillis();
    }

    public synchronized MailTaskSchedule getInstance() {
        if (null == instance) {
            instance = new MailTaskSchedule();
        }
        return instance;
    }

    private void executeTask() {
        long oneDay = 24 * 60 * 60 * 1000;
        long initDelay = DateUtil.getTimeMillis("17:30:00") - System.currentTimeMillis();
        initDelay = initDelay > 0 ? initDelay : oneDay + initDelay;
        scheduledExecutorService.scheduleAtFixedRate(new MailTask(), initDelay, oneDay, TimeUnit.MILLISECONDS);
    }


}
