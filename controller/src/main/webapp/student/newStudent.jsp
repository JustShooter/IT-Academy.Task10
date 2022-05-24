<%@page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Создать студента</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
</head>
<body>
<%@include file="/menu.jsp" %>
<form class="transparent">
    <div class="form-inner">
        <h3>Добавить студента</h3>
        <p class="name">Введите имя</p><input type="text">
        <p class="name">Введите фамилию</p><input type="text">

        <input type="submit" value="Добавить">
    </div>
</form>
<%@include file="/footer.jsp" %>
</body>
</html>