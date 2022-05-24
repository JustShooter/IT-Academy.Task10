package by.it.academy.task10.servlet;

import by.it.academy.task10.dto.MentorDto;
import by.it.academy.task10.services.implementations.AdminServiceImpl;
import by.it.academy.task10.services.interfaces.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet(name = "courseServlet", value = "/courses")
public class CourseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        AdminService adminService = new AdminServiceImpl();
        Map<Integer, String> mentors = adminService.getAllMentors().stream()
                .collect(Collectors
                        .toMap(MentorDto::getId,
                                mentorDto -> mentorDto.getName().concat(" " + mentorDto.getSurname())));
        req.setAttribute("mentorsMap", mentors);
        req.setAttribute("allCourses", adminService.getAllCourses());
        req.getRequestDispatcher("course/courses.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

}
