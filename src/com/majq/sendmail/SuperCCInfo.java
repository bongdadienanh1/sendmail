package com.majq.sendmail;

import com.majq.sendmail.utils.MailUtil;

import javax.mail.internet.InternetAddress;
import java.util.List;

public class SuperCCInfo {
    private InternetAddress[] recieverAddress;

    private List<String> recievers;

    public List<String> getRecievers() {
        return recievers;
    }

    public void setRecievers(List<String> recievers) {
        this.recievers = recievers;
    }

    public InternetAddress[] getRecieverAddress() {
        this.recieverAddress = MailUtil.getAddress(recievers);
        return this.recieverAddress;
    }
}
