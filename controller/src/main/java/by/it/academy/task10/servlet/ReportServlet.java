package by.it.academy.task10.servlet;

import by.it.academy.task10.dao.implementations.StudentDaoImpl;
import by.it.academy.task10.dao.interfaces.StudentDao;
import by.it.academy.task10.dto.MarkReportDto;
import by.it.academy.task10.entity.MarkReport;
import by.it.academy.task10.services.implementations.AdminServiceImpl;
import by.it.academy.task10.services.implementations.StudentServiceImpl;
import by.it.academy.task10.services.interfaces.AdminService;
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

@WebServlet(name = "reportServlet", value = "/reports")
public class ReportServlet extends HttpServlet {

    private final StudentService studentService = new StudentServiceImpl();
    private final AdminService adminService = new AdminServiceImpl();

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if ("change".equals(getParam(req, "value"))) {
            Integer id = Integer.parseInt(getParam(req, "id"));
            String feedback = getParam(req, "feedback");
            Integer mark = Integer.parseInt(getParam(req, "mark"));
            String name = getParam(req, "name");
            String surname = getParam(req, "surname");
            String task = getParam(req, "task");
            studentService.updateTaskReport(id, feedback, mark);
        }
        req.setAttribute("allReports", adminService.getAllReports());
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
