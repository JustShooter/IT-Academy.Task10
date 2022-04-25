package by.it.academy.task10;

import by.it.academy.task10.dao.Dao;
import by.it.academy.task10.entity.Course;
import by.it.academy.task10.entity.Mentor;
import by.it.academy.task10.entity.Student;
import by.it.academy.task10.entity.User;

import java.sql.SQLException;
import java.util.List;

public class AdminService {
    private Dao<Student> studentDao = new Dao<>(Student.class);
    private Dao<Mentor> mentorDao = new Dao<>(Mentor.class);
    private Dao<Course> courseDao = new Dao<>(Course.class);


    public void createStudent(String name, String surname) {
        Integer idUser = GeneralService.getIdUser(name, surname);
        if (idUser == null) {
            Student student = studentDao.create(Student.builder()
                    .name(name)
                    .surname(surname)
                    .role("Student")
                    .build());
        }else {
            System.out.println("Student already exist");
        }
    }

    public void deleteStudent(String name, String surname) throws SQLException {
        Integer idUser = GeneralService.getIdUser(name, surname);
        studentDao.deleteById(idUser);
    }

    public void addStudentToCourse(String name, String surname, String title) throws SQLException {
        Integer idStudent = GeneralService.getIdUser(name, surname);
        Student student = studentDao.findOne(idStudent);
        Integer idCourse = GeneralService.getIdCourse(title);
        Course course = courseDao.findOne(idCourse);
        student.getCourses().add(course);
        studentDao.update(student);
    }

    public void createMentor(String name, String surname) {
        Integer idUser = GeneralService.getIdUser(name, surname);
        if (idUser == null) {
            Mentor mentor = mentorDao.create(Mentor.builder()
                    .name(name)
                    .surname(surname)
                    .role("Mentor")
                    .build());
        } else {
            System.out.println("Mentor already exist");
        }
    }

    public void deleteMentor(String name, String surname) throws SQLException {
        Integer idMentor = GeneralService.getIdUser(name, surname);
        mentorDao.deleteById(idMentor);
    }

    public void createCourse(String titleCourse) {
        Integer idCourse = GeneralService.getIdCourse(titleCourse);
        if (idCourse == null) {
            Course course = courseDao.create(Course.builder()
                    .title(titleCourse)
                    .build());
        } else {
            System.out.println("Course already exist");
        }
    }

    public void deleteCourse(String titleCourse) throws SQLException {
        Integer idCourse = GeneralService.getIdCourse(titleCourse);
        courseDao.deleteById(idCourse);
    }

    public void addMentorToCourse(String name, String surname, String title) throws SQLException {
        Integer idMentor = GeneralService.getIdUser(name, surname);
        Mentor mentor = mentorDao.findOne(idMentor);
        Integer idCourse = GeneralService.getIdCourse(title);
        Course course = courseDao.findOne(idCourse);
        if (course.getMentorCourse() == null){
            course.setMentorCourse(mentor);
            mentor.setCourseMentor(course);
            mentorDao.update(mentor);
        } else {
            System.out.println("For this course the mentor has been already assigned");
        }

    }

    public List<Course> getAllCourses() {
        List<Course> all = courseDao.findAll();
        if (all.size() != 0) {
            return all;
        } else {
            return null;
        }
    }
}
