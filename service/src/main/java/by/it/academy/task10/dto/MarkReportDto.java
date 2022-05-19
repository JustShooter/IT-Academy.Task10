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
public class MarkReportDto implements Serializable {
    private Integer id;
    private Integer mark;
    private String feedback;
    private StudentDto student;
    private TaskDto task;
    private MentorDto mentor;
}
