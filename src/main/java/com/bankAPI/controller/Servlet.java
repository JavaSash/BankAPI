package com.bankAPI.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Bank API";
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

//        DaoAccountImpl daoAccount = new DaoAccountImpl();
//        daoAccount.createAccountTable();
//        BankAccount account = new BankAccount();
//        daoAccount.addAccount(account);
//        daoAccount.getAccountById(1);


//        Test test = (Test) session.getAttribute("test");
//        String userName = request.getParameter("name");
//
//        if (test == null) {
//            test = new Test();
//            test.setName(userName);
//        }
//
//        session.setAttribute("test", test);

//        getServletContext().getRequestDispatcher("/Test.jsp").forward(request, response);

        //Open session and get count (number of visits)

//        Integer count = (Integer) session.getAttribute("count");
//
//        if (count == null) {
//            session.setAttribute("count", 1);
//            count = 1;
//        } else {
//            session.setAttribute("count", count + 1);
//        }
//
//
//        PrintWriter printWriter = response.getWriter();
//        printWriter.println("<html><body>");
//        printWriter.println("<h1> Your count is " + count + " </h1>");
//        printWriter.println("</body></html>");
//redirect
        //response.sendRedirect("/Servlet");

        //forward only inside server
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
//        dispatcher.forward(request, response);
    }
}
