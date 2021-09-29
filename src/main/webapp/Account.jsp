<%@ page import="com.bankAPI.model.BankAccount" %><%--
  Created by IntelliJ IDEA.
  User: a19556394
  Date: 29.09.2021
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account</title>
</head>
<body>
<%@ page import="com.bankAPI.model.BankAccount" %>
<%@ page import="com.bankAPI.util.ConnectionUtil" %>

<% BankAccount account = (BankAccount) session.getAttribute("account"); %>

<%= account.getAccountNumber()%>
<%= account.getOwnersFullName()%>
</body>
</html>
