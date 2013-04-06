package com.juvenxu.mvnbook.account.captcha;

import junit.framework.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: keer
 * Date: 13-4-6
 * Time: 下午8:06
 */
public class RandomeGeneratorTest {
    @Test
    public void testGetRandomString() throws Exception {
        Set<String> randoms = new HashSet<String>(100);
        for (int i = 0; i < 100; i++) {
            String random = RandomGenerator.getRandomString();
            Assert.assertFalse(randoms.contains(random));
            randoms.add(random);
        }
    }
}
