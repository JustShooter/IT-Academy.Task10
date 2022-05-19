<%--
  Created by IntelliJ IDEA.
  User: JustShooter
  Date: 16.05.2022
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html xml:lang="ru">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="../images/stylesheet.css">
    <title>View mentor list</title>
</head>
<body>
<h1>Получение данных из базы данных</h1>
<table style="width: 60%; border-collapse: collapse;" border="2">
    <tr>
        <th>Id</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Курсы</th>
        <th>Изменить</th>
        <th>Удалить</th>
    </tr>
    <c:forEach items="${mentorList}" var="mentor">
        <tr>
            <td><c:out value="${mentor.getId()}"/></td>
            <td><c:out value="${mentor.getName()}"/></td>
            <td><c:out value="${mentor.getSurname()}"/></td>
            <td><a href="viewAllMentors?method=viewcourse&mentor_id=${mentor.getId()}">Курсы</a> </td> <%-- Может тут вывести таблицу курсов? Будет ли красиво? --%>
            <td><a href="mentor/edit.jsp?edit_id=${mentor.getId()}&name=${mentor.getName()}&surname=${mentor.getSurname()}">Изменить</a></td>
            <td><a href="viewAllMentors?method=delete&delete_id=${mentor.getId()}">Удалить</a></td>
        </tr>
    </c:forEach>
</table>
</body>
<form action="index.jsp">
    <input type="submit" value="На главную!">
</form>
</html>
