<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Обновить запись студента</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/form.css">
</head>
<body>
<%@include file="../menu.jsp" %>
<form class="transparent" method="post" action="/students">
    <div class="form-inner">
        <h3>Изменить данные студента</h3>
        <p class="name">Введите имя</p>
        <input type="text" name="nameString" id="name" value="${param.get("name")}">
        <p class="name">Введите фамилию</p>
        <input type="text" name="surnameString" id="surname" value="${param.get("surname")}">
        <p><input type="hidden" name="hidden_id" id="update_id" value="${param.get("update_id")}"></p>
        <input type="submit" name="btn_edit" value="Изменить">


        <c:if test="${UpdateErrorMsg != null}">
            <c:out value="${UpdateErrorMsg}"/>
        </c:if>
    </div>
</form>
<%@include file="../footer.jsp" %>
</body>
</html>