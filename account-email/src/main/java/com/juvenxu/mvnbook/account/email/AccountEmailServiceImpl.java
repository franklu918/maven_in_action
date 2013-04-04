package com.juvenxu.mvnbook.account.email;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created with IntelliJ IDEA.
 * User: keer
 * Date: 13-4-3
 * Time: 下午11:19
 */
public class AccountEmailServiceImpl implements AccountEmailService {
    private JavaMailSender javaMailSender;
    private String systemEmail;

    @Override
    public void sendMail(String to, String subject, String htmlText)
            throws AccountEmailException {
        try {
            //msg对应着将要发送的邮件
            MimeMessage msg = javaMailSender.createMimeMessage();
            //帮助设置邮件msg相关信息
            MimeMessageHelper msgHelper = new MimeMessageHelper(msg);

            msgHelper.setFrom(systemEmail);
            msgHelper.setTo(to);
            msgHelper.setSubject(subject);
            msgHelper.setText(htmlText, true);

            javaMailSender.send(msg);
        } catch (MessagingException e) {
            throw new AccountEmailException("Faild to send mail.", e);

        }

    }

    public JavaMailSender getJavaMailSender() {
        return javaMailSender;
    }

    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public String getSystemEmail() {
        return systemEmail;
    }

    public void setSystemEmail(String systemEmail) {
        this.systemEmail = systemEmail;
    }
}
