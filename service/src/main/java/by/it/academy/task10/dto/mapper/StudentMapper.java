package by.it.academy.task10.dto.mapper;

import by.it.academy.task10.dto.StudentDto;
import by.it.academy.task10.entity.Student;

public class StudentMapper {

    public static StudentDto mapFrom(Student student) {
        return new StudentDto(student.getId(), student.getName(),
                student.getSurname());
    }
}
