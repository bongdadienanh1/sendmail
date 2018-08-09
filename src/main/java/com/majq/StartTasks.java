package com.majq;

import com.majq.sendmail.EmailSenderTask;
import com.majq.taskschedule.TaskSchedule;

public class StartTasks {
    public static void main(String[] args) {
        TaskSchedule taskSchedule = TaskSchedule.getInstance();
        taskSchedule.executeTask(new EmailSenderTask());
    }
}
