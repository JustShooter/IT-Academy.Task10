<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html xml:lang="ru">
<head>
    <meta charset="UTF-8"/>
    <title>Academy</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
</head>
<body>
<%@include file="../menu.jsp" %>
<form class="transparent" method="post" action="../mentors">
    <div class="form-inner">
        <h3><c:choose>
            <c:when test="${param.method.equals('add')}">Добавить преподавателя<input type="hidden" name="method" value="add"/></c:when>
            <c:when test="${param.method.equals('edit')}">Изменить преподавателя<input type="hidden" name="method" value="edit"/></c:when>
        </c:choose></h3>
        <p class="name">Имя</p><input type="text" name="txt_name" id="name" value="${param.get("name")}">
        <p class="name">Фамилия</p><input type="text" name="txt_surname" id="surname" value="${param.get("surname")}">

        <input type="submit" name="btn_edit" value="Подтвердить">
        <input type="hidden" name="hidden_id" value="${param.get("edit_id")}">
    </div>
    <div style="text-align: center;">
        <h1 style="color: red;">
            <c:if test="${UpdateErrorMsg != null}">
                <c:out value="${UpdateErrorMsg}"/>
            </c:if>
        </h1>
    </div>
    <h3>
        <a href="${pageContext.request.contextPath}/mentors"
           class="form-inner"
           style="text-align: center; border-radius: 20px;">
            Назад
        </a>
    </h3>
</form>
<%@include file="../footer.jsp" %>
</body>
</html>