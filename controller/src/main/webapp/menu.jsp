<%@page contentType="text/html; charset=UTF-8" language="java" %>
<ul>
    <li><a href="${pageContext.request.contextPath}/index.jsp">Главная</a></li>
    <li><a>Студенты</a>
        <ul>
            <li><a href="${pageContext.request.contextPath}/students">Список студентов</a></li>
            <li><a href="${pageContext.request.contextPath}/student/newStudent.jsp">Добавить студента</a></li>
        </ul>
    <li><a>Курсы</a>
        <ul>
            <li><a href="${pageContext.request.contextPath}/courses">Список курсов</a></li>
            <li><a href="${pageContext.request.contextPath}/course/courseData.jsp?method=add">Добавить курс</a></li>
        </ul>
    <li><a>Преподаватели</a>
        <ul>
            <li><a href="${pageContext.request.contextPath}/mentors">Список преподавателей</a></li>
            <li><a href="${pageContext.request.contextPath}/mentor/mentorData.jsp?method=add">Добавить преподавателя</a></li>
        </ul>
    <li><a>Задачи</a>
        <ul>
            <li><a href="${pageContext.request.contextPath}/tasks">Список задач</a></li>
            <li><a href="${pageContext.request.contextPath}/task/newtask.jsp">Создать задачу</a></li>
        </ul>
    </li>
    <li><a>Успеваемость</a>
        <ul>
            <li><a href="${pageContext.request.contextPath}/reports">Журнал оценок</a></li>
            <li><a href="${pageContext.request.contextPath}/report/newreport.jsp">Оценить студента</a></li>
        </ul>
    </li>
</ul>
