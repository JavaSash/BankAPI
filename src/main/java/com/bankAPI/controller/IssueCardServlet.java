package com.bankAPI.controller;

import com.bankAPI.model.BankCard;
import com.bankAPI.service.CardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "IssueCardServlet", value = "/IssueCard")
public class IssueCardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BankCard card = CardService.issueCard();

        response.setContentType("application/json");
        PrintWriter printWriter = response.getWriter();
        printWriter.println(card);
        printWriter.flush();
    }
}
