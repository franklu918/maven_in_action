package com.juvenxu.mvnbook.account.captcha;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: keer
 * Date: 13-4-6
 * Time: 下午8:08
 */
public class AccountCaptchaServiceTest {
    private AccountCaptchaService service;

    @Before
    public void prepare() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("account-captcha.xml");
        service = (AccountCaptchaService) ctx.getBean("accountCaptchaService");
    }

    @Test
    public void testGenerateCaptcha() throws Exception {
        String captchaKey = service.generateCaptchaKey();
        Assert.assertNotNull(captchaKey);

        byte[] captchaImage = service.generateCaptchaImge(captchaKey);
        Assert.assertTrue(captchaImage.length > 0);

        File image = new File("target/" + captchaKey + ".jpg");
        OutputStream output = null;
        try {
            output = new FileOutputStream(image);
            output.write(captchaImage);
        } finally {
            if (output != null) {
                output.close();
            }
        }
        Assert.assertTrue(image.exists() && image.length() > 0);
    }

    @Test
    public void testValidateCaptchaCorrent() throws Exception {
        List<String> preDefinedTexts = new ArrayList<String>();
        preDefinedTexts.add("12345");
        preDefinedTexts.add("abcde");
        service.setPreDefinedTexts(preDefinedTexts);

        String captchaKey = service.generateCaptchaKey();
        service.generateCaptchaImge(captchaKey);
        Assert.assertTrue(service.validateCaptcha(captchaKey, "12345"));

        captchaKey = service.generateCaptchaKey();
        service.generateCaptchaImge(captchaKey);
        Assert.assertTrue(service.validateCaptcha(captchaKey, "abcde"));
    }

    @Test
    public void testValidateCaptchaIncorrect() throws Exception {
        List<String> preDefinedTexts = new ArrayList<String>();
        preDefinedTexts.add("12345");
        service.setPreDefinedTexts(preDefinedTexts);

        String captchaKey = service.generateCaptchaKey();
        service.generateCaptchaImge(captchaKey);
        Assert.assertFalse(service.validateCaptcha(captchaKey, "67890"));
    }

}
