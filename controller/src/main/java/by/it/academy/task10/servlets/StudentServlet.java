package by.it.academy.task10.servlets;

import by.it.academy.task10.services.implementations.StudentServiceImpl;
import by.it.academy.task10.services.interfaces.StudentService;
import liquibase.repackaged.org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet(name = "studentServlet", value = "/students")
public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        StudentService studentService = new StudentServiceImpl();
        req.setAttribute("allStudents", studentService.findAllStudents());
        req.getRequestDispatcher("student/students.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("btn_edit") != null) {
            StudentService studentService = new StudentServiceImpl();
            String name = getParam(req, "nameString");
            String surname = getParam(req, "surnameString");
            Integer hidden_id = Integer.parseInt(getParam(req, "hidden_id"));
            String updateValidate = null;
            try {
                updateValidate = studentService.updateStudent(hidden_id, name, surname);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            if ("STUDENT SUCCESSFULLY UPDATE".equals(updateValidate)) {
                req.setAttribute("UpdateSuccessMsg", updateValidate);
                doGet(req, resp);
            } else {
                req.setAttribute("UpdateErrorMsg", updateValidate);
                req.getRequestDispatcher("..student/updateStudent.jsp").forward(req, resp);
            }
        }

    }

    private String getParam(HttpServletRequest req, String nameField) {
        return Optional.ofNullable(req.getParameter(nameField))
                .filter(StringUtils::isNotBlank)
                .orElse(null);
    }
}
