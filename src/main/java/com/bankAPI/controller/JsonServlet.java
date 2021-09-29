package com.bankAPI.controller;

import com.bankAPI.model.BankAccount;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/json")
public class JsonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        final BankAccount account = new BankAccount("Valera");

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(account);
        out.flush();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
