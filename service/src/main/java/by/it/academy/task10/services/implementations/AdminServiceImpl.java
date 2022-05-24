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
import by.it.academy.task10.dto.MarkReportDto;
import by.it.academy.task10.dto.MentorDto;
import by.it.academy.task10.dto.StudentDto;
import by.it.academy.task10.dto.TaskDto;
import by.it.academy.task10.dto.mapper.CourseMapper;
import by.it.academy.task10.dto.mapper.MarkReportMapper;
import by.it.academy.task10.dto.mapper.MentorMapper;
import by.it.academy.task10.dto.mapper.StudentMapper;
import by.it.academy.task10.dto.mapper.TaskMapper;
import by.it.academy.task10.entity.Course;
import by.it.academy.task10.entity.Mentor;
import by.it.academy.task10.entity.Student;
import by.it.academy.task10.services.interfaces.AdminService;
import by.it.academy.task10.services.interfaces.GeneralService;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;


public class AdminServiceImpl implements AdminService {

    public static final String MENTOR_EXIST = "Преподаватель с такими данными уже существует!";
    public static final String WRONG_ID = "Не верно указано ID";
    private final StudentDao studentDao = new StudentDaoImpl();
    private final MentorDao mentorDao = new MentorDaoImpl();
    private final CourseDao courseDao = new CourseDaoImpl();
    private final UserDao userDao = new UserDAOImpl();
    private final TaskDao taskDao = new TaskDaoImpl();
    private final MarkReportDao markReportDao = new MarkReportDaoImpl();
    private final MarkReportMapper markReportMapper = new MarkReportMapper();
    private final GeneralService generalService = new GeneralServiceImpl();

    public MarkReportDto findReportById(Integer id) throws SQLException {
        return markReportMapper.mapFrom(markReportDao.findOne(id));
    }

    public TaskDto findTaskById(Integer id) throws SQLException {
        return TaskMapper.mapFrom(taskDao.findOne(id));
    }

    public CourseDto findCourseById(Integer id) throws SQLException {
        return CourseMapper.mapFrom(courseDao.findOne(id));
    }

    public StudentDto findStudentById(Integer id) throws SQLException {
        return StudentMapper.mapFrom(studentDao.findOne(id));
    }

    @Override
    public MentorDto findMentorById(Integer id) throws SQLException {
        return MentorMapper.mapFrom(mentorDao.findOne(id));
    }

    public void createStudent(String name, String surname) {
        if (generalService.getIdUser(name, surname, userDao) == null) {
            studentDao.create(Student.builder()
                    .name(name)
                    .surname(surname)
                    .build());
        }
    }

    public void deleteStudent(String name, String surname) throws SQLException {
        Integer idUser = generalService.getIdUser(name, surname, userDao);
        studentDao.deleteById(idUser);
    }

    public void createMentor(String name, String surname) {
        if (generalService.getIdUser(name, surname, userDao) == null) {
            mentorDao.create(Mentor.builder()
                    .name(name)
                    .surname(surname)
                    .build());
        }
    }

    public void deleteMentor(Integer idMentor) throws SQLException {
        mentorDao.deleteById(idMentor);
    }

    public void createCourse(String titleCourse) {
        if (generalService.getIdCourse(titleCourse, courseDao) == null) {
            courseDao.create(Course.builder()
                    .title(titleCourse)
                    .build());
        }
    }

    public void deleteCourse(String titleCourse) throws SQLException {
        Integer idCourse = generalService.getIdCourse(titleCourse, courseDao);
        courseDao.deleteById(idCourse);
    }

    public void addMentorToCourse(String name, String surname, String title) throws SQLException {
        Mentor mentor = mentorDao.findOne(generalService.getIdUser(name, surname, userDao));
        Course course = courseDao.findOne(generalService.getIdCourse(title, courseDao));
        if (course.getMentor() == null) {
            course.setMentor(mentor);
            mentor.getCourses().add(course);
        }
        mentorDao.update(mentor);
        courseDao.update(course);
    }

    public void addStudentToCourse(String name, String surname, String title) throws SQLException {
        Student student = studentDao.findOne(generalService.getIdUser(name, surname, userDao));
        Course course = courseDao.findOne(generalService.getIdCourse(title, courseDao));
        student.getCourses().add(course);
      /*  course.getStudents().add(student);
        courseDao.update(course);*/
        studentDao.update(student);
    }

    public List<CourseDto> getAllCourses() {
        return courseDao.findAll()
                .stream()
                .map(CourseMapper::mapFrom)
                .collect(Collectors.toList());
    }

    @Override
    public List<MentorDto> getAllMentors() {
        return mentorDao.findAll()
                .stream()
                .map(MentorMapper::mapFrom)
                .collect(Collectors.toList());
    }

    @Override
    public List<MarkReportDto> getAllReports() {
        return markReportDao.findAll()
                .stream()
                .map(MarkReportMapper::mapFrom)
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskDto> getAllTasks() {
        return taskDao.findAll()
                .stream()
                .map(TaskMapper::mapFrom)
                .collect(Collectors.toList());
    }


    @Override
    public Boolean changeMentorRecord(MentorDto mentorDto) throws SQLException {
        try {
            mentorDao.findOne(mentorDto.getId());
        } catch (SQLException e) {
            throw new SQLException(WRONG_ID);
        }
        Mentor mentor = mentorDao.update(Mentor.builder()
                .name(mentorDto.getName())
                .surname(mentorDto.getSurname())
                .id(mentorDto.getId())
                .build());
        return mentor.getName().equals(mentorDto.getName())
                && mentor.getSurname().equals(mentorDto.getSurname());
    }

    @Override
    public boolean addNewMentor(MentorDto mentorDto) throws SQLException {
        try {
            mentorDao.getMentorIdByFullName(mentorDto.getName(), mentorDto.getSurname());
            throw new SQLException(MENTOR_EXIST);
        } catch (NoResultException e) {
            Mentor mentor = mentorDao.create(Mentor.builder()
                    .name(mentorDto.getName())
                    .surname(mentorDto.getSurname())
                    .build());
            return mentor.getName().equals(mentorDto.getName())
                    && mentor.getSurname().equals(mentorDto.getSurname());
        }
    }
}
