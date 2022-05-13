package by.it.academy.task10.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudentDto implements Serializable {
    private final Integer id;
    private final String name;
    private final String surname;
}
