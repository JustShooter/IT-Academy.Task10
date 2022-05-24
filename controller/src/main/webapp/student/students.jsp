<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Список студентов</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
</head>
<body>
<%@include file="/menu.jsp" %>

<table>
    <caption>Список студентов</caption>
    <tr>
        <th>Id</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Список курсов</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="${allStudents}" var="student">
        <tr>
            <td><c:out value="${student.getId()}"/></td>
            <td><c:out value="${student.getName()}"/></td>
            <td><c:out value="${student.getSurname()}"/></td>
            <td><a href="students?method=coursesOfStudent&student_id=${student.getId()}">Курсы</a></td>
            <form name="update" method="post" action="students">
                <td>
                    <a href="${pageContext.request.contextPath}/student/updateStudent.jsp?create_id=${student.getId()}&name=${student.getName()}&surname=${student.getSurname()}&type=update">Изменить</a>
                </td>
            </form>
            <form name="delete" method="post" action="students">
            <td><a href="${pageContext.request.contextPath}/student/students.jsp?delete_id=${student.getId()}&type=delete">Удалить</a>
            </td>
            </form>
        </tr>
    </c:forEach>

</table>
<%@include file="/footer.jsp" %>
</body>
</html>