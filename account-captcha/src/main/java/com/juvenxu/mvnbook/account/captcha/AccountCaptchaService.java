package com.juvenxu.mvnbook.account.captcha;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: keer
 * Date: 13-4-6
 * Time: 下午6:20
 */
public interface AccountCaptchaService {
    String generateCaptchaKey()
            throws AccountCaptchaException;

    byte[] generateCaptchaImge(String captchaKey)
            throws AccountCaptchaException;

    boolean validateCaptcha(String captchaKey, String captchaValue)
            throws AccountCaptchaException;

    List<String> getPreDefinedTexts();

    void setPreDefinedTexts(List<String> preDefinedTexts);
}
