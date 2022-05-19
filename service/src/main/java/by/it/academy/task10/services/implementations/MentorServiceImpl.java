package by.it.academy.task10.services.implementations;

import by.it.academy.task10.dao.implementations.CourseDaoImpl;
import by.it.academy.task10.dao.implementations.MarkReportDaoImpl;
import by.it.academy.task10.dao.implementations.MentorDaoImpl;
import by.it.academy.task10.dao.implementations.StudentDaoImpl;
import by.it.academy.task10.dao.implementations.TaskDaoImpl;
import by.it.academy.task10.dao.implementations.UserDAOImpl;
import by.it.academy.task10.dao.interfaces.CourseDao;
import by.it.academy.task10.dao.interfaces.MarkReportDao;
import by.it.academy.task10.dao.interfaces.MentorDao;
import by.it.academy.task10.dao.interfaces.StudentDao;
import by.it.academy.task10.dao.interfaces.TaskDao;
import by.it.academy.task10.dao.interfaces.UserDao;
import by.it.academy.task10.dto.CourseDto;
import by.it.academy.task10.dto.MentorDto;
import by.it.academy.task10.dto.mapper.CourseMapper;
import by.it.academy.task10.dto.mapper.MentorMapper;
import by.it.academy.task10.entity.Course;
import by.it.academy.task10.entity.MarkReport;
import by.it.academy.task10.entity.Mentor;
import by.it.academy.task10.entity.Student;
import by.it.academy.task10.entity.Task;
import by.it.academy.task10.services.interfaces.GeneralService;
import by.it.academy.task10.services.interfaces.MentorService;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MentorServiceImpl implements MentorService {

    private final MentorDao mentorDao = new MentorDaoImpl();
    private final CourseDao courseDao = new CourseDaoImpl();
    private final StudentDao studentDao = new StudentDaoImpl();
    private final TaskDao taskDao = new TaskDaoImpl();
    private final MarkReportDao markReportDao = new MarkReportDaoImpl();
    private final UserDao userDao = new UserDAOImpl();
    private final GeneralService generalService = new GeneralServiceImpl();

    @Override
    public void createTask(String titleCourse, String titleTask) throws SQLException {
        Course course = courseDao.findOne(generalService.getIdCourse(titleCourse, courseDao));
        if (generalService.getIdTask(titleTask, taskDao) == null) {
            Task task = taskDao.create(Task.builder()
                    .title(titleTask)
                    .build());
            task.setTaskCourse(course);
            course.getTasks().add(task);
            courseDao.update(course);
            taskDao.update(task);
        }
    }

    @Override
    public void deleteTask(String titleTask, String titleCourse) throws SQLException {
        taskDao.deleteById(generalService.getIdTask(titleTask, taskDao));
    }

    @Override
    public void rateAndFeedbackStudentTask(String nameStudent, String surnameStudent,
                                           String titleTask, String titleCourse,
                                           Integer mark, String feedback) throws SQLException {
        Student student = studentDao.findOne(generalService.getIdUser(nameStudent, surnameStudent, userDao));
        Task task = taskDao.findOne(generalService.getIdTask(titleTask, taskDao));
        Mentor mentor = mentorDao.findOne(generalService.getIdMentorOfCourse(titleCourse, courseDao));
        Integer idReport = generalService.getIdReport(nameStudent, surnameStudent, titleTask,
                taskDao, studentDao, markReportDao, userDao);
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

    @Override
    public Set<Student> findStudentsOfCourse(String titleCourse) throws SQLException {
        Integer idCourse = generalService.getIdCourse(titleCourse, courseDao);
        Course course = courseDao.findOne(idCourse);
        Set<Student> students = course.getStudents();
        if (students.size() != 0) {
            return students;
        } else {
            return null;
        }
    }

    @Override
    public List<CourseDto> getAllCoursesOfMentor(Integer mentorId) {
        List<Course> allCoursesByMentorId = courseDao.getAllCoursesByMentorId(mentorId);
        if (allCoursesByMentorId == null) {
            return Collections.emptyList();
        } else {
            return allCoursesByMentorId
                    .stream()
                    .map(CourseMapper::mapFrom)
                    .collect(Collectors.toList());
        }
    }

    @Override
    public List<MentorDto> findAllMentors() {
        return mentorDao.findAll()
                .stream()
                .map(MentorMapper::mapFrom)
                .collect(Collectors.toList());
    }
}
