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

public class ShowCookies extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=gb2312");
        PrintWriter printWriter = response.getWriter();
        String title = "Active Cookies";
        printWriter.println("<html><head><title>获取客户端Cookie</title></head>"
                + "<BODY BGCOLOR=\"#FDF5E6\">\n"
                + "<HI AKIGN=\"CENTER\">" + title + "</HI>\n"
                + "<TABLE BORDER=1 ALIGN=\"CENTER\">\n"
                + "<TR BGCOLOR=\"#FFADO0\">\n"
                +"    <TH>Cookie Name\n"
                +"    <TH>Cookie Value") ;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            Cookie cookie;
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                printWriter.println("<TR>\n" +
                                    "   <TD>" +cookie.getName()+ "</TD>\n" +
                                    "   <TD>" +cookie.getValue()+ "</TD></TR>\n");

            }
            printWriter.println("</TABLE></BODY></HTML>");
        }
    }
}
