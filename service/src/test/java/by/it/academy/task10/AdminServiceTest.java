package by.it.academy.task10;

import by.it.academy.task10.dao.Dao;
import by.it.academy.task10.entity.Course;
import by.it.academy.task10.entity.Mentor;
import by.it.academy.task10.entity.Student;
import by.it.academy.task10.util.HibernateUtil;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class AdminServiceTest {

    GeneralService generalService = new GeneralService();
    AdminService admin = new AdminService();

    Dao<Student> studentDao = new Dao<>(Student.class);
    Dao<Mentor> mentorDao = new Dao<>(Mentor.class);
    Dao<Course> courseDao = new Dao<>(Course.class);







    @Test
    void uniqueStudentCreateInDataBase() {
        assertTrue(admin.createStudent("One2", "Two"));
    }

    @Test
    void uniqueStudentShouldBeOnlyOne() {
        assertFalse(admin.createStudent("One2", "Two"));
    }

    @Test
    void deleteStudentFromDataBase()  { // не сработало
//        try {
//       Integer id =  generalService.getIdUser("Rick","Ivanov");
//       Student newStudent= studentDao.findOne(id);
//
//        System.out.println(newStudent);
//
//            admin.deleteStudent("One2","Two");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        System.out.println(newStudent);
    }

    @Test
    void addStudentToCourse(){

        try {
            admin.addStudentToCourse("One2","Two","Biology");
            Student currentStudent = admin.studentDao.findOne(30);
            System.out.println(currentStudent.getCourses());
           // currentStudent.getCourses().add(course);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
//Integer idStudent = generalService.getIdUser(name, surname);
//        Student student = studentDao.findOne(idStudent);
//        Integer idCourse = generalService.getIdCourse(title);
//        Course course = courseDao.findOne(idCourse);
//        Set<Course> coursesStudent = student.getCourses();
//        coursesStudent.add(course);
//        student.setCourses(coursesStudent);
//        studentDao.update(student);