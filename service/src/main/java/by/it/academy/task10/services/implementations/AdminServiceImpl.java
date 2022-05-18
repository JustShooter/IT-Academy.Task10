package by.it.academy.task10.services.implementations;

import by.it.academy.task10.dao.implementations.*;
import by.it.academy.task10.dao.interfaces.*;
import by.it.academy.task10.dto.CourseDto;
import by.it.academy.task10.dto.MarkReportDto;
import by.it.academy.task10.dto.StudentDto;
import by.it.academy.task10.dto.TaskDto;
import by.it.academy.task10.dto.mapper.CourseMapper;
import by.it.academy.task10.dto.mapper.MarkReportMapper;
import by.it.academy.task10.dto.mapper.StudentMapper;
import by.it.academy.task10.dto.mapper.TaskMapper;
import by.it.academy.task10.entity.Course;
import by.it.academy.task10.entity.Mentor;
import by.it.academy.task10.entity.Student;
import by.it.academy.task10.services.interfaces.AdminService;
import by.it.academy.task10.services.interfaces.GeneralService;

import java.sql.SQLException;
import java.util.List;


public class AdminServiceImpl implements AdminService {

    private final StudentDao studentDao = new StudentDaoImpl();
    private final MentorDao mentorDao = new MentorDaoImpl();
    private final CourseDao courseDao = new CourseDaoImpl();
    private final UserDao userDao = new UserDAOImpl();
    private final TaskDao taskDao = new TaskDaoImpl();
    private final MarkReportDao markReportDao = new MarkReportDaoImpl();
    private final StudentMapper userMapper = new StudentMapper();
    private final CourseMapper courseMapper = new CourseMapper();
    private final TaskMapper taskMapper = new TaskMapper();
    private final MarkReportMapper markReportMapper = new MarkReportMapper();

    public MarkReportDto findReportById(Integer id) throws SQLException {
        return markReportMapper.mapFrom(markReportDao.findOne(id));
    }

    public TaskDto findTaskById(Integer id) throws SQLException {
        return taskMapper.mapFrom(taskDao.findOne(id));
    }
    public CourseDto findCourseById(Integer id) throws SQLException {
        return courseMapper.mapFrom(courseDao.findOne(id));
    }

    public StudentDto findStudentById(Integer id) throws SQLException {
        return userMapper.mapFrom(studentDao.findOne(id));
    }

    public void createStudent(String name, String surname) {
        if (GeneralService.getIdUser(name, surname, userDao) == null) {
            studentDao.create(Student.builder()
                    .name(name)
                    .surname(surname)
                    .build());
        }
    }

    public void deleteStudent(String name, String surname) throws SQLException {
        Integer idUser = GeneralService.getIdUser(name, surname, userDao);
        studentDao.deleteById(idUser);
    }

    public void createMentor(String name, String surname) {
        if (GeneralService.getIdUser(name, surname, userDao) == null) {
            mentorDao.create(Mentor.builder()
                    .name(name)
                    .surname(surname)
                    .build());
        }
    }

    public void deleteMentor(String name, String surname) throws SQLException {
        Integer idMentor = GeneralService.getIdUser(name, surname, userDao);
        mentorDao.deleteById(idMentor);
    }

    public void createCourse(String titleCourse) {
        if (GeneralService.getIdCourse(titleCourse, courseDao) == null) {
            courseDao.create(Course.builder()
                    .title(titleCourse)
                    .build());
        }
    }

    public void deleteCourse(String titleCourse) throws SQLException {
        Integer idCourse = GeneralService.getIdCourse(titleCourse, courseDao);
        courseDao.deleteById(idCourse);
    }

    public void addMentorToCourse(String name, String surname, String title) throws SQLException {
        Mentor mentor = mentorDao.findOne(GeneralService.getIdUser(name, surname, userDao));
        Course course = courseDao.findOne(GeneralService.getIdCourse(title, courseDao));
        if (course.getMentor() == null) {
            course.setMentor(mentor);
            mentor.getCourses().add(course);
        }
        mentorDao.update(mentor);
        courseDao.update(course);
    }

    public void addStudentToCourse(String name, String surname, String title) throws SQLException {
        Student student = studentDao.findOne(GeneralService.getIdUser(name, surname, userDao));
        Course course = courseDao.findOne(GeneralService.getIdCourse(title, courseDao));
        student.getCourses().add(course);
      /*  course.getStudents().add(student);
        courseDao.update(course);*/
        studentDao.update(student);
    }

    public List<Course> getAllCourses() {
        return (courseDao.findAll() == null) ? null : courseDao.findAll();
    }
}
