package com.majq.sendmail.constant.enums;

import com.majq.sendmail.constant.StrConst;

/**
 * 发件人枚举
 */
public enum SenderlEnum {
    SELF_COMPANY_MAIL(StrConst.SELF_COMPANY_TRUE_STR,StrConst.SELF_COMPANY_SEND_PROTOCOL,StrConst.SELF_COMPANY_SEND_SERVER,StrConst.SELF_COMPANY_RECIEVE_PROTOCOL,StrConst.SELF_COMPANY_REVIEVE_SERVER,
            true,StrConst.SELF_COMPANY_SENDER_ADDRESS,StrConst.SELF_COMPANY_SENDER_ACCOUNT,StrConst.SELF_COMPANY_SENDER_PASSWORD,"公司邮箱地址");
    /**
     * 用户认证方式
     */
    String authType;
    /**
     * 发件传输协议
     */
    String sendProtocol;
    /**
     * 发件服务器地址
     */
    String sendServerIp;
    /**
     * 收件传输协议
     */
    String receiveProtocol;
    /**
     * 收件服务器
     */
    String recieveServerIp;
    /**
     * 是否打印调试信息
     */
    boolean debuggable;
    /**
     * 发件人地址
     */
    String senderAddress;
    /**
     * 发件人账号
     */
    String senderAccount;
    /**
     * 发件人密码
     */
    String senderPassword;

    /**
     * 备注
     */
    String description;


    SenderlEnum(String authType, String sendProtocol, String sendServerIp,
                String receiveProtocol, String recieveServerIp, boolean debuggable,
                String senderAddress,String senderAccount, String senderPassword,
                String description) {
        this.authType = authType;
        this.sendProtocol = sendProtocol;
        this.sendServerIp = sendServerIp;
        this.receiveProtocol = receiveProtocol;
        this.recieveServerIp = recieveServerIp;
        this.debuggable = debuggable;
        this.senderAddress = senderAddress;
        this.senderAccount = senderAccount;
        this.senderPassword = senderPassword;
        this.description = description;
    }

    public String getAuthType() {
        return authType;
    }

    public String getSendProtocol() {
        return sendProtocol;
    }

    public String getSendServerIp() {
        return sendServerIp;
    }

    public String getReceiveProtocol() {
        return receiveProtocol;
    }

    public String getRecieveServerIp() {
        return recieveServerIp;
    }

    public boolean isDebuggable() {
        return debuggable;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public String getSenderAccount() {
        return senderAccount;
    }

    public String getSenderPassword() {
        return senderPassword;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SenderlEnum{");
        sb.append("authType='").append(authType).append('\'');
        sb.append(", sendProtocol='").append(sendProtocol).append('\'');
        sb.append(", sendServerIp='").append(sendServerIp).append('\'');
        sb.append(", receiveProtocol='").append(receiveProtocol).append('\'');
        sb.append(", recieveServerIp='").append(recieveServerIp).append('\'');
        sb.append(", debuggable=").append(debuggable);
        sb.append(", senderAddress='").append(senderAddress).append('\'');
        sb.append(", senderAccount='").append(senderAccount).append('\'');
        sb.append(", senderPassword='").append(senderPassword).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
