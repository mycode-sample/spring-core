package com.sheepfly.springcore.webapp.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ShopServletService extends HttpServlet {
    public void doService(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String msg = request.getParameter("msg");
        PrintWriter writer = response.getWriter();
        if (msg == null) {
            writer.write("error: 空指针");
        } else if (msg.equals("input")) {
            new InputServiceImpl().doService(msg);
            writer.write("input");
        } else if (msg.equals("output")) {
            new OutputServiceImpl().doService(msg);
            writer.write("output");
        } else {
            writer.write("unknown");
            System.out.println("error");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doService(req, resp);
    }
}
