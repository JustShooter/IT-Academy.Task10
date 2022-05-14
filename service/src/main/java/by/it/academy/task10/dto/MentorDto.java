package by.it.academy.task10.dto;

import by.it.academy.task10.entity.Mentor;
import lombok.Data;

import java.io.Serializable;

@Data
public class MentorDto implements Serializable {

    private final Integer id;
    private final String name;
    private final String surname;

}
