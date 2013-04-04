package com.juvenxu.mvnbook.account.email;

/**
 * Created with IntelliJ IDEA.
 * User: keer
 * Date: 13-4-3
 * Time: 下午11:21
 */
public interface AccountEmailService {
    void sendMail(String to, String subject, String htmlText)
            throws AccountEmailException;
}
