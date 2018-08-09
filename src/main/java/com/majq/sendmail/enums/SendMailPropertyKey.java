package com.majq.sendmail.enums;


import com.majq.common.constant.StrConst;

public enum SendMailPropertyKey {
    MAIL_SMTP_AUTH(StrConst.MAIL_SMTP_AUTH),
    MAIL_TRANSPORT_PROTOCOL(StrConst.MAIL_TRANSPORT_PROTOCOL),
    MAIL_SMTP_HOST(StrConst.MAIL_SMTP_HOST)
    ;

    String keyStr;

    SendMailPropertyKey(String keyStr) {
        this.keyStr = keyStr;
    }

    public String getKeyStr() {
        return keyStr;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SendMailPropertyKey{");
        sb.append("keyStr='").append(keyStr).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
