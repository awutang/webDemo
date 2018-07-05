/**
 * Copyright 2014-2016 www.fangdd.com All Rights Reserved.
 * Author: Tang Yuqian <tangyuqian-sz@fangdd.com>
 * Date: 2018/7/5
 */
package com.bjsxt.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ThreeParams extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html"); // 设置返回内容类型
        PrintWriter printWriter = response.getWriter();
        printWriter.println(request.getParameter("param1"));
        printWriter.println("<br/>");
        printWriter.println(request.getParameter("param2"));
        printWriter.println("<br/>");
        printWriter.println(request.getParameter("param3"));
        printWriter.println("<br/>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("this is doPost");
        doGet(request, response);
    }
}
