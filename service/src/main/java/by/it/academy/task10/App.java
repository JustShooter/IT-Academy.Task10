package by.it.academy.task10;

import by.it.academy.task10.entity.Student;
import by.it.academy.task10.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {

        GeneralService generalService = new GeneralService();
        AdminService admin = new AdminService();
        admin.createStudent("One","Two");




//        RepositoryService service = new RepositoryService();
//        service.addStudent("John", "Weak");
//        service.addCourse("Java");
//        service.mapStudentToCourse("John", "Weak", "Java");

    }

}
