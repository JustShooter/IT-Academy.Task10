<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html xml:lang="ru">
<head>
    <meta charset="UTF-8"/>
    <title>Список оценок</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
</head>
<body onpageshow="success()">
<%@include file="../menu.jsp" %>
<table>
    <caption>Список курсов</caption>
    <tr>
        <th>Id</th>
        <th>Задание</th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="${allTask}" var="task">
        <tr>
            <td><c:out value="${task.getId()}"/></td>
            <td><c:out value="${task.getTitle()}"/></td>
            <td><a href="${pageContext.request.contextPath}/report/newreport.jsp?student_name=${student_name}&student_surname=${student_surname}&task_title=${task.getTitle()}&course_title=${course_title}">Оценить задание</a></td>
        </tr>
    </c:forEach>

</table>
<%@include file="../footer.jsp" %>
</body>
</html>