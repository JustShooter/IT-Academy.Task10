package by.it.academy.task10.services.interfaces;

import by.it.academy.task10.dto.MentorDto;
import by.it.academy.task10.entity.Student;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface MentorService {
    void createTask(String titleCourse, String titleTask) throws SQLException;

    void deleteTask(String titleTask, String titleCourse) throws SQLException;

    void rateAndFeedbackStudentTask(String nameStudent, String surnameStudent,
                                    String titleTask, String titleCourse,
                                    Integer mark, String feedback) throws SQLException;

    Set<Student> findStudentsOfCourse(String titleCourse) throws SQLException;

    List<MentorDto> findAllMentors();

    String updateMentor(Integer id, String name, String surname) throws SQLException;
}
