/**
 * Copyright 2014-2016 www.fangdd.com All Rights Reserved.
 * Author: Tang Yuqian <tangyuqian-sz@fangdd.com>
 * Date: 2018/7/9
 */
package com.bjsxt.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class SessionInfoServlet extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Returns the current session associated with this request, or if rhe request does not have a session, creates one.
        //
        HttpSession mySession = request.getSession(true);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Session Info Servlet";
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Session Info Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>Session Infomation</h3>");

        // Returns true if the client does not yet know about the session or if the client chooses not to join the session.
        out.println("New Session:" + mySession.isNew() + "<br>");
        // Returns a string containing the unique identifier assigned to this session.
        out.println("Session Id:" + mySession.getId() + "<br>");
        // Returns the time when this session was created, measured in milliseconds since midnight January 1, 1970 GMT.
        out.println("Session Create Time:" + new Date(mySession.getCreationTime()) + "<br>");
        // session会有个过期时间
        out.println("Session Last Access Time:" + new Date(mySession.getLastAccessedTime()) + "<br>");

        out.println("<h3>Request Infomation</h3>");
        // Returns the session ID specified by the client.
        // 第一次访问request中没有sessionId,只有在之后的访问中通过cookie或重写的url从客户端拿到sessionId
        // TODO:cookie中或response.encodeURL是怎样得到sessionId的？是在request.getSession(true)里设置的吗，要看源码
        out.println("Session Id From Request:" + request.getRequestedSessionId() + "<br>");
        // Checks whether the requested session ID came in as a cookie.
        out.println("Session Id Via Cookie:" + request.isRequestedSessionIdFromCookie() + "<br>");
        // Checks whether the requested session ID came in as part of the request URL.
        out.println("Session Id Via URL:" + request.isRequestedSessionIdFromURL() + "<br>");
        // Checks whether the requested session ID is still valid.
        // 第一次都没有sessionId,肯定是无效的
        out.println("Valid Session Id:" + request.isRequestedSessionIdValid() + "<br>");

        out.println("<a href=" + response.encodeURL("SessionInfoServlet") + ">refresh</a>");
        out.println("</body></html>");
        out.close();



    }
}
