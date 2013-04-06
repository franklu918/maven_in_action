package com.juvenxu.mvnbook.account.persist;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: keer
 * Date: 13-4-5
 * Time: 下午9:05
 */
public class AccountPersistException extends Exception {
    public AccountPersistException(String message, IOException e) {
        super(message);
    }

    public AccountPersistException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
