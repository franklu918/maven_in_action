package com.juvenxu.mvnbook.account.persist;

/**
 * Created with IntelliJ IDEA.
 * User: keer
 * Date: 13-4-5
 * Time: 下午9:03
 */
public interface AccountPersistService {
    Account createAccount(Account account) throws AccountPersistException;

    Account readAccount(String id) throws AccountPersistException;

    Account updateAccount(Account account) throws AccountPersistException;

    void deleteAccount(String id) throws AccountPersistException;
}
