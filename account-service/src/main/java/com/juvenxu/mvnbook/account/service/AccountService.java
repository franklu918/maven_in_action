package com.juvenxu.mvnbook.account.service;

/**
 * Created with IntelliJ IDEA.
 * User: keer
 * Date: 13-4-8
 * Time: 下午10:20
 */
public interface AccountService {
    String generateCaptchaKey() throws AccountServiceException;

    byte[] generateCaptchaImage(String captchaKey) throws AccountServiceException;

    void signUp(SignUpRequest signUpRequest) throws AccountServiceException;

    void activate(String activationNumber) throws AccountServiceException;

    void login(String id, String password) throws AccountServiceException;
}
