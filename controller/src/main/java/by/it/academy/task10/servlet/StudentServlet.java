package by.it.academy.task10.servlet;

import by.it.academy.task10.dto.StudentDto;
import by.it.academy.task10.services.implementations.AdminServiceImpl;
import by.it.academy.task10.services.implementations.StudentServiceImpl;
import by.it.academy.task10.services.interfaces.AdminService;
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
        AdminService adminService = new AdminServiceImpl();
        if ("delete".equals(getParam(req, "method"))) {
            Integer id = Integer.parseInt(getParam(req, "delete_id"));
            try {
                adminService.deleteStudent(id);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else if ("coursesOfStudent".equals(getParam(req, "method"))) {
            Integer studentId = Integer.parseInt(getParam(req, "student_id"));
            StudentDto studentDto = null;
            try {
                studentDto = adminService.findStudentById(studentId);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            String stName = studentDto.getName().concat(" " + studentDto.getSurname());
            req.setAttribute("studentName", stName);
            try {
                req.setAttribute("allCourses", studentService.findCoursesOfStudent(studentId));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            req.getRequestDispatcher("student/coursesOfStudent.jsp").forward(req, resp);
        }
        req.setAttribute("allStudents", studentService.findAllStudents());
        req.getRequestDispatcher("student/students.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    private String getParam(HttpServletRequest req, String nameField) {
        return Optional.ofNullable(req.getParameter(nameField))
                .filter(StringUtils::isNotBlank)
                .orElse(null);
    }
}
