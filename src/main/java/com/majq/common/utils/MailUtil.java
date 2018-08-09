package com.majq.common.utils;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * 工具类
 */
public class MailUtil {

    public static InternetAddress [] getAddress(List<String>recievers){
        if(null != recievers && recievers.size()>0){
            List<InternetAddress> internetAddresses = new ArrayList<>();
            for(String reciever : recievers){
                if(null != reciever && reciever.length()>0){
                    try {
                        internetAddresses.add(new InternetAddress(reciever));
                    } catch (AddressException e) {
                        e.printStackTrace();
                    }
                }
            }
            return internetAddresses.toArray(new InternetAddress [internetAddresses.size()]);
        }
        return null;
    }


}
