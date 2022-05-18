<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Список студентов</title>

    <link rel="stylesheet" href="../css/table.css">
</head>
<body>
<%@include file="../menu.jsp" %>

<table>
    <caption>Список студентов</caption>
    <tr>
        <th>Id</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
            <c:forEach items="${allStudents}" var="student">
        <tr>
            <td><c:out value="${student.getId()}"/></td>
            <td><c:out value="${student.getName()}"/></td>
            <td><c:out value="${student.getSurname()}"/></td>
            <td><a href="#">Изменить</a></td>
            <td><a href="newstudent.jsp">Добавить</a></td>
            <td><a href="#">Удалить</a></td>
        </tr>
        </c:forEach>

</table>
<%@include file="../footer.jsp" %>
</body>
</html>