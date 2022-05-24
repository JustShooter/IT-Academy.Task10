<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html xml:lang="ru">
<head>
    <meta charset="UTF-8"/>
    <title>Academy</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
</head>
<body>
<%@include file="/menu.jsp" %>
<form class="transparent">
    <div class="form-inner">
        <h3>Создать курс</h3>
        <p class="name">Введите название курса</p><input type="text">
        <input type="submit" value="Добавить">
    </div>
</form>
<%@include file="/footer.jsp" %>
</body>
</html>