package com.majq.taskschedule;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

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
        scheduledExecutorService.scheduleAtFixedRate(task, task.getInitialDelay(), task.getPeriod(), task.getUnit());
    }


}
