<%@page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Academy</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<%@include file="../menu.jsp" %>
<form class="transparent">
    <div class="form-inner">
        <h3>Оценить студента</h3>
        <p class="name">Введите оценку</p><input type="text">
        <p class="name">Комментарий</p><input type="text">
        <p class="name">Имя студента</p><input type="text">
        <p class="name">Фамилия студента</p><input type="text">
        <p class="name">Задача</p><input type="text">

        <input type="submit" value="Добавить">
    </div>
</form>
<%@include file="../footer.jsp" %>
</body>
</html>