package by.it.academy.task10.dto.mapper;

import by.it.academy.task10.dto.CourseDto;
import by.it.academy.task10.entity.Course;

public class CourseMapper {

    private final MentorMapper mentorMapper = new MentorMapper();

    public CourseDto mapFrom(Course course) {
        return new CourseDto(course.getId(),
                course.getTitle(), mentorMapper.mapFrom(course.getMentor()));
    }
}
