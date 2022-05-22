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
        <th>Оценка</th>
        <th>Комментарий</th>
        <th>Имя студента</th>
        <th>Фамилия студента</th>
        <th>Задача</th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="${allReports}" var="report">
        <tr>
            <td><c:out value="${report.getId()}"/></td>
            <td><c:out value="${report.getMark()}"/></td>
            <td><c:out value="${report.getFeedback()}"/></td>
            <td><c:out value="${report.getStudent().getName()}"/></td>
            <td><c:out value="${report.getStudent().getSurname()}"/></td>
            <td><c:out value="${report.getTask().getTitle()}"/></td>
            <td><a href="${pageContext.request.contextPath}/report/refactorReport.jsp?value=change&id=${report.getId()}&name=${report.getStudent().getName()}&surname=${report.getStudent().getSurname()}
            &feedback=${report.getFeedback()}&mark=${report.getMark()}&task=${report.getTask().getTitle()}">Изменить</a>
            </td>
            <td><a href="#">Добавить</a></td>
            <td><a href="#">Удалить</a></td>
        </tr>
    </c:forEach>

</table>
<%@include file="../footer.jsp" %>
</body>
</html>