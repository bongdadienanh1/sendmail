package com.majq.common.constant;

import java.util.Arrays;
import java.util.List;

public class StrConst {

    public static final String SELF_COMPANY_TRUE_STR = "true";

    public static final String SELF_COMPANY_SEND_PROTOCOL = "smtp";

    public static final String SELF_COMPANY_SEND_SERVER = "smtp.finchina.com";

    public static final String SELF_COMPANY_RECIEVE_PROTOCOL = "imap";

    public static final String SELF_COMPANY_REVIEVE_SERVER = "imap.finchina.com";

    public static final String SELF_COMPANY_SENDER_ADDRESS = "10.15.43.254";

    public static final String SELF_COMPANY_SENDER_ACCOUNT = "majq@finchina.com";

    public static final String SELF_COMPANY_SENDER_PASSWORD = "finchina123";

    public static final String SELF_QQ_MAIL_ADDRESS = "1924528451@qq.com";

    public static final String MAIL_SMTP_AUTH = "mail.smtp.auth";

    public static final String MAIL_TRANSPORT_PROTOCOL = "mail.transport.protocol";

    public static final String MAIL_SMTP_HOST = "mail.smtp.host";

    public static final String CONTENT_TYPE = "text/html;charset=UTF-8";

    public static final String UTF_8_STR = "UTF-8";

    //试用期报告邮件收件人、密送人
    public static final String HR_MAIL = "hr.dept.list@finchina.com";

    public static final String CHENXIN_MAIL = "chenxin@finchina.com";

    public static final String ZHAOLEI_MAIL = "zhaolei@finchina.com";

    public static final String[] RECIEVE_ADDRESSES = {HR_MAIL, CHENXIN_MAIL, ZHAOLEI_MAIL};

    public static final List<String> RECIEVERS = Arrays.asList(RECIEVE_ADDRESSES);

    public static final String[] BCC_ADDRESS = {SELF_QQ_MAIL_ADDRESS};

    public static final List<String> BCC = Arrays.asList(BCC_ADDRESS);

}
