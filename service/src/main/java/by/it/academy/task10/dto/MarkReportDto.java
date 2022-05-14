package by.it.academy.task10.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class MarkReportDto implements Serializable {
    private final Integer id;
    private final Integer mark;
    private final String feedback;
    private final StudentDto student;
    private final TaskDto task;
    private final MentorDto mentor;
}
