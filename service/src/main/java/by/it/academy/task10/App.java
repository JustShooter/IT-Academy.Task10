package by.it.academy.task10;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        AdminService service = new AdminService();
        MentorService ms = new MentorService();
        service.createStudent("John", "Weak");
        service.addCourse("Java");
        service.addStudentToCourse("John", "Weak", "Java");
        ms.createTask("Java", "Arrays");
    }
}
