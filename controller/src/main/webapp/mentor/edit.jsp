<%--
  Created by IntelliJ IDEA.
  User: JustShooter
  Date: 18.05.2022
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html xml:lang="ru">
<head>
    <title>Edit mentor</title>
</head>
<body>
<form method="post" action="../viewAllMentors" onsubmit="return validate();">
    <table>
        <tr>
            <td>Имя</td>
            <td><input type="text" name="txt_name" id="name" value="${param.get("name")}"></td>
        </tr>
        <tr>
            <td>Фамилия</td>
            <td><input type="text" name="txt_surname" id="surname" value="${param.get("surname")}"></td>
        </tr>
        <tr>
            <td><input type="submit" name="btn_edit" value="update"></td>
        </tr>
        <input type="hidden" name="hidden_id" value="${param.get("edit_id")}">
    </table>
    <div style="text-align: center;">
        <h3 style="color: red;">
            <c:if test="${UpdateErrorMsg != null}">
                <c:out value="${UpdateErrorMsg}"/>
            </c:if>
        </h3>
        <h1><a href="../viewAllMentors">Назад</a></h1>
    </div>
</form>
</body>
</html>
