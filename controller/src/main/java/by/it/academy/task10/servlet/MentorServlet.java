package by.it.academy.task10.servlet;

import by.it.academy.task10.dto.MentorDto;
import by.it.academy.task10.services.implementations.AdminServiceImpl;
import by.it.academy.task10.services.implementations.MentorServiceImpl;
import by.it.academy.task10.services.interfaces.AdminService;
import by.it.academy.task10.services.interfaces.MentorService;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet(name = "mentorServlet", value = "/mentors")
public class MentorServlet extends HttpServlet {

    public static final String VALIDATE = "ИЗМЕНЕИЯ ВНЕСЕНЫ";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminService adminService = new AdminServiceImpl();
        MentorService mentorService = new MentorServiceImpl();
        if ("delete".equals(getParam(request, "method"))) {
            Integer id = Integer.parseInt(getParam(request, "delete_id"));
            try {
                adminService.deleteMentor(id);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else if ("viewcourse".equals(getParam(request, "method"))) {
            Integer mentorId = Integer.parseInt(getParam(request, "mentor_id"));
            MentorDto mentor = null;
            try {
                mentor = adminService.findMentorById(mentorId);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            String mentorFullName = mentor.getName().concat(" " + mentor.getSurname());
            request.setAttribute("mentorName", mentorFullName);
            request.setAttribute("allCourses", mentorService.getAllCoursesOfMentor(mentorId));
            request.getRequestDispatcher("course/courses.jsp").forward(request, response);
        }
        request.setAttribute("allMentors", mentorService.findAllMentors());
        request.getRequestDispatcher("mentor/mentors.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("btn_edit") != null) {
            AdminService adminService = new AdminServiceImpl();
            String name = getParam(request, "txt_name");
            String surname = getParam(request, "txt_surname");
            Integer hiddenId = Integer.parseInt(getParam(request, "hidden_id"));
            String updateValidate = null;
            try {
                if (adminService.changeMentorRecord(hiddenId, name, surname)) {
                    updateValidate = VALIDATE;
                }
            } catch (SQLException e) {
                updateValidate = e.getMessage();
            }
            if (VALIDATE.equals(updateValidate)) {
                request.setAttribute("UpdateSuccessMsg", updateValidate);
                doGet(request, response);
            } else {
                request.setAttribute("UpdateErrorMsg", updateValidate);
                request.getRequestDispatcher("mentor/edit.jsp").forward(request, response);
            }
        }
    }

    private String getParam(HttpServletRequest req, String nameField) {
        return Optional.ofNullable(req.getParameter(nameField))
                .filter(StringUtils::isNotBlank)
                .orElse(null);
    }

}
