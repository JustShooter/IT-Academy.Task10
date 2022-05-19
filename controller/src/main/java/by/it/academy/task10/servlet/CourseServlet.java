package by.it.academy.task10.servlet;

import by.it.academy.task10.services.implementations.AdminServiceImpl;
import by.it.academy.task10.services.interfaces.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "courseServlet", value = "/courses")
public class CourseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        AdminService adminService = new AdminServiceImpl();
        req.setAttribute("allCourses", adminService.getAllCourses());
        req.getRequestDispatcher("course/courses.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

}
