package by.it.academy.task10.servlets;

import by.it.academy.task10.entity.MarkReport;
import by.it.academy.task10.services.implementations.StudentServiceImpl;
import by.it.academy.task10.services.interfaces.StudentService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Optional;
import java.util.Set;

@WebServlet(name = "servletReport", value = "/report")
public class ServletReport extends HttpServlet {

    StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fio = getParam(req, "fio");
        String name = getParam(req, "name");
        Set<MarkReport> reportsOfStudent = studentService.findReportsOfStudent(name, fio);
        req.setAttribute("Set", reportsOfStudent);
        RequestDispatcher viewReport = req.getRequestDispatcher("/ReportsList.jsp");
        viewReport.forward(req, resp);
    }

    private String getParam(HttpServletRequest req, String param) {
        return Optional.ofNullable(req.getParameter(param))
                .filter(StringUtils::isNotBlank)
                .orElse(null);
    }
}
