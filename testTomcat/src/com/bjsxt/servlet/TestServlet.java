package com.bjsxt.servlet;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
// @WebServlet("/TestServlet")
public class TestServlet extends javax.servlet.http.HttpServlet {

    private String message;

    @Override
    public void init() {
        message = "Hello World, This message is from Servlet!";
    }


    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("<h3>" + message + "</h3>");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html"); // 设置响应内容类型
        PrintWriter writer = response.getWriter();
        writer.println("<h3>" + message + "</h3>");
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
