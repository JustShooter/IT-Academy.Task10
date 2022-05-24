<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html xml:lang="ru">
<head>
    <meta charset="UTF-8"/>
    <title>View mentor list</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
</head>
<body onpageshow="success()">
<%@include file="/menu.jsp"%>
<script type="text/javascript">
    function success() {
        var var1 = "${UpdateSuccessMsg}";
        if (var1 != "") {
            document.getElementById("myModal").style.display = "block";
        }
        document.getElementsByClassName("close")[0].onclick = function () {
            document.getElementById("myModal").style.display = "none";
        }
    }
</script>
<div id="myModal" class="modal">
    <div class="modal-content">
        <span class="close">&times;</span>
        <h1 style="padding-left: 20px"><c:out value="${UpdateSuccessMsg}"/></h1>
    </div>
</div>
<table>
    <caption>Список преподавателей</caption>
    <tr>
        <th>Id</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="${allMentors}" var="mentor">
        <tr>
            <td><c:out value="${mentor.getId()}"/></td>
            <td><c:out value="${mentor.getName()}"/></td>
            <td><c:out value="${mentor.getSurname()}"/></td>
            <td><a href="${pageContext.request.contextPath}/mentors?method=viewcourse&mentor_id=${mentor.getId()}">Курсы</a></td>
            <td>
                <a href="${pageContext.request.contextPath}/mentor/mentorData.jsp?method=edit&edit_id=${mentor.getId()}&name=${mentor.getName()}&surname=${mentor.getSurname()}">Изменить</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/mentors?method=delete&delete_id=${mentor.getId()}" onclick="return confirm('Вы уверены?')">Удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="${pageContext.request.contextPath}/mentor/mentorData.jsp?method=add"
   style="text-align: center; border-radius: 20px; width: 60%; margin: auto; margin-top: inherit;">Добавить</a>
<%@include file="/footer.jsp" %>
</body>
</html>