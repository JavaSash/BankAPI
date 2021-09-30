<%@ page import="com.bankAPI.service.ConfigDb" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bank API</title>
</head>
<body>
<h1><%= "Bank API" %>
</h1>
<br/>
<% ConfigDb.setDefaultConfigDb();%>
<a href="IssueCard">Issue card</a>

<br>
<a href="GetAllCards">Get all cards</a>
<br>
<a href="Deposit">Deposit</a>
<br>
<a href="GetBalance">Get balance</a>
</body>
</html>
