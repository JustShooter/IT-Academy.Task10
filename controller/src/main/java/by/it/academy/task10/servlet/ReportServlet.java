package by.it.academy.task10.servlet;

import by.it.academy.task10.dao.implementations.StudentDaoImpl;
import by.it.academy.task10.dao.interfaces.StudentDao;
import by.it.academy.task10.dto.MarkReportDto;
import by.it.academy.task10.entity.MarkReport;
import by.it.academy.task10.entity.User;
import by.it.academy.task10.services.implementations.AdminServiceImpl;
import by.it.academy.task10.services.implementations.MentorServiceImpl;
import by.it.academy.task10.services.implementations.StudentServiceImpl;
import by.it.academy.task10.services.interfaces.AdminService;
import by.it.academy.task10.services.interfaces.MentorService;
import by.it.academy.task10.services.interfaces.StudentService;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "reportServlet", value = "/reports")
public class ReportServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MentorService mentorService = new MentorServiceImpl();
        StudentService studentService = new StudentServiceImpl();
        String student_name = getParam(req, "student_name");
        String student_surname = getParam(req, "student_surname");
        String task_title = getParam(req, "task_title");
        String course_title = getParam(req, "course_title");
        Integer mark = Integer.parseInt(getParam(req, "mark"));
        String feedback = getParam(req, "feedback");
        List<MarkReportDto> reportsOfStudent = null;
        try {
            mentorService.rateAndFeedbackStudentTask(student_name, student_surname, task_title, course_title, mark, feedback);
            reportsOfStudent = studentService.findReportsOfStudent(student_name, student_surname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("allReports", reportsOfStudent);
        req.getRequestDispatcher("report/reports.jsp").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentService studentService = new StudentServiceImpl();
        String name = getParam(req, "name");
        String fio = getParam(req, "fio");
        List<MarkReportDto> reportsOfStudent = studentService.findReportsOfStudent(name, fio);
        req.setAttribute("allReports", reportsOfStudent);
        req.getRequestDispatcher("report/reports.jsp").forward(req, resp);
    }

    private String getParam(HttpServletRequest req, String nameField) {
        return Optional.ofNullable(req.getParameter(nameField))
                .filter(StringUtils::isNotBlank)
                .orElse(null);
    }

}
