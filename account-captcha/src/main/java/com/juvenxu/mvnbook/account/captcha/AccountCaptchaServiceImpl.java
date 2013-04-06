package com.juvenxu.mvnbook.account.captcha;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.beans.factory.InitializingBean;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: keer
 * Date: 13-4-6
 * Time: 下午6:31
 */
public class AccountCaptchaServiceImpl implements
        AccountCaptchaService, InitializingBean {

    public List<String> getPreDefinedTexts() {
        return preDefinedTexts;
    }

    public void setPreDefinedTexts(List<String> preDefinedTexts) {
        this.preDefinedTexts = preDefinedTexts;
    }

    private List<String> preDefinedTexts;
    private Map<String, String> captchaMap = new HashMap<String, String>();
    private int textCount = 0;
    private DefaultKaptcha producer;

    public void afterPropertiesSet() {
        producer = new DefaultKaptcha();
        producer.setConfig(new Config(new Properties()));
    }

    public String generateCaptchaKey() throws AccountCaptchaException {
        String key = RandomGenerator.getRandomString();
        String value = getCaptchaText();
        captchaMap.put(key, value);
        return key;
    }

    private String getCaptchaText() {
        if (preDefinedTexts != null && !preDefinedTexts.isEmpty()) {
            String text = preDefinedTexts.get(textCount);
            textCount = (textCount + 1) % preDefinedTexts.size();
            return text;
        } else {
            return producer.createText();
        }
    }


    public byte[] generateCaptchaImge(String captchaKey)
            throws AccountCaptchaException {
        String text = captchaMap.get(captchaKey);
        if (text == null) {
            throw new AccountCaptchaException("Captch key '"
                    + captchaKey + "' not found!");
        }
        BufferedImage image = producer.createImage(text);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", out);
        } catch (IOException e) {
            throw new AccountCaptchaException("Failed to write captcha stream!", e);
        }
        return out.toByteArray();
    }

    public boolean validateCaptcha(String captchaKey, String captchaValue) throws AccountCaptchaException {
        String text = captchaMap.get(captchaKey);
        if (text == null) {
            throw new AccountCaptchaException("Captcha key '"
                    + captchaKey + "'not found!");
        }
        if (text.equals(captchaValue)) {
            captchaMap.remove(captchaKey);
            return true;
        } else {
            return false;
        }
    }
}
