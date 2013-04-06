package com.juvenxu.mvnbook.account.persist;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: keer
 * Date: 13-4-6
 * Time: 上午9:14
 */
public class AccountPersistServiceTest {
    private AccountPersistService service;

    @Before
    public void prepare() throws Exception {
        File persistDataFile = new File("target/test-classes/persist-data.xml");
        if (persistDataFile.exists()) {
            persistDataFile.delete();
        }

        ApplicationContext ctx = new ClassPathXmlApplicationContext("account-persist.xml");
        service = (AccountPersistService) ctx.getBean("accountPersistService");
        Account account = new Account();
        account.setId("juven");
        account.setName("Juven Xu");
        account.setEmail("juven@changeme.com");
        account.setPassword("123456");
        account.setActivated(true);

        service.createAccount(account);
    }

    @Test
    public void testReadAccount() throws Exception{
        Account account = service.readAccount("juven");

        Assert.assertNotNull(account);
        Assert.assertEquals("juven",account.getId());

    }
}
