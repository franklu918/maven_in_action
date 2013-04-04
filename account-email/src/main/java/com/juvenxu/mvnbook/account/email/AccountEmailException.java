package com.juvenxu.mvnbook.account.email;

/**
 * Created with IntelliJ IDEA.
 * User: keer
 * Date: 13-4-3
 * Time: 下午11:31
 */
public class AccountEmailException extends Exception {
    public AccountEmailException(String messge) {
        super(messge);
    }

    public AccountEmailException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
