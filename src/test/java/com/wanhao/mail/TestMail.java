package com.wanhao.mail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.junit.Test;

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
        email.setHostName(Constants.HOSTNAME);
        email.setSmtpPort(Constants.SMTPPORT);
        email.setAuthenticator(new DefaultAuthenticator(Constants.account, Constants.token));
        email.setSSLOnConnect(true);

        try {
            email.setFrom("838088516@qq.com");
            email.setSubject("2018年8月29日09:27:22");
            email.setMsg("This is a test mail ... :-)");
            email.addTo("liulihao@shundesoft.com");
            email.send();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
