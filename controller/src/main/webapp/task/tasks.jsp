<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Список курсов</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
</head>
<body>
<%@include file="../menu.jsp" %>

<table>
    <caption>Список задач</caption>
    <tr>
        <th>Id</th>
        <th>Название</th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
            <c:forEach items="${allTasks}" var="task">
        <tr>
            <td><c:out value="${task.getId()}"/></td>
            <td><c:out value="${task.getTitle()}"/></td>
            <td><a href="task/updateTask.jsp?update_id=${task.getId()}&name=${task.getTitle()}">Изменить</a></td>
            <td><a href="task/newTask.jsp?create_id=${task.getId()}&name=${task.getTitle()}">Добавить</a></td>
            <td><a href="task/deleteTask.jsp?delete_id=${task.getId()}">Удалить</a></td>
        </tr>
        </c:forEach>

</table>
<%@include file="../footer.jsp" %>
</body>
</html>