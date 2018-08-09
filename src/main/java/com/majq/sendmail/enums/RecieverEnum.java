package com.majq.sendmail.enums;


import com.majq.common.constant.StrConst;
import com.majq.common.utils.MailUtil;

import javax.mail.internet.InternetAddress;
import java.util.Arrays;
import java.util.List;

/**
 * 收件人枚举
 */
public enum RecieverEnum {
    SelfMailTest(StrConst.RECIEVERS);
    /**
     * 收件人地址
     */
    InternetAddress [] recieverAddress;

    RecieverEnum(List<String>recievers) {
        this.recieverAddress = MailUtil.getAddress(recievers);
    }


    public InternetAddress[] getRecieverAddress() {
        return recieverAddress;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("RecieverEnum{");
        sb.append("recieverAddress=").append(recieverAddress == null ? "null" : Arrays.asList(recieverAddress).toString());
        sb.append('}');
        return sb.toString();
    }
}
