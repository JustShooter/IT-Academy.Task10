<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Список оценок</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
</head>
<body>
<%@include file="../menu.jsp" %>
<h2>Отчет</h2>
<form name="test" method="post" action="${pageContext.request.contextPath}/reports">
    <table>
        <tr>
            <td>Имя</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Фамилия</td>
            <td><input type="text" name="fio"></td>
        </tr>
        <tr>
        <tr>
            <td><input type="submit" name="btn_edit" value="Найти"></td>
        </tr>
        </tr>
    </table>
</form>
</body>
</html>
