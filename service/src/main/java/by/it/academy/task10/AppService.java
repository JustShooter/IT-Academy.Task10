package by.it.academy.task10;

import by.it.academy.task10.dao.implementations.StudentDaoImpl;
import by.it.academy.task10.dao.interfaces.StudentDao;
import by.it.academy.task10.entity.Course;
import by.it.academy.task10.entity.Student;
import by.it.academy.task10.services.implementations.AdminServiceImpl;
import by.it.academy.task10.services.implementations.MentorServiceImpl;
import by.it.academy.task10.services.implementations.StudentServiceImpl;
import by.it.academy.task10.services.interfaces.AdminService;
import by.it.academy.task10.services.interfaces.MentorService;
import by.it.academy.task10.services.interfaces.StudentService;

import java.sql.SQLException;
import java.util.Set;

public class AppService {
    public static void main(String[] args) throws SQLException {
        AdminService adminService = new AdminServiceImpl();
        StudentService studentService = new StudentServiceImpl();
        MentorService mentorService = new MentorServiceImpl();
        /*adminService.createCourse("Course 1");
        adminService.createCourse("Course 2");

        adminService.createMentor("Elton","John");
        adminService.createMentor("Evgeniy","Petrov");
        adminService.addMentorToCourse("Evgeniy","Petrov", "Course 2");
        adminService.addMentorToCourse("Elton","John","Course 1");

        adminService.createStudent("John","Lennon");
        adminService.createStudent("Michael", "Korsakov");
        adminService.addStudentToCourse("Michael", "Korsakov","Course 2");
        adminService.addStudentToCourse("John","Lennon","Course 1");

        Set<Course> coursesOfStudent = studentService.findCoursesOfStudent("John", "Lennon");
        mentorService.createTask("Course 1", "Task_1");
        mentorService.createTask("Course 1", "Task_2");
        mentorService.createTask("Course 2","Task_1");
        mentorService.createTask("Course 2","Task_2");
        Set<Student> studentsOfCourse = mentorService.findStudentsOfCourse("Course 1");
        mentorService.rateAndFeedbackStudentTask("John","Lennon","Task_1", "Course 1", 8, "task not done");
        */System.out.println(studentService.findReportsOfStudent("John","Lennon"));
    }

}
