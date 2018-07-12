/**
 * Copyright 2014-2016 www.fangdd.com All Rights Reserved.
 * Author: Tang Yuqian <tangyuqian-sz@fangdd.com>
 * Date: 2018/7/11
 */
package com.bjsxt.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Application测试
 * 用于保存整个web应用的生命周期内都可以访问的数据 有效期在整个application内
 * 可供多个不同窗口(浏览器)访问，可作为某一页面被总共访问次数的计数器（比如网站首页的访问量）
 *
 */
public class TestServletContext extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("gb2312");

        PrintWriter out = response.getWriter();
        // Returns a reference to the ServletContext in which this servlet is running.
        ServletContext application = this.getServletContext();
        // 从当前application中读取属性accessCount的值
        Integer accessCount = (Integer) application.getAttribute("accessCount");
        if (accessCount == null) {
            accessCount = new Integer(0);
        } else {
            accessCount = new Integer(accessCount.intValue() + 1);
        }

        application.setAttribute("accessCount", accessCount);
        out.println("<html><head><title>ServletContext测试</title></head><br>"
                + "<body><td>" + accessCount +"</td>\n"
                + "</body></html>");
    }
}
