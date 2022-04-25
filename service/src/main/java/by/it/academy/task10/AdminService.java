package by.it.academy.task10;

import by.it.academy.task10.dao.Dao;
import by.it.academy.task10.entity.Course;
import by.it.academy.task10.entity.Mentor;
import by.it.academy.task10.entity.Student;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class AdminService {
    GeneralService generalService = new GeneralService();
    Dao<Student> studentDao = new Dao<>(Student.class);
    Dao<Mentor> mentorDao = new Dao<>(Mentor.class);
    Dao<Course> courseDao = new Dao<>(Course.class);


    public boolean createStudent(String name, String surname) {
        Integer idUser = generalService.getIdUser(name, surname);
        if (idUser == null) {
            Student student = studentDao.create(Student.builder()
                    .name(name)
                    .surname(surname)
                    .role("Student")
                    .build());
            return student != null;
        } else {
            System.out.println("Student already exist");
            return false;
        }
    }

    public void deleteStudent(String name, String surname) throws SQLException {
        Integer idUser = generalService.getIdUser(name, surname);
        studentDao.deleteById(idUser);
    }

    public void addStudentToCourse(String name, String surname, String title) throws SQLException {
        Integer idStudent = generalService.getIdUser(name, surname);
        Student student = studentDao.findOne(idStudent);
        Integer idCourse = generalService.getIdCourse(title);
        Course course = courseDao.findOne(idCourse);
        Set<Course> coursesStudent = student.getCourses();
        if (coursesStudent != null) {
            coursesStudent.add(course);
        } else {
            coursesStudent = Set.of(course);
        }
        student.setCourses(coursesStudent);
        studentDao.update(student);

    }

    public boolean createMentor(String name, String surname) {
        Integer idUser = generalService.getIdUser(name, surname);
        if (idUser == null) {
            Mentor mentor = mentorDao.create(Mentor.builder()
                    .name(name)
                    .surname(surname)
                    .role("Mentor")
                    .build());
            return mentor != null;
        } else {
            System.out.println("Mentor already exist");
            return false;
        }
    }

    public void deleteMentor(String name, String surname) throws SQLException {
        Integer idMentor = generalService.getIdUser(name, surname);
        mentorDao.deleteById(idMentor);
    }

    public void addMentorToCourse(String name, String surname, String title) throws SQLException {
        Integer idMentor = generalService.getIdUser(name, surname);
        Mentor mentor = mentorDao.findOne(idMentor);
        Integer idCourse = generalService.getIdCourse(title);
        Course course = courseDao.findOne(idCourse);
        course.setMentorCourse(mentor);
        mentor.setCourseMentor(course);
        mentorDao.update(mentor);
    }

    public List<Course> getAllCourses(){
        List<Course> all = courseDao.findAll();
        if (all.size() != 0){
            return all;
        }else {
            return null;
        }
    }
    public boolean addCourse(String courseTitle) {
        if (generalService.getIdCourse(courseTitle) == null) {
            Course course = courseDao.create(Course.builder()
                    .title(courseTitle)
                    .build());
            return (course != null);
        } else {
            System.out.println("Course already exist!");
        }
        return false;
    }
}
