package by.it.academy.task10.servlet;

import by.it.academy.task10.services.implementations.AdminServiceImpl;
import by.it.academy.task10.services.implementations.StudentServiceImpl;
import by.it.academy.task10.services.interfaces.AdminService;
import by.it.academy.task10.services.interfaces.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "studentUpdateServlet", value = "/studentUpdate")
public class StudentUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentService studentService = new StudentServiceImpl();
        AdminService adminService = new AdminServiceImpl();

        String parameter = req.getParameter("type");
        switch (parameter) {
            case "update":
                Integer studentId = Integer.parseInt(req.getParameter("studentId"));
                String name = req.getParameter("nameString");
                String surname = req.getParameter("surnameString");
                try {
                    studentService.updateStudent(studentId, name, surname);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                Integer id = Integer.parseInt(req.getParameter("idDelete"));
                try {
                    adminService.deleteStudent(id);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                resp.sendRedirect("student/students.jsp");
                break;
            case "create":
                String name1 = req.getParameter("nameString");
                String surname1 = req.getParameter("surnameString");
                adminService.createStudent(name1,surname1);
                resp.sendRedirect("student/students.jsp");
                break;

        }

        req.getRequestDispatcher("student/students.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
