<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Список</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
</head>
<body>
<%@include file="../menu.jsp" %>
<form class="transparent" method="post" action="${pageContext.request.contextPath}/reports">
    <div class="form-inner">
        <h3>Журнал Студента</h3>
        <p class="name">Имя</p><input type="text" name="name">
        <p class="name">Фамилия</p><input type="text" name="fio">

        <input type="submit" value="Найти">
    </div>
</form>
</body>
</html>
