<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<br>
<br>
<table>
    <tr>
        <th>И Дэ</th>
        <th>Титле</th>
        <th>Менторе</th>
    </tr>
    <c:forEach var="student" items="${courseSet}">
        <tr>
            <td>${student.id}</td>
            <td>${student.title}</td>
            <td>${student.mentor}</td>
            <%--<td>
                <form action="editStudent">
                    <input type="hidden" name="id" value="${.id}">
                    <button type="submit">Edit</button>
                </form>
            </td>
            <td>
                <form action="deleteProduct" method="get">
                    <input type="hidden" name="id" value="${product.id}">
                    <button type="submit" value="${product.id}">Delete</button>
                </form>
            </td>--%>
        </tr>
    </c:forEach>
    <tr>
        <td>
            <a href="AddStudent.jsp">Add a student</a>
        </td>
    </tr>
</table>
<br>
<a href="index.jsp">Go to the main page</a>
</body>
</html>