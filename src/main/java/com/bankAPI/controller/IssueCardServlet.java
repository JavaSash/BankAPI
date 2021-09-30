package com.bankAPI.controller;

import com.bankAPI.dao.DaoCardImpl;
import com.bankAPI.dto.ArrayOfCardsDto;
import com.bankAPI.dto.CardDto;
import com.bankAPI.model.BankAccount;
import com.bankAPI.model.BankCard;
import com.bankAPI.serializer.JsonStreamSerializer;
import com.bankAPI.service.CardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "IssueCardServlet", value = "/IssueCard")
public class IssueCardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        StringBuilder stringBuilder = new StringBuilder();
        //BufferedReader reader = request.getReader();
        //String line;
        //while((line = reader.readLine()) != null ) {
        //    stringBuilder.append(line);
        //}
//        try {
//            JSONArray json = HTTP.toJSONObject(stringBuilder.toString());
//
//        } catch (Exception e ) {
//            e.printStackTrace();
//        }

//        JsonStreamSerializer serializer = new JsonStreamSerializer();
//        CardDto card = serializer.readArrayCardsDto(request.getInputStream());
        //ObjectMapper objectMapper = new ObjectMapper();
        //ArrayOfCardsDto array = objectMapper.readValue(stringBuilder.toString(), ArrayOfCardsDto.class);


        BankCard card = CardService.issueCard();

        response.setContentType("application/json");
        PrintWriter printWriter = response.getWriter();
        //ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
        //String json = writer.writeValueAsString(array.getCards().get(0));
        printWriter.println(card);
        printWriter.flush();
    }
}
