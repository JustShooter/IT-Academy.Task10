<%@ page import="by.it.academy.task10.entity.MarkReport" %>
<%@ page import="java.util.Set" %><%--
  Created by IntelliJ IDEA.
  User: -LENOVO-
  Date: 18.05.2022
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Все отчеты</title>
</head>
<body>
<h2>все Отчеты</h2>
<table>
<% Set<MarkReport> markReportSet = (Set<MarkReport>) request.getAttribute("Set");
   for (MarkReport markReport : markReportSet) {
%>
    <tr>
        <%= markReport.getMark()%> </td>
        <%= markReport.getMentor()%>  </td>
        <%= markReport.getFeedback()%> </td>
        <%= markReport.getTask()%> </td>
    </tr>
        <%
    }
%>
</table>
    </body>
</html>
