package by.it.academy.task10.services.interfaces;

import by.it.academy.task10.dto.CourseDto;
import by.it.academy.task10.dto.MarkReportDto;
import by.it.academy.task10.dto.StudentDto;
import by.it.academy.task10.dto.TaskDto;
import by.it.academy.task10.entity.Course;
import by.it.academy.task10.entity.MarkReport;
import by.it.academy.task10.entity.Task;
import by.it.academy.task10.entity.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface StudentService {

    List<TaskDto> findTasksOfCourseMy(String titleCourse);

    List<CourseDto> findCourseOfStudentMy(String nameStudent, String surnameStudent);

    void deleteTaskReport(Integer id);

    void updateTaskReport(Integer id, String feedback, Integer mark) throws SQLException;

    void addStudentToCourse(String name, String surname, String title) throws SQLException;

    Set<Course> findCoursesOfStudent(Integer idStudent) throws SQLException;

    Set<Task> findTasksOfCourse(String titleCourse) throws SQLException;

    Set<MarkReport> findReportsOfStudent(String nameStudent, String surnameOfStudent) throws SQLException;

    List<StudentDto> findAllStudents();

    Set<CourseDto> getCoursesOfStudent(Integer studentId) throws SQLException;

    Boolean updateStudent(Integer id, String name, String surname) throws SQLException;
}