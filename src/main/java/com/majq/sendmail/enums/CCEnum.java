package com.majq.sendmail.enums;


import com.majq.common.constant.StrConst;
import com.majq.common.utils.MailUtil;

import javax.mail.internet.InternetAddress;
import java.util.Arrays;
import java.util.List;

/**
 * 抄送人信息
 */
public enum CCEnum{
    SelfMailTest(StrConst.RECIEVERS);
    /**
     * 收件人地址
     */
    InternetAddress [] ccAddresses;

    CCEnum(List<String>recievers) {
        this.ccAddresses = MailUtil.getAddress(recievers);
    }


    public InternetAddress[] getCcAddresses() {
        return ccAddresses;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CCEnum{");
        sb.append("ccAddresses=").append(ccAddresses == null ? "null" : Arrays.asList(ccAddresses).toString());
        sb.append('}');
        return sb.toString();
    }
}
