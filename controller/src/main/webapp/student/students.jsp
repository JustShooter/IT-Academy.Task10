<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Список студентов</title>

    <link rel="stylesheet" href="css/table.css">
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
            <c:forEach items="${allStudents}" var="mentor">
        <tr>
            <td><c:out value="${mentor.getId()}"/></td>
            <td><c:out value="${mentor.getName()}"/></td>
            <td><c:out value="${mentor.getSurname()}"/></td>
            <td><a href="student/updateStudent.jsp?update_id=${mentor.getId()}&name=${mentor.getName()}&surname=${mentor.getSurname()}">Изменить</a></td>
            <td><a href="student/newStudent.jsp?create_id=${mentor.getId()}&name=${mentor.getName()}&surname=${mentor.getSurname()}">Добавить</a></td>
            <td><a href="student/deleteStudent.jsp?delete_id=${mentor.getId()}">Удалить</a></td>
        </tr>
        </c:forEach>

</table>
<%@include file="../footer.jsp" %>
</body>
</html>