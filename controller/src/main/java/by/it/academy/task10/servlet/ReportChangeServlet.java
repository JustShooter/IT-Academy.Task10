package by.it.academy.task10.servlet;

import by.it.academy.task10.dto.MarkReportDto;
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

@WebServlet(name = "reportChangeServlet", value = "/reportChange")
public class ReportChangeServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentService studentService = new StudentServiceImpl();
        Integer id = Integer.parseInt(getParam(req, "id"));
        String name = getParam(req, "name");
        String fio = getParam(req, "surname");
        System.out.println(fio);
        studentService.deleteTaskReport(id);
        StudentService studentService2 = new StudentServiceImpl();
        List<MarkReportDto> reportsOfStudent = studentService2.findReportsOfStudent(name, fio);
        req.setAttribute("allReports", reportsOfStudent);
        req.getRequestDispatcher("report/reports.jsp").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentService studentService = new StudentServiceImpl();
        Integer id = Integer.parseInt(getParam(req, "id"));
        Integer mark = Integer.parseInt(getParam(req, "mark"));
        String feedback = getParam(req, "feedback");
        String name = getParam(req, "name");
        String fio = getParam(req, "fio");
        studentService.updateTaskReport(id, feedback, mark);
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
