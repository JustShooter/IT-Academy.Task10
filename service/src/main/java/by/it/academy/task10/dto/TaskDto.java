package by.it.academy.task10.dto;

import by.it.academy.task10.entity.Course;
import lombok.Data;

import java.io.Serializable;

@Data
public class TaskDto implements Serializable {

    private final Integer id;
    private final String title;
    private final CourseDto taskCourse;
}
