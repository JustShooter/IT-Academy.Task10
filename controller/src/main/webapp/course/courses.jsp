<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Список курсов</title>

    <link rel="stylesheet" href="css/table.css">
</head>
<body>
<%@include file="../menu.jsp" %>

<table>
    <caption>Список курсов</caption>
    <tr>
        <th>Id</th>
        <th>Название</th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
            <c:forEach items="${allCourses}" var="course">
        <tr>
            <td><c:out value="${course.getId()}"/></td>
            <td><c:out value="${course.getTitle()}"/></td>
            <td><a href="course/updateCourse.jsp?update_id=${course.getId()}&name=${course.getTitle()}">Изменить</a></td>
            <td><a href="course/newCourse.jsp?create_id=${course.getId()}&name=${course.getTitle()}">Добавить</a></td>
            <td><a href="course/deleteCourse.jsp?delete_id=${course.getId()}">Удалить</a></td>
        </tr>
        </c:forEach>

</table>
<%@include file="../footer.jsp" %>
</body>
</html>