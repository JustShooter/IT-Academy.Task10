package by.it.academy.task10.services.interfaces;

import by.it.academy.task10.dto.CourseDto;
import by.it.academy.task10.dto.MarkReportDto;
import by.it.academy.task10.dto.MentorDto;
import by.it.academy.task10.dto.StudentDto;
import by.it.academy.task10.dto.TaskDto;
import by.it.academy.task10.entity.Course;

import java.sql.SQLException;
import java.util.List;


public interface AdminService {
    MarkReportDto findReportById(Integer id) throws SQLException;

    TaskDto findTaskById(Integer id) throws SQLException;

    CourseDto findCourseById(Integer id) throws SQLException;

    StudentDto findStudentById(Integer id) throws SQLException;

    void createStudent(String name, String surname);

    void deleteStudent(Integer idUser) throws SQLException;

    void createMentor(String name, String surname);

    void deleteMentor(Integer idMentor) throws SQLException;

    void createCourse(String titleCourse);

    void deleteCourse(String titleCourse) throws SQLException;

    void addMentorToCourse(String name, String surname, String title) throws SQLException;

    void addStudentToCourse(String name, String surname, String title) throws SQLException;

    List<Course> getAllCourses();

    List<MentorDto> getAllMentors();

    Boolean changeMentorRecord(Integer id, String name, String surname) throws SQLException;

    MentorDto findMentorById(Integer id) throws SQLException;

    List<MarkReportDto> getAllReports();

    List<TaskDto> getAllTasks();
}
