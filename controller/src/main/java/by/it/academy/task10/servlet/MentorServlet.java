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
import java.util.List;
import java.util.Optional;

@WebServlet(name = "mentorServlet", value = "/mentors")
public class MentorServlet extends HttpServlet {

    public static final String VALIDATE = "ИЗМЕНЕНИЯ ВНЕСЕНЫ УСПЕШНО";
    public static final String ADD = "add";
    public static final String EDIT = "edit";
    public static final String DELETE = "delete";
    public static final String VIEWCOURSE = "viewcourse";
    public static final String ALL_MENTORS = "allMentors";
    public static final String METHOD = "method";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminService adminService = new AdminServiceImpl();
        MentorService mentorService = new MentorServiceImpl();
        if (DELETE.equals(getParam(request, METHOD))) {
            Integer id = Integer.parseInt(getParam(request, "delete_id"));
            try {
                adminService.deleteMentor(id);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else if (VIEWCOURSE.equals(getParam(request, METHOD))) {
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
        request.setAttribute(ALL_MENTORS, mentorService.findAllMentors());
        request.getRequestDispatcher("mentor/mentors.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdminService adminService = new AdminServiceImpl();
        String name = getParam(request, "txt_name");
        String surname = getParam(request, "txt_surname");
        String hiddenId = getParam(request, "hidden_id");
        String updateValidate = null;
        if (EDIT.equals(getParam(request, METHOD))) {
            Integer id = null;
            if (hiddenId != null) {
                id = Integer.parseInt(hiddenId);
                try {
                    if (adminService.changeMentorRecord(MentorDto.builder()
                            .id(id)
                            .name(name)
                            .surname(surname)
                            .build())) {
                        updateValidate = VALIDATE;
                    }
                } catch (SQLException e) {
                    updateValidate = e.getMessage();
                }
            }
        } else if (ADD.equals(getParam(request, METHOD))) {
            try {
                if (adminService.addNewMentor(MentorDto.builder()
                        .name(name)
                        .surname(surname)
                        .build())) {
                    updateValidate = VALIDATE;
                }
            } catch (SQLException e) {
                updateValidate = e.getMessage();
            }
        }
        if (VALIDATE.equals(updateValidate)) {
            request.setAttribute("UpdateSuccessMsg", updateValidate);
            request.removeAttribute(METHOD);
            doGet(request, response);
        } else {
            request.setAttribute("UpdateErrorMsg", updateValidate);
            request.getRequestDispatcher("mentor/mentorData.jsp").forward(request, response);
        }
    }


    private String getParam(HttpServletRequest req, String nameField) {
        return Optional.ofNullable(req.getParameter(nameField))
                .filter(StringUtils::isNotBlank)
                .orElse(null);
    }


}
