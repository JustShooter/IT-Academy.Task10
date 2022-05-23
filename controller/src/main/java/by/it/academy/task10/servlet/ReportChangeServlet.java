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
import java.util.Optional;

@WebServlet(name = "reportChangeServlet", value = "/reportChange")
public class ReportChangeServlet extends HttpServlet {

    private final StudentService studentService = new StudentServiceImpl();

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(getParam(req, "id"));
        String name = getParam(req, "name");
        String fio = getParam(req, "fio");
        studentService.deleteTaskReport(id);
        req.getRequestDispatcher("report/viewReport.jsp?value=Оценить Студента").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(getParam(req, "id"));
        Integer mark = Integer.parseInt(getParam(req, "mark"));
        String feedback = getParam(req, "feedback");
        studentService.updateTaskReport(id, feedback, mark);
        req.getRequestDispatcher("report/viewReport.jsp").forward(req, resp);
       /* List<MarkReportDto> reportsOfStudent = studentService.findReportsOfStudent(name, fio);
        req.setAttribute("allReports", reportsOfStudent);
        String name = getParam(req, "name");
        String fio = getParam(req, "fio");*/
    }

    private String getParam(HttpServletRequest req, String nameField) {
        return Optional.ofNullable(req.getParameter(nameField))
                .filter(StringUtils::isNotBlank)
                .orElse(null);
    }
}
