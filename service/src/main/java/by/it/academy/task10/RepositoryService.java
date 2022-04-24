package by.it.academy.task10;


import by.it.academy.task10.dao.Dao;
import by.it.academy.task10.entity.Course;
import by.it.academy.task10.entity.Student;

import java.sql.SQLException;
import java.util.Set;

public class RepositoryService {
    private Dao<Student> studentDao = new Dao<>(Student.class);
    private Dao<Course> courseDao = new Dao<>(Course.class);

    public boolean addStudent(String name, String surname) {
        Student rt = studentDao.create(Student.builder()
                .name(name)
                .surname(surname)
                .role("Student")
                .build());
        return (rt != null);
    }

    public void addCourse(String name){
        courseDao.create(Course.builder().title(name).build());
    }

    public void mapStudentToCourse(String studentName, String studentSurname, String courseName){
        Student std = null;
        Course course = null;
        try {
            std = studentDao.findOne(Student.builder().name(studentName).surname(studentSurname).role("Student").build());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            course = courseDao.findOne(Course.builder().title(courseName).build());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Set<Course> set = std.getCourses();
        set.add(course);
        std.setCourses(set);
        studentDao.update(std);
    }

}
