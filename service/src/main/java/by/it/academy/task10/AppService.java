package by.it.academy.task10;

import by.it.academy.task10.entity.Course;
import by.it.academy.task10.entity.Student;

import java.sql.SQLException;
import java.util.Set;

public class AppService {
    public static void main(String[] args) throws SQLException {
        AdminService adminService = new AdminService();
        StudentService studentService = new StudentService();
        MentorService mentorService = new MentorService();
        adminService.createStudent("John","Lennon");
        adminService.createMentor("Elton","John");
        adminService.createCourse("Course 1");
        adminService.createCourse("Course 2");
        adminService.addMentorToCourse("Elton","John","Course 1");
        adminService.addStudentToCourse("John","Lennon","Course 1");
        adminService.createMentor("Evgeniy","Petrov");
        Set<Course> coursesOfStudent = studentService.findCoursesOfStudent("John", "Lennon");
        System.out.println(coursesOfStudent);
        mentorService.createTask("Course 1", "Task_1");
        mentorService.createTask("Course 1", "Task_2");
        mentorService.createTask("Course 2","Task_1");
        mentorService.createTask("Course 2","Task_2");
        Set<Student> studentsOfCourse = mentorService.findStudentsOfCourse("Course 1");
        System.out.println(studentsOfCourse);
        adminService.createMentor("Pavel", "Durov");
        adminService.addMentorToCourse("Pavel","Durov", "Course 2");
        mentorService.rateAndFeedbackStudentTask("John","Lennon","Task_1", "Course 2", 8, "task not done");
        System.out.println(studentService.findCoursesOfStudent("John","Lennon"));
        System.out.println(studentService.findTasksOfCourse("Course 1"));
        System.out.println(studentService.findReportsOfStudent("John","Lennon"));
    }

}
