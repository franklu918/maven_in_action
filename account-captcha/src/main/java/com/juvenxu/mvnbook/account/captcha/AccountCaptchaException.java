package com.juvenxu.mvnbook.account.captcha;

/**
 * Created with IntelliJ IDEA.
 * User: keer
 * Date: 13-4-6
 * Time: 下午6:21
 */
public class AccountCaptchaException extends Exception {
    public AccountCaptchaException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public AccountCaptchaException(String s) {

        super(s);
    }
}
