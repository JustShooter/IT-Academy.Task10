package by.it.academy.task10.dto;

import by.it.academy.task10.entity.Mentor;
import lombok.Data;

import java.io.Serializable;

@Data
public class CourseDto implements Serializable {

    private final Integer id;
    private final String title;
    private final MentorDto mentor;
}
