<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Список преподавателей</title>

    <link rel="stylesheet" href="css/table.css">
</head>
<body>
<%@include file="../menu.jsp" %>

<table>
    <caption>Список преподавателей</caption>
    <tr>
        <th>Id</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
            <c:forEach items="${allMentors}" var="mentor">
        <tr>
            <td><c:out value="${mentor.getId()}"/></td>
            <td><c:out value="${mentor.getName()}"/></td>
            <td><c:out value="${mentor.getSurname()}"/></td>
            <td><a href="mentor/updateMentor.jsp?update_id=${mentor.getId()}&name=${mentor.getName()}&surname=${mentor.getSurname()}">Изменить</a></td>
            <td><a href="mentor/newmentor.jsp?create_id=${mentor.getId()}&name=${mentor.getName()}&surname=${mentor.getSurname()}">Добавить</a></td>
            <td><a href="mentor/deleteMentor.jsp?delete_id=${mentor.getId()}">Удалить</a></td>
        </tr>
        </c:forEach>

</table>
<%@include file="../footer.jsp" %>
</body>
</html>