package by.it.academy.task10.dto.mapper;

import by.it.academy.task10.dto.CourseDto;
import by.it.academy.task10.entity.Course;

public class CourseMapper {

    public static CourseDto mapFrom(Course course) {
        return new CourseDto(course.getId(),
                course.getTitle(), course.getMentor().getId());
    }
}
