package by.it.academy.task10.servlets;

import by.it.academy.task10.services.implementations.MentorServiceImpl;
import by.it.academy.task10.services.interfaces.MentorService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "mentorServlet", value = "/mentors")
public class MentorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MentorService mentorService = new MentorServiceImpl();
        req.setAttribute("allMentors", mentorService.findAllMentors());
        req.getRequestDispatcher("mentor/mentors.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


}
