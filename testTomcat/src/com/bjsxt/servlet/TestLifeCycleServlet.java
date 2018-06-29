/**
 * Copyright 2014-2016 www.fangdd.com All Rights Reserved.
 * Author: Tang Yuqian <tangyuqian-sz@fangdd.com>
 * Date: 2018/5/24
 */
package com.bjsxt.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestLifeCycleServlet extends HttpServlet{
    // servlet（TestLifeCycleServlet）只会new一个（在一个server中）（j2ee的规范）
    public TestLifeCycleServlet() {
        System.out.println("constructor");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }

    @Override
    // 只在第一次初始化的时候执行
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init");
    }
}
