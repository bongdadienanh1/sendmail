package com.majq.taskschedule;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 执行任务
 */
public class TaskSchedule {

    /**
     * 单例
     */
    private static TaskSchedule instance = null;
    /**
     * 任务执行器
     */
    private ScheduledExecutorService scheduledExecutorService;

    private TaskSchedule() {
        this.scheduledExecutorService = Executors.newScheduledThreadPool(2);
    }

    /**
     * 返回实例
     *
     * @return
     */
    public static synchronized TaskSchedule getInstance() {
        if (null == instance) {
            instance = new TaskSchedule();
        }
        return instance;
    }

    /**
     * 执行任务
     * @param task
     */
    public void executeTask(AbstractTask task) {
        scheduledExecutorService.scheduleAtFixedRate(task, task.getInitialDelay(), task.getPeriod(), task.getUnit());
    }


}
