package by.it.academy.task10.servlet;

import by.it.academy.task10.dto.CourseDto;
import by.it.academy.task10.dto.TaskDto;
import by.it.academy.task10.services.implementations.StudentServiceImpl;
import by.it.academy.task10.services.interfaces.StudentService;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "reportCreateServlet", value = "/reportCreate")
public class ReportCreateServlet extends HttpServlet {

    private final StudentService studentService = new StudentServiceImpl();

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String course_title = getParam(req, "course_title");
        List<TaskDto> tasksOfCourse = studentService.findTasksOfCourseMy(course_title);
        req.setAttribute("student_surname", getParam(req, "student_surname"));
        req.setAttribute("student_name", getParam(req, "student_name"));
        req.setAttribute("course_title", getParam(req, "course_title"));
        req.setAttribute("allTask", tasksOfCourse);
        req.getRequestDispatcher("report/StudentTask.jsp").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String student_name = getParam(req, "name");
        String student_surname = getParam(req, "fio");
        List<CourseDto> coursesOfStudent = studentService.findCourseOfStudentMy(student_name, student_surname);
        req.setAttribute("allCourse", coursesOfStudent);
        req.setAttribute("student_name", student_name);
        req.setAttribute("student_surname", student_surname);
        req.getRequestDispatcher("report/studentCourses.jsp").forward(req, resp);
    }

    private String getParam(HttpServletRequest req, String nameField) {
        return Optional.ofNullable(req.getParameter(nameField))
                .filter(StringUtils::isNotBlank)
                .orElse(null);
    }
}
