package com.juvenxu.mvnbook.account.service;

/**
 * Created with IntelliJ IDEA.
 * User: keer
 * Date: 13-4-8
 * Time: 下午10:21
 */
public class AccountServiceException extends Exception {
    public AccountServiceException(String s) {
        super(s);
    }

    public AccountServiceException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
