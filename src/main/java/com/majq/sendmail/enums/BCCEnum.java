package com.majq.sendmail.enums;


import com.majq.common.constant.StrConst;
import com.majq.common.utils.MailUtil;

import javax.mail.internet.InternetAddress;
import java.util.Arrays;
import java.util.List;

public enum BCCEnum {
    SelfMailTest(StrConst.RECIEVERS);
    /**
     * 收件人地址
     */
    InternetAddress [] bccAddress;

    BCCEnum(List<String>recievers) {
        this.bccAddress = MailUtil.getAddress(recievers);
    }


    public InternetAddress[] getBccAddress() {
        return bccAddress;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BCCEnum{");
        sb.append("bccAddress=").append(bccAddress == null ? "null" : Arrays.asList(bccAddress).toString());
        sb.append('}');
        return sb.toString();
    }
}
