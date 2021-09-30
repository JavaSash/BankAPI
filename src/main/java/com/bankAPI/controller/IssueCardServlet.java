package com.bankAPI.controller;

import com.bankAPI.dao.DaoCardImpl;
import com.bankAPI.model.BankAccount;
import com.bankAPI.model.BankCard;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "IssueCardServlet", value = "/IssueCardServlet")
public class IssueCardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BankAccount account = new BankAccount();
        BankCard card = account.issueCard();
        DaoCardImpl daoCard = new DaoCardImpl();
        daoCard.addCard(card);
        response.setContentType("application/json");
        PrintWriter printWriter = response.getWriter();
        printWriter.println(card);
        printWriter.flush();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
