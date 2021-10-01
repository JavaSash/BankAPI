package com.bankAPI.controller;

import com.bankAPI.service.AccountService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Stream;

@WebServlet(name = "DepositServlet", value = "/Deposit")
public class DepositServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int amount = 100;
        request.setAttribute("amount", amount);

        Integer summ = (Integer) request.getAttribute("amount");

        System.out.println(summ);
        AccountService.deposit(summ);

        response.setContentType("application/json");
        PrintWriter printWriter = response.getWriter();
        printWriter.println(AccountService.getBalance());
        printWriter.flush();
    }
}
