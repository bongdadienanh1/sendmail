package com.majq.sendmail;


import com.majq.sendmail.constant.StrConst;
import com.majq.sendmail.constant.enums.*;
import com.majq.sendmail.templatebean.Reportmail;
import com.majq.sendmail.utils.FreemarkerUtil;
import freemarker.template.TemplateException;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 发送邮件
 */
public class EmailSender {

     public static void main(String [] args) throws MessagingException {
         sendMail(SenderlEnum.SELF_COMPANY_MAIL, RecieverEnum.SelfMailTest, CCEnum.SelfMailTest, BCCEnum.SelfMailTest);
     }

    /**
     * 发送邮件
     * @param senderlEnum
     * @param recieverEnum
     * @throws MessagingException
     */
    public static void sendMail(SenderlEnum senderlEnum, RecieverEnum recieverEnum, CCEnum ccEnum, BCCEnum bccEnum) throws MessagingException {
         Properties properties = getMailProperties(senderlEnum);
         Session session = getSession(properties,senderlEnum);
        Message message = getMimeMessage(session, senderlEnum, recieverEnum, ccEnum, bccEnum, null, getSubject(), null, null);
         exeSendTask(session,message,senderlEnum);
     }

    /**
     * 生成主题
     *
     * @return
     */
    private static String getSubject() {
        String date = new SimpleDateFormat("yyyy.MM.dd").format(new Date());
        return "日报_马俊强_" + date;
    }

    /**
     * 构造邮件属性
     * @param senderlEnum
     * @return
     */
     private static Properties getMailProperties(SenderlEnum senderlEnum){
         Properties properties = new Properties();
         properties.setProperty(SendMailPropertyKey.MAIL_SMTP_AUTH.getKeyStr(),senderlEnum.getAuthType());
         properties.setProperty(SendMailPropertyKey.MAIL_TRANSPORT_PROTOCOL.getKeyStr(),senderlEnum.getSendProtocol());
         properties.setProperty(SendMailPropertyKey.MAIL_SMTP_HOST.getKeyStr(),senderlEnum.getSendServerIp());
         return properties;
     }

    /**
     * 获取Session
     * @param properties
     * @param senderlEnum
     * @return
     */
    private static Session getSession(Properties properties, SenderlEnum senderlEnum) {
         Session session = Session.getInstance(properties);
         session.setDebug(senderlEnum.isDebuggable());
         return session;
     }

    /**
     * 执行发送任务
     * @param session
     * @param message
     * @param senderlEnum
     * @throws MessagingException
     */
    private static void exeSendTask(Session session, Message message, SenderlEnum senderlEnum) throws MessagingException {
         Transport transport = session.getTransport();
         transport.connect(senderlEnum.getSenderAccount(),senderlEnum.getSenderPassword());
         transport.sendMessage(message,message.getAllRecipients());
         transport.close();
     }

    /**
     * 创建邮件正文
     * @param session
     * @return
     */
     public static MimeMessage getMimeMessage(Session session, SenderlEnum senderlEnum, RecieverEnum recieverEnum, CCEnum ccEnum, BCCEnum bccEnum,
                                              String subject, String content, String imgPath, String attachPath) throws MessagingException {
         MimeMessage mimeMessage = null;
         if(null != session && null != senderlEnum && null != recieverEnum)
         {
             mimeMessage = new MimeMessage(session);
             setHeader(mimeMessage,senderlEnum,recieverEnum,ccEnum,bccEnum,subject);
             //assembleBody(mimeMessage, content, imgPath, attachPath);
             try {
                 assembleBody(mimeMessage, "reportmail.ftl", getContentMap());
             } catch (IOException e) {
                 e.printStackTrace();
             } catch (TemplateException e) {
                 e.printStackTrace();
             }
         }
         return mimeMessage;
     }

