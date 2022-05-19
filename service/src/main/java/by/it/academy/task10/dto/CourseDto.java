package by.it.academy.task10.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto implements Serializable {

    private Integer id;
    private String title;
    private Integer mentorId;
}
