package com.majq.sendmail.mailbean;

/**
 * 发件人信息
 */
public class SenderInfo {
    /**
     * 用户认证方式
     */
    private String authType;
    /**
     * 发件传输协议
     */
    private String sendProtocol;
    /**
     * 发件服务器地址
     */
    private String sendServerIp;
    /**
     * 收件传输协议
     */
    private String receiveProtocol;
    /**
     * 收件服务器
     */
    private String recieveServerIp;
    /**
     * 是否打印调试信息
     */
    private boolean debuggable;
    /**
     * 发件人地址
     */
    private String senderAddress;
    /**
     * 发件人账号
     */
    private String senderAccount;
    /**
     * 发件人密码
     */
    private String senderPassword;
    /**
     * 备注
     */
    private String description;

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public String getSendProtocol() {
        return sendProtocol;
    }

    public void setSendProtocol(String sendProtocol) {
        this.sendProtocol = sendProtocol;
    }

    public String getSendServerIp() {
        return sendServerIp;
    }

    public void setSendServerIp(String sendServerIp) {
        this.sendServerIp = sendServerIp;
    }

    public String getReceiveProtocol() {
        return receiveProtocol;
    }

    public void setReceiveProtocol(String receiveProtocol) {
        this.receiveProtocol = receiveProtocol;
    }

    public String getRecieveServerIp() {
        return recieveServerIp;
    }

    public void setRecieveServerIp(String recieveServerIp) {
        this.recieveServerIp = recieveServerIp;
    }

    public boolean isDebuggable() {
        return debuggable;
    }

    public void setDebuggable(boolean debuggable) {
        this.debuggable = debuggable;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(String senderAccount) {
        this.senderAccount = senderAccount;
    }

    public String getSenderPassword() {
        return senderPassword;
    }

    public void setSenderPassword(String senderPassword) {
        this.senderPassword = senderPassword;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SenderInfo{");
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
