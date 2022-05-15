package by.it.academy.task10.services.interfaces;

import by.it.academy.task10.entity.Course;

import java.sql.SQLException;
import java.util.List;

public interface AdminService {
    void createStudent(String name, String surname);

    void deleteStudent(String name, String surname) throws SQLException;

    void addStudentToCourse(String name, String surname, String title) throws SQLException;

    void createMentor(String name, String surname);

    void deleteMentor(String name, String surname) throws SQLException;

    void createCourse(String titleCourse);

    void deleteCourse(String titleCourse) throws SQLException;

    void addMentorToCourse(String name, String surname, String title) throws SQLException;

    List<Course> getAllCourses();
}
