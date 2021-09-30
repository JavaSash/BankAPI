package com.bankAPI.controller;

import com.bankAPI.service.AccountService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetBalanceServlet", value = "/GetBalance")
public class GetBalanceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float balance = AccountService.getBalance();

        response.setContentType("application/json");
        PrintWriter printWriter = response.getWriter();
        printWriter.println(balance);
        printWriter.flush();
    }
}
