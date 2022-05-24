package by.it.academy.task10;

import by.it.academy.task10.dao.implementations.CourseDaoImpl;
import by.it.academy.task10.dao.implementations.MentorDaoImpl;
import by.it.academy.task10.dao.implementations.StudentDaoImpl;
import by.it.academy.task10.dao.interfaces.CourseDao;
import by.it.academy.task10.dao.interfaces.MentorDao;
import by.it.academy.task10.dao.interfaces.StudentDao;
import by.it.academy.task10.entity.Course;
import by.it.academy.task10.entity.Mentor;
import by.it.academy.task10.entity.Student;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImpl();
        MentorDao mentorDao = new MentorDaoImpl();
        CourseDao courseDao = new CourseDaoImpl();

        mentorDao.update(Mentor.builder()
                .name("Alex")
                .surname("Lex5")
                .id(14)
                .build());
        try {
            System.out.println(mentorDao.findOne(14).getSurname());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

/*
        courseDao.create(Course.builder()
                .title("C++")
                .build());
        courseDao.create(Course.builder()
                .title("Java")
                .build());
        courseDao.create(Course.builder()
                .title("Python")
                .build());*/


     /*   studentDao.create(Student.builder()
                .name("John")
                .surname("Weak")
                .build());
        studentDao.create(Student.builder()
                .name("John")
                .surname("Weak")
                .build());
        studentDao.create(Student.builder()
                .name("John")
                .surname("Smith")
                .build());
        studentDao.create(Student.builder()
                .name("Peter")
                .surname("Parker")
                .build());
        mentorDao.create(Mentor.builder()
                .name("Jonny")
                .surname("Silverhand")
                .build());

        mentorDao.create(Mentor.builder()
                .name("Gena")
                .surname("Vlasik")
                .build());
*/
   /*     mentorDao.create(Mentor.builder()
                .name("Bill")
                .surname("Gates")
                .build());

*/
//        List<Student> studentList = manager.createQuery("from " + Student.class.getName()).getResultList();
//        Student std = studentList.stream()
//                .filter(student -> student.getName().equals("Gena")
//                        && student.getSurname().equals("Vlasik"))
//                .findFirst().orElse(null);
//        Integer id = null;
//        if (std != null) {
//            id = std.getId();
//        }
//        System.out.println(id);

    }
}
