package com.bankAPI.controller;

import com.bankAPI.model.BankCard;
import com.bankAPI.service.AccountService;
import com.bankAPI.service.CardService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "getAllCardsServlet", value = "/getAllCards")
public class getAllCardsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BankCard> cards = CardService.getAllCards();

        response.setContentType("application/json");
        PrintWriter printWriter = response.getWriter();
        printWriter.println(cards);
        printWriter.flush();
    }
}
