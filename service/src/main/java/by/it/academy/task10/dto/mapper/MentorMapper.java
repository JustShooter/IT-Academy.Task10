package by.it.academy.task10.dto.mapper;

import by.it.academy.task10.dto.MentorDto;
import by.it.academy.task10.entity.Mentor;

public class MentorMapper {

    public MentorDto mapFrom(Mentor mentor) {
        return new MentorDto(mentor.getId(), mentor.getName(), mentor.getSurname());
    }
}
