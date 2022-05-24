<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Обновить/Создать студента</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
</head>
<body>
<%@include file="/menu.jsp" %>
<% if (Objects.equals(request.getParameter("type"), "update")) { %>
<form class="transparent" method="get" action="/studentUpdate">
    <div class="form-inner">
        <h3>Обновить/Создать студента
            <%=request.getParameter("name")%> <%=request.getParameter("surname")%>
        </h3>
        <p class="name">Введите имя</p>
        <input type="text" name="nameString" id="name" value="${request.getParameter("nameString")}">
        <p class="name">Введите фамилию</p>
        <input type="text" name="surnameString" id="surname" value="${request.getParameter("surnameString")}">
        <p><input type="hidden" name="studentId" value="${request.getParameter("studentId")}"></p>

        <input type="submit" name="type" value="update">

    </div>
</form>
<% }%>
<%@include file="/footer.jsp" %>
</body>
</html>