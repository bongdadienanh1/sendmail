package com.majq.taskschedule;

import com.majq.common.utils.DateUtil;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 执行任务
 */
public class TaskSchedule {

    public long start;
    private ScheduledExecutorService scheduledExecutorService;
    private static TaskSchedule instance = null;

    private TaskSchedule() {
        this.scheduledExecutorService = Executors.newScheduledThreadPool(2);
        this.start = System.currentTimeMillis();
    }

    public static synchronized TaskSchedule getInstance() {
        if (null == instance) {
            instance = new TaskSchedule();
        }
        return instance;
    }

    public void executeTask(AbstractTask task) {
        long oneDay = 24 * 60 * 60 * 1000;
        long initDelay = DateUtil.getTimeMillis("17:30:00") - System.currentTimeMillis();
        initDelay = initDelay > 0 ? initDelay : oneDay + initDelay;
        scheduledExecutorService.scheduleAtFixedRate(task, initDelay, oneDay, TimeUnit.MILLISECONDS);
    }


}
