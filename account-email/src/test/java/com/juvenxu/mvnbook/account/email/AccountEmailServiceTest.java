package com.juvenxu.mvnbook.account.email;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetupTest;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.mail.Message;

/**
 * Created with IntelliJ IDEA.
 * User: keer
 * Date: 13-4-4
 * Time: 上午10:50
 */
public class AccountEmailServiceTest {
    private GreenMail greenMail;

    @Before
    public void startMailServer() throws Exception {
//        greenMail = new GreenMail(ServerSetup.SMTP);
        greenMail = new GreenMail(ServerSetupTest.SMTP);
        greenMail.setUser("test@juvenxu.com", "123456");
        greenMail.start();
    }

    @Test
    public void testSendMail() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("account-email.xml");
        AccountEmailService accountEmailService =
                (AccountEmailService) ctx.getBean("accountEmailService");
        String subject = "Test subject";
        String htmlText = "<h3>Test</h3>";
        accountEmailService.sendMail("test2@juvenxu.com", subject, htmlText);

        greenMail.waitForIncomingEmail(2000, 1);

        Message[] msgs = greenMail.getReceivedMessages();
        Assert.assertEquals(1, msgs.length);
        Assert.assertEquals(subject, msgs[0].getSubject());
        Assert.assertEquals(htmlText, GreenMailUtil.getBody(msgs[0]).trim());
    }

    @After
    public void stopMailServer() {
        greenMail.stop();
    }

}
