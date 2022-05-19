package by.it.academy.task10.services.implementations;

import by.it.academy.task10.dao.implementations.*;
import by.it.academy.task10.dao.interfaces.*;
import by.it.academy.task10.dto.MentorDto;
import by.it.academy.task10.dto.StudentDto;
import by.it.academy.task10.dto.mapper.MentorMapper;
import by.it.academy.task10.dto.mapper.StudentMapper;
import by.it.academy.task10.entity.*;
import by.it.academy.task10.services.interfaces.MentorService;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MentorServiceImpl implements MentorService {

    private MentorDao mentorDao = new MentorDaoImpl();
    private CourseDao courseDao = new CourseDaoImpl();
    private StudentDao studentDao = new StudentDaoImpl();
    private TaskDao taskDao = new TaskDaoImpl();
    private MarkReportDao markReportDao = new MarkReportDaoImpl();
    private UserDao userDao = new UserDAOImpl();


    public void createTask(String titleCourse, String titleTask) throws SQLException {
        Course course = courseDao.findOne(GeneralServiceImpl.getIdCourse(titleCourse, courseDao));
        if (GeneralServiceImpl.getIdTask(titleTask, taskDao) == null) {
            Task task = taskDao.create(Task.builder()
                    .title(titleTask)
                    .build());
            task.setTaskCourse(course);
            course.getTasks().add(task);
            courseDao.update(course);
            taskDao.update(task);
        }
    }

    public void deleteTask(String titleTask, String titleCourse) throws SQLException {
        taskDao.deleteById(GeneralServiceImpl.getIdTask(titleTask, taskDao));
    }

    public void rateAndFeedbackStudentTask(String nameStudent, String surnameStudent,
                                           String titleTask, String titleCourse,
                                           Integer mark, String feedback) throws SQLException {
        Student student = studentDao.findOne(GeneralServiceImpl.getIdUser(nameStudent, surnameStudent, userDao));
        Task task = taskDao.findOne(GeneralServiceImpl.getIdTask(titleTask, taskDao));
        Mentor mentor = mentorDao.findOne(GeneralServiceImpl.getIdMentorOfCourse(titleCourse, courseDao));
        Integer idReport = GeneralServiceImpl.getIdReport(nameStudent, surnameStudent, titleTask,
                taskDao, studentDao, markReportDao,userDao);
        if (idReport == null) {
            MarkReport markReport = MarkReport.builder()
                    .mentor(mentor)
                    .student(student)
                    .task(task)
                    .mark(mark)
                    .feedback(feedback)
                    .build();

            markReportDao.create(markReport);
        } else {
            MarkReport markReport = markReportDao.findOne(idReport);
            markReport.setMark(mark);
            markReport.setFeedback(feedback);
            markReportDao.update(markReport);
        }
    }

    public Set<Student> findStudentsOfCourse(String titleCourse) throws SQLException {
        Integer idCourse = GeneralServiceImpl.getIdCourse(titleCourse,courseDao);
        Course course = courseDao.findOne(idCourse);
        Set<Student> students = course.getStudents();
        if (students.size() != 0) {
            return students;
        } else {
            return null;
        }

    }

    public List<MentorDto> findAllMentors() {
        return mentorDao.findAll()
                .stream()
                .map(MentorMapper::mapFrom)
                .collect(Collectors.toList());
    }

    public String updateMentor(Integer id, String name, String surname) throws SQLException {
        Mentor mentor = mentorDao.findOne(id);
        mentor.setName(name);
        mentor.setSurname(surname);
        Mentor update = mentorDao.update(mentor);
        if (mentor.equals(update)) {
            return "STUDENT SUCCESSFULLY UPDATE";
        } else {
            return "UPDATE ERROR";
        }
    }

}
