<%--
  Created by IntelliJ IDEA.
  User: -LENOVO-
  Date: 22.05.2022
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html xml:lang="ru">
<head>
    <meta charset="UTF-8"/>
    <title>Изменение Отчета</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
</head>
<body>
<%@include file="../menu.jsp" %>
<form method="post" action="${pageContext.request.contextPath}/reportChange">
    <table>
        <tr>
            <td>Имя Студента</td>
            <td><output>"${param.get("name")}"</output></td>
        </tr>
        <tr>
            <td>Фамилия Студента</td>
            <td><output>"${param.get("surname")}"</output></td>
        </tr>
        <tr>
            <td>Задание</td>
            <td><output>"${param.get("task")}"</output></td>
        </tr>
        <tr>
            <td>Комментарий</td>
            <td><input type="text" name="feedback" value="${param.get("feedback")}"></td>
        </tr>
        <tr>
            <td>Оценка</td>
            <td><input type="number" name="mark" value="${param.get("mark")}"></td>
        </tr>
        <tr>
            <td><input type="submit" name="change" value="update"></td>
        </tr>
        <input type="hidden" name="id" value="${param.get("id")}">
        <input type="hidden" name="name" value="${param.get("name")}">
        <input type="hidden" name="fio" value="${param.get("surname")}">
    </table>
</form>
<%@include file="../footer.jsp" %>
</body>
</html>
