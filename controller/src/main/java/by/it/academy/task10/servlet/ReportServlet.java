package by.it.academy.task10.servlet;

import by.it.academy.task10.services.implementations.AdminServiceImpl;
import by.it.academy.task10.services.interfaces.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "reportServlet", value = "/reports")
public class ReportServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        AdminService adminService = new AdminServiceImpl();
        req.setAttribute("allReports", adminService.getAllReports());
        req.getRequestDispatcher("report/reports.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

}
