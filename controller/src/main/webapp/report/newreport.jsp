<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Academy</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
</head>
<body>
<%@include file="../menu.jsp" %>
<form class="transparent" method="get" action="${pageContext.request.contextPath}/reports">
    <div class="form-inner">
        <h3>Оценить студента</h3>
        <p class="name">Введите оценку</p><input type="text" name="mark">
        <p class="name">Комментарий</p><input type="text" name="feedback">

        <input type="submit" value="Добавить">
        <input type="hidden" name="student_name" value="${param.get("student_name")}">
        <input type="hidden" name="student_surname" value="${param.get("student_surname")}">
        <input type="hidden" name="course_title" value="${param.get("course_title")}">
        <input type="hidden" name="task_title" value="${param.get("task_title")}">
    </div>
</form>
<%@include file="../footer.jsp" %>
</body>
</html>