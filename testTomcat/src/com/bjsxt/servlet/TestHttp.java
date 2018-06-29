/**
 * Copyright 2014-2016 www.fangdd.com All Rights Reserved.
 * Author: Tang Yuqian <tangyuqian-sz@fangdd.com>
 * Date: 2018/5/24
 */
package com.bjsxt.servlet;

import java.io.*;
import java.net.Socket;

public class TestHttp {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        pw.println("Get /testTomcat/ HTTP/1.1");
        pw.println("Host: localhost");
        pw.println("Content-Type: test/html");
        pw.println();
        pw.flush();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String str = "";
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }
        br.close();
        pw.close();
        socket.close();
    }
}
