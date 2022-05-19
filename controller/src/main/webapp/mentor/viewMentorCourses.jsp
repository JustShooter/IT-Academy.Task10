<%--
  Created by IntelliJ IDEA.
  User: JustShooter
  Date: 19.05.2022
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html xml:lang="ru">
<head>
    <title>View mentor Courses</title>
</head>
<body>
<h1>Курсы в которых преподаватель ${mentorName}</h1>
<table style="width: 60%; border-collapse: collapse;" border="2">
    <tr>
        <th>Id</th>
        <th>Название круса</th>
        <th>Преподаватель</th>
    </tr>
<c:forEach items="${courseListOfMentor}" var="course">
    <tr>
    <td><c:out value="${course.getId()}"/></td>
    <td><c:out value="${course.getTitle()}"/></td>
    <td><c:out value="${course.getMentorId()}"/></td>
    </tr>
</c:forEach>
</table>
</body>
<h1><a href="viewAllMentors">Назад</a></h1>
</html>
