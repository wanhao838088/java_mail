package com.wanhao.mail;

import org.apache.commons.mail.*;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by LiuLiHao on 2018/8/29 9:16.
 * 描述：
 * 作者： LiuLiHao
 */
public class TestMail {


    /**
     * 发送普通文本邮件
     */
    @Test
    public void test1(){
        Email email = new SimpleEmail();
        setAccount(email);
        try {
            email.setFrom("838088516@qq.com");
            email.setSubject("2018年8月29日09:27:22");
            email.setMsg("这是普通文本邮件");
            email.addTo("liulihao@shundesoft.com");
            email.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送带附件的邮件
     */
    @Test
    public void sendWithAttachments(){

        // Create the attachment
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath("3.jpg");
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("艺术照");
        attachment.setName("老王.jpg");

        try {
            // Create the email message
            MultiPartEmail email = new MultiPartEmail();

            setAccount(email);

            email.addTo("liulihao@shundesoft.com");
            email.setFrom("838088516@qq.com");
            email.setSubject("一张照骗");
            email.setMsg("2018年8月29日09:54:59发的");

            //添加附件
            email.attach(attachment);

            //发送
            email.send();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sendHtmlEmail(){
        HtmlEmail email = new HtmlEmail();
        setAccount(email);
        try {
            // embed the image and get the content id
            URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");
            String cid = email.embed(url, "Apache logo");

            // set the html message
            email.setHtmlMsg("<html>The apache logo - <img src=\"cid:"+cid+"\"></html>");

            // set the alternative message
            email.setTextMsg("Your email client does not support HTML messages");

            // send the email
            email.send();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }

    //设置账户信息
    private void setAccount(Email email) {
        email.setHostName(Constants.HOSTNAME);
        email.setSmtpPort(Constants.SMTPPORT);
        email.setAuthenticator(new DefaultAuthenticator(Constants.account, Constants.token));
        email.setSSLOnConnect(true);

        try {
            email.addTo("liulihao@shundesoft.com");
            email.setFrom("838088516@qq.com");
            email.setSubject("2018年8月29日10:12:32");
        } catch (EmailException e) {
            e.printStackTrace();
        }

    }


}
