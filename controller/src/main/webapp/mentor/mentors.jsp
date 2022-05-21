<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html xml:lang="ru">
<head>
    <meta charset="UTF-8"/>
    <title>View mentor list</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<%@include file="/menu.jsp" %>
<div id="B"><c:if test="${UpdateSuccessMsg != null}"><c:out value="${UpdateSuccessMsg}"/></c:if></div>
<table>
    <caption>Список преподавателей</caption>
    <tr>
        <th>Id</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Курсы</th>
        <th>Изменить</th>
        <th>Удалить</th>
    </tr>
            <c:forEach items="${allMentors}" var="mentor">
        <tr>
            <td><c:out value="${mentor.getId()}"/></td>
            <td><c:out value="${mentor.getName()}"/></td>
            <td><c:out value="${mentor.getSurname()}"/></td>
            <td><a href="mentors?method=viewcourse&mentor_id=${mentor.getId()}">Курсы</a> </td>
            <td><a href="${pageContext.request.contextPath}/mentor/edit.jsp?edit_id=${mentor.getId()}&name=${mentor.getName()}&surname=${mentor.getSurname()}">Изменить</a></td>
            <td><a href="mentor/deleteMentor.jsp?delete_id=${mentor.getId()}">Удалить</a></td>
        </tr>
        </c:forEach>

</table>
<%@include file="/footer.jsp" %>
</body>
</html>