    private static Map<String, Object> getContentMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("reportmail", getMailBean());
        return map;
    }

    private static Reportmail getMailBean() {
        String tddate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String name = "马俊强";
        String department = "技术中心—架构组";
        String timeam = "08:30-11:30";
        String workcontentam = "EDR2.0舆情接口开发";
        String wayam = "讲述";
        String telleram = "陈鑫";
        String timepm = "13:00-17:30";
        String waypm = "讲述";
        String workcontentpm = "EDR2.0舆情接口开发";
        String tellerpm = "陈鑫";
        String experience = "";
        String suggestion = "";
        Reportmail reportmail = new Reportmail(tddate, name, department, timeam, workcontentam, wayam, telleram, timepm, waypm, workcontentpm, tellerpm, experience, suggestion);
        return reportmail;
    }

    /**
     * 设置邮件头部信息
     * @param mimeMessage
     * @param senderlEnum
     * @param recieverEnum
     * @param ccEnum
     * @param bccEnum
     * @param subject
     * @return
     * @throws MessagingException
     */
    private static void setHeader(MimeMessage mimeMessage, SenderlEnum senderlEnum, RecieverEnum recieverEnum, CCEnum ccEnum, BCCEnum bccEnum, String subject) throws MessagingException {
         if(null != mimeMessage && null != senderlEnum && null != recieverEnum){
             mimeMessage.setFrom(new InternetAddress(senderlEnum.getSenderAddress()));
             mimeMessage.setRecipients(MimeMessage.RecipientType.TO,recieverEnum.getRecieverAddress());
             if(null != ccEnum) mimeMessage.setRecipients(MimeMessage.RecipientType.CC,ccEnum.getCcAddresses());
             if(null != bccEnum) mimeMessage.setRecipients(MimeMessage.RecipientType.BCC,bccEnum.getBccAddress());
             mimeMessage.setSubject(subject,StrConst.UTF_8_STR);
             mimeMessage.setSentDate(new Date());
         }
     }

    /**
     * 根据传入内容构造邮件正文信息
     * @return
     */
     private static void assembleBody(MimeMessage mimeMessage,String content,String imgPath,String attachPath) throws MessagingException {
         MimeMultipart body = null;
         //组装正文
         List<MimeBodyPart> bodyParts = new ArrayList<>();
         bodyParts.add(getBodyPartByContent(content,"contentId"));
         bodyParts.add(getBodyPartByPath(imgPath,"imageId"));
         bodyParts.add(getBodyPartByPath(attachPath,"attachId"));
         body = getMultipart(bodyParts,"");
         mimeMessage.setContent(body,StrConst.CONTENT_TYPE);
     }

    private static void assembleBody(MimeMessage mimeMessage, String tempName, Map<String, Object> mailContent) throws IOException, TemplateException, MessagingException {
        if (null != mimeMessage && null != mailContent && null != tempName && tempName.length() > 0) {
            mimeMessage.setContent(generateHtmlBody(tempName, mailContent), "text/html;charset=UTF-8");
        }
    }


    /**
     * 根据传入内容构造MimeBodyPart
     * @param content
     * @return
     */
    private static MimeBodyPart getBodyPartByContent(String content,String cId) throws MessagingException {
        MimeBodyPart bodyPart = null;
        if(null != content && content.trim().length()>0){
            bodyPart = new MimeBodyPart();
            bodyPart.setContent(content,StrConst.UTF_8_STR);
            bodyPart.setContentID(cId);
        }
        return bodyPart;
    }

    /**
     * 根据传入路径构造MimeBodyPart
     * @param fileDataPath
     * @return
     */
    private static MimeBodyPart getBodyPartByPath(String fileDataPath,String cId) throws MessagingException {
        MimeBodyPart bodyPart = null;
        if(null != fileDataPath && fileDataPath.trim().length()>0){
            bodyPart = new MimeBodyPart();
            DataHandler dataHandler = new DataHandler(new FileDataSource(fileDataPath));
            bodyPart.setDataHandler(dataHandler);
            bodyPart.setContentID(cId);
        }
        return bodyPart;
    }

    /**
     * 将MultiBodyPart 组装为 MultiPart
     * @param bodyParts
     * @param subType
     * @return
     * @throws MessagingException
     */
    private static MimeMultipart getMultipart(List<MimeBodyPart> bodyParts, String subType) throws MessagingException {
        MimeMultipart multipart = null;
        if(null != bodyParts && bodyParts.size()>0){
            multipart = new MimeMultipart();
            for(int i = 0; i < bodyParts.size(); i++){
                multipart.addBodyPart(bodyParts.get(i),i);
            }
            if(null != subType && subType.trim().length()>0) multipart.setSubType(subType);
        }
        return multipart;
    }


    private static String generateHtmlBody(String templateName, Map<String, Object> mailContent) throws IOException, TemplateException {
        if (null != mailContent) {
            StringWriter stringWriter = new StringWriter();
            FreemarkerUtil.print(templateName, mailContent, stringWriter);
            return stringWriter.toString();
        }
        return null;
    }


}
