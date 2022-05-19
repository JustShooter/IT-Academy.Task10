<%@page contentType="text/html; charset=UTF-8" language="java" %>
<style>

    body {
        background: #C0C0C0 url(images/back.jpg) no-repeat fixed;
        -moz-background-size: 100%;
        -webkit-background-size: 100%;
        -o-background-size: 100%;
        background-size: 100%;
        height: 100%;
        margin-left: 0px;
        margin-right: 0px;
    }

    ul {
        list-style: none;
        margin: 0;
        padding-left: 0;
        margin-top: 25px;
        background: #2F4F4F;
        height: 60px;
        z-index: 1000;
    }

    a {
        text-decoration: none;
        background: #2F4F4F;
        color: #fff;
        padding: 0px 15px;
        font-family: arial;
        line-height: 60px;
        display: block;
        border-right: 1px solid #2F4F4F;
        -moz-transition: all 0.3s 0.01s ease;
        -o-transition: all 0.3s 0.01s ease;
        -webkit-transition: all 0.3s 0.01s ease;
    }

    a:hover {
        background: #789c9b;
    }

    li {
        float: left;
        position: relative;
    }

    li > ul {
        position: absolute;
        top: 35px;
        display: none;
    }

    li:hover > ul {
        display: block;
        width: 250px;
    }

    li:hover > ul > li {
        float: none;
    }

</style>
<ul>
    <li><a href="index.jsp">Главная</a></li>
    <li><a href="#">Студенты</a>
        <ul>
            <li><a href="students">Список студентов</a></li>
            <li><a href="student/newStudent.jsp">Добавить студента</a></li>
        </ul>
    <li><a href="#">Курсы</a>
        <ul>
            <li><a href="courses">Список курсов</a></li>
            <li><a href="course/newcourse.jsp">Добавить курс</a></li>
        </ul>
    <li><a href="#">Преподаватели</a>
        <ul>
            <li><a href="mentors">Список преподавателей</a></li>
            <li><a href="mentor/newmentor.jsp">Добавить преподавателя</a></li>
        </ul>
    <li><a href="#">Задачи</a>
        <ul>
            <li><a href="tasks">Список задач</a></li>
            <li><a href="task/newtask.jsp">Создать задачу</a></li>
        </ul>
    </li>
    <li><a href="#">Успеваемость</a>
        <ul>
            <li><a href="reports">Журнал оценок</a></li>
            <li><a href="report/newreport.jsp">Оценить студента</a></li>
        </ul>
    </li>
</ul>
