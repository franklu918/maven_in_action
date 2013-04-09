package com.juvenxu.mvnbook.account.web;

import com.juvenxu.mvnbook.account.service.AccountService;
import com.juvenxu.mvnbook.account.service.AccountServiceException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: keer
 * Date: 13-4-9
 * Time: 下午8:27
 */
public class CaptchaImageServlet extends HttpServlet {
    private ApplicationContext context;

    @Override
    public void init() throws ServletException {
        super.init();
        context = WebApplicationContextUtils.getWebApplicationContext(
                getServletContext()
        );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String key = req.getParameter("key");
        if (key == null || key.length() == 0) {
            resp.sendError(400, "No Captcha Key Found");
        } else {
            AccountService service =
                    (AccountService) context.getBean("accountService");
            try {
                resp.setContentType("image/jpeg");
                OutputStream out = resp.getOutputStream();
                out.write(service.generateCaptchaImage(key));
                out.close();
            } catch (AccountServiceException e) {
                resp.sendError(404, e.getMessage());
            }
        }
    }
}
