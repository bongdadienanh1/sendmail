package com.majq.taskschedule;

import com.majq.sendmail.EmailSender;
import com.majq.sendmail.constant.enums.BCCEnum;
import com.majq.sendmail.constant.enums.CCEnum;
import com.majq.sendmail.constant.enums.RecieverEnum;
import com.majq.sendmail.constant.enums.SenderlEnum;

import javax.mail.MessagingException;

public class MailTask implements Runnable {

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try {
            EmailSender.sendMail(SenderlEnum.SELF_COMPANY_MAIL, RecieverEnum.SelfMailTest, CCEnum.SelfMailTest, BCCEnum.SelfMailTest);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
