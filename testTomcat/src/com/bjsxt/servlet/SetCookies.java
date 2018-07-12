/**
 * Copyright 2014-2016 www.fangdd.com All Rights Reserved.
 * Author: Tang Yuqian <tangyuqian-sz@fangdd.com>
 * Date: 2018/7/9
 */
package com.bjsxt.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SetCookies extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        for (int i = 0; i < 3; i++) {
            // Default maxAge is -1, indicating cookie applies only to current browsing session.
            // 有效期在当前浏览器 或子窗口
            Cookie cookie = new Cookie("Session-Cookie-" + i,"Cookie-Value-S" + i);
            response.addCookie(cookie);

            Cookie cookie1 = new Cookie("Persistent-Cookie-" + i, "Cookie-Value-P" + i);
            // Cookie is valid for an hour, regardless of whether user quits browser, reboots computer or whatever.
            cookie1.setMaxAge(3600);
            response.addCookie(cookie1);
        }
        response.setContentType("text/html;charset=gb2312");
        PrintWriter printWriter = response.getWriter();
        String title = "Setting Cookies";
        printWriter.println("<html><head><title>设置cookie</title></head>"
                + "<BODY BGCOLOR=\"#FDF5E6\">\n" + "<HI ALIGN=\"CENTER\">"
                + title + "</HI>\n"
                + "There are six cookies associated with this page.\n"
                + "To see them, visit the\n" + "<A HREF=\"ShowCookies\">\n"
                + "<CODE> ShowCookies</CODE> servlet</A>.\n" + "<P>\n"
                + "Three of the cookies are associated only with the\n"
                + "current session, while three are persistent.\n"
                + "Quit the browser, restart, and return to the\n"
                + "<CODE>ShowCookies</CODE> servlet to verify that\n"
                + "the three long-lived ones persist across sessions.\n"
                + "</BODY></HTML>");





    }
}
