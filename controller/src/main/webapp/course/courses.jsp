<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html xml:lang="ru">
<head>
    <meta charset="UTF-8"/>
    <title>Список курсов</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
</head>
<body>
<%@include file="../menu.jsp" %>

<table>
    <caption>Список курсов <c:if test="${mentorName != null}">${mentorName}</c:if></caption>
    <tr>
        <th>Id</th>
        <th>Название</th>
        <c:if test="${mentorName == null}"><th>Преподаватель</th></c:if>
        <th></th>
        <th></th>
    </tr>
            <c:forEach items="${allCourses}" var="course">
        <tr>
            <td><c:out value="${course.getId()}"/></td>
            <td><c:out value="${course.getTitle()}"/></td>
            <c:if test="${mentorName == null}"><td>${mentorsMap.get(course.getMentorId())}</td></c:if>
            <td><a href="course/updateCourse.jsp?update_id=${course.getId()}&name=${course.getTitle()}">Изменить</a></td>
            <td><a href="course/deleteCourse.jsp?delete_id=${course.getId()}">Удалить</a></td>
        </tr>
        </c:forEach>

</table>
<a href="${pageContext.request.contextPath}/mentor/courseData.jsp?method=add"
   style="text-align: center; border-radius: 20px; width: 60%; margin: auto; margin-top: inherit;">Добавить</a>
<%@include file="../footer.jsp" %>
</body>
</html